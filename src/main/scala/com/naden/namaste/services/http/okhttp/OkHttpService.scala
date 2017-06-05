package com.naden.namaste.services.http.okhttp

import java.net.{InetSocketAddress, Proxy}
import java.util.concurrent.TimeUnit
import javax.inject.{Inject, Singleton}

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.naden.namaste.plugin.Parameter
import com.naden.namaste.services.http.{AuthType, HttpProxy, HttpService}
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.{Credentials, RequestBody, _}
import okio.{BufferedSink, Okio}

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class OkHttpService @Inject()(implicit val proxy: HttpProxy)
    extends HttpService {

  private val objectMapper: ObjectMapper = new ObjectMapper
  private val httpClient: OkHttpClient = newClient()

  def instanceParameters: Seq[Parameter[_]] = Seq.empty
  def globalParameters: Seq[Parameter[_]] = Seq.empty
  def onStartup(): Unit = ()
  def onShutdown(): Unit = ()
  def onConfigured(parameters: Map[Parameter[_], _]): Unit = ()

  def get(url: String,
          params: Map[String, String],
          headers: Map[String, String]): Future[String] =
    Future {
      val request =
        requestBuilder(url, params, headers, json = false).get().build()
      httpClient.newCall(request).execute().body().string()
    }

  def getAsJson(url: String,
                params: Map[String, String],
                headers: Map[String, String]): Future[JsonNode] =
    get(url, params, headers).transform(_.map(objectMapper.readTree))

  def post(url: String,
           params: Map[String, String],
           body: String,
           mimeType: String,
           headers: Map[String, String]): Future[String] =
    Future {
      val requestBody =
        RequestBody.create(MediaType.parse(mimeType + "; charset=utf-8"), body)
      val request = requestBuilder(url, params, headers, json = false)
        .get()
        .post(requestBody)
        .build()
      httpClient.newCall(request).execute.body().toString
    }

  def postAsJson(url: String,
                 params: Map[String, String],
                 body: String,
                 mimeType: String,
                 headers: Map[String, String]): Future[JsonNode] = {
    post(url, params, body, mimeType, headers).transform(
      _.map(objectMapper.readTree))
  }

  def post(url: String,
           params: Map[String, String],
           body: Map[String, String],
           headers: Map[String, String]): Future[String] = Future {

    val formBodyBuilder = new FormBody.Builder()
    body.foreach { case (k, v) => formBodyBuilder.add(k, v) }
    val request = requestBuilder(url, params, headers, json = false)
      .get()
      .post(formBodyBuilder.build())
      .build()
    httpClient.newCall(request).execute.body().toString
  }

  def postAsJson(url: String,
                 params: Map[String, String],
                 body: Map[String, String],
                 headers: Map[String, String]): Future[JsonNode] =
    post(url, params, body, headers).transform(_.map(objectMapper.readTree))

  def binaryPost(url: String,
                 params: Map[String, String],
                 resourcePath: String,
                 headers: Map[String, String]): Future[String] = Future {
    val inputStream =
      classOf[HttpService].getClassLoader.getResourceAsStream(resourcePath)
    val requestBody = new RequestBody {

      override def writeTo(sink: BufferedSink): Unit = {
        val source = Okio.source(inputStream)
        sink.writeAll(source)
        source.close()
      }

      override def contentLength(): Long = inputStream.available()

      override def contentType(): MediaType =
        MediaType.parse("application/binary")
    }
    val request = requestBuilder(url, params, headers, json = false)
      .get()
      .post(requestBody)
      .build()
    httpClient.newCall(request).execute.body().toString
  }

  def put(url: String,
          params: Map[String, String],
          body: String,
          mimeType: String,
          headers: Map[String, String]): Future[String] = Future {

    val requestBody =
      RequestBody.create(MediaType.parse(mimeType + "; charset=utf-8"), body)
    val request = requestBuilder(url, params, headers, json = false)
      .get()
      .put(requestBody)
      .build()
    httpClient.newCall(request).execute.body().toString
  }

  def putAsJson(url: String,
                params: Map[String, String],
                body: String,
                mimeType: String,
                headers: Map[String, String]): Future[JsonNode] = {
    put(url, params, body, mimeType, headers).transform(
      _.map(objectMapper.readTree))
  }

  private def newClient() = {
    val engine = new NTLMEngineImpl()
    val ntlmMsg1 = engine.generateType1Msg(null, null)

    val basicProxyAuthenticator = new Authenticator() {

      def authenticate(route: Route, response: Response): Request = {
        val credential = Credentials.basic(proxy.username, proxy.password)
        response.request.newBuilder
          .header("Proxy-Authorization", credential)
          .build
      }
    }

    val ntlmProxyAuthenticator = new Authenticator() {

      def authenticate(route: Route, response: Response): Request = {
        val WWWAuthenticate = response.headers.values("WWW-Authenticate")
        if (WWWAuthenticate.contains("NTLM"))
          return response.request.newBuilder
            .header("Authorization", "NTLM " + ntlmMsg1)
            .build
        val ntlmMsg3 = engine.generateType3Msg(
          proxy.username,
          proxy.password,
          proxy.domain,
          "android-device",
          WWWAuthenticate.get(0).substring(5))
        response.request.newBuilder
          .header("Authorization", "NTLM " + ntlmMsg3)
          .build
      }
    }

    new OkHttpClient.Builder()
      .connectTimeout(60, TimeUnit.SECONDS)
      .writeTimeout(60, TimeUnit.SECONDS)
      .readTimeout(60, TimeUnit.SECONDS)
      .addInterceptor(new HttpLoggingInterceptor())
      .proxy(proxy.authenticationType match {
        case AuthType.None => Proxy.NO_PROXY
        case _ =>
          new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress(proxy.host, proxy.port))
      })
      .proxyAuthenticator(proxy.authenticationType match {
        case AuthType.None => Authenticator.NONE
        case AuthType.Basic => basicProxyAuthenticator
        case AuthType.NTLM => ntlmProxyAuthenticator
      })
      .build
  }

  private def requestBuilder(url: String,
                             params: Map[String, String],
                             headers: Map[String, String],
                             json: Boolean) = {
    val urlBuilder = new HttpUrl.Builder()
    params.foreach { case (k, v) => urlBuilder.addQueryParameter(k, v) }
    urlBuilder.build()

    val requestBuilder =
      new Request.Builder()
        .url(url)
        .headers(Headers.of(headers.asJava))
        .header(
          "User-Agent",
          "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0")
    if (json) requestBuilder.addHeader("accept", "application/json")
    requestBuilder
  }
}
