package com.naden.namaste.services.http.okhttp

import java.io.InputStream
import java.net.{InetSocketAddress, Proxy}
import java.util
import java.util.concurrent.TimeUnit
import javax.inject.{Inject, Singleton}

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.naden.namaste.services.http.{AuthType, HttpProxy, HttpService}
import okhttp3._
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.{Level, Logger}
import okio.{BufferedSink, Okio}

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class OkHttpService @Inject ()(proxy: HttpProxy) extends HttpService {

  private val objectMapper: ObjectMapper = new ObjectMapper
  private val httpClient: OkHttpClient = newClient()

  def asyncGet(url: String,
               params: Map[String, String],
               headers: Map[String, String]): Future[String] = Future {
    get(url, params, headers)
  }

  def get(url: String,
          params: Map[String, String],
          headers: Map[String, String]): String = {
    val request =
      requestBuilder(url, params, headers, json = false).get().build()
    val response = httpClient.newCall(request).execute()
    response.body().string()
  }

  def asyncGetAsBytes(url: String,
                      params: Map[String, String],
                      headers: Map[String, String]): Future[Array[Byte]] = Future {
    getAsBytes(url, params, headers)
  }

  def getAsBytes(url: String,
                 params: Map[String, String],
                 headers: Map[String, String]): Array[Byte] = {
    val request =
      requestBuilder(url, params, headers, json = false).get().build()
    val response = httpClient.newCall(request).execute()
    response.body().bytes()
  }

  def asyncGetAsJson(url: String,
                     params: Map[String, String],
                     headers: Map[String, String]): Future[JsonNode] =
    asyncGet(url, params, headers).transform(objectMapper.readTree, throw _)

  def getAsJson(url: String,
                params: Map[String, String],
                headers: Map[String, String]): JsonNode =
    objectMapper.readTree(get(url, params, headers))


  def asyncPost(url: String,
                body: String,
                mimeType: String,
                params: Map[String, String],
                headers: Map[String, String]): Future[String] = Future {
    post(url, body, mimeType, params, headers)
  }

  def post(url: String,
           body: String,
           mimeType: String,
           params: Map[String, String],
           headers: Map[String, String]): String = {
    val requestBody =
      RequestBody.create(MediaType.parse(mimeType + "; charset=utf-8"), body)
    val request = requestBuilder(url, params, headers, json = false)
      .post(requestBody)
      .build()
    val response = httpClient.newCall(request).execute
    response.body().string()
  }

  def asyncPostAsJson(url: String,
                      body: String,
                      params: Map[String, String],
                      headers: Map[String, String]): Future[JsonNode] = {
    asyncPost(url, body, "application/json", params, headers).transform(objectMapper.readTree, throw _)
  }

  def postAsJson(url: String,
                 body: String,
                 params: Map[String, String],
                 headers: Map[String, String]): JsonNode =
    objectMapper.readTree(post(url, body, "application/json", params, headers))

  def asyncPostForm(url: String,
                    formBody: Map[String, String],
                    params: Map[String, String],
                    headers: Map[String, String]): Future[String] = Future {
    postForm(url, formBody, params, headers)
  }

  def postForm(url: String,
               formBody: Map[String, String],
               params: Map[String, String],
               headers: Map[String, String]): String = {

    val formBodyBuilder = new FormBody.Builder()
    formBody.foreach { case (k, v) => formBodyBuilder.add(k, v) }
    val request = requestBuilder(url, params, headers, json = false)
      .post(formBodyBuilder.build())
      .build()
    httpClient.newCall(request).execute.body().toString
  }

  def asyncPostFormAsJson(url: String,
                          body: Map[String, String],
                          params: Map[String, String],
                          headers: Map[String, String]): Future[JsonNode] =
    asyncPostForm(url, params, body, headers).transform(objectMapper.readTree, throw _)

  def postFormAsJson(url: String,
                     body: Map[String, String],
                     params: Map[String, String],
                     headers: Map[String, String]): JsonNode =
    objectMapper.readTree(postForm(url, params, body, headers))

  def asyncBinaryPost(url: String,
                      resourcePath: String,
                      mimeType: String,
                      fileName: String,
                      params: Map[String, String],
                      headers: Map[String, String]): Future[String] = Future {
    binaryPost(url, resourcePath, mimeType, fileName, params, headers)
  }

  def binaryPost(url: String,
                 resourcePath: String,
                 mimeType: String,
                 fileName: String,
                 params: Map[String, String],
                 headers: Map[String, String]): String = {
    val inputStream =
      classOf[HttpService].getClassLoader.getResourceAsStream(resourcePath)
    streamPost(url, inputStream, mimeType, fileName, params, headers)
  }

  def asyncStreamPost(url: String,
                      inputStream: InputStream,
                      mimeType: String,
                      fileName: String,
                      params: Map[String, String],
                      headers: Map[String, String]): Future[String] = Future {
    streamPost(url, inputStream, mimeType, fileName, params, headers)
  }

  def streamPost(url: String,
                 inputStream: InputStream,
                 mimeType: String,
                 fileName: String,
                 params: Map[String, String],
                 headers: Map[String, String]): String = {

    val requestBody = new RequestBody {

      override def writeTo(sink: BufferedSink): Unit = {
        val source = Okio.source(inputStream)
        sink.writeAll(source)
        source.close()
      }

      override def contentLength(): Long = inputStream.available()
      override def contentType(): MediaType = MediaType.parse(mimeType)
    }

    val request = requestBuilder(url, params, headers, json = false)
      .post(requestBody)
      .build()
    httpClient.newCall(request).execute.body().string()
  }

  def asyncPut(url: String,
               body: String,
               mimeType: String,
               params: Map[String, String],
               headers: Map[String, String]): Future[String] = Future {
    put(url, body, mimeType, params, headers)
  }

  def put(url: String,
          body: String,
          mimeType: String,
          params: Map[String, String],
          headers: Map[String, String]): String = {
    val requestBody =
      RequestBody.create(MediaType.parse(mimeType + "; charset=utf-8"), body)
    val request = requestBuilder(url, params, headers, json = false)
      .put(requestBody)
      .build()
    httpClient.newCall(request).execute.body().string()
  }

  def asyncPutAsJson(url: String,
                     body: String,
                     params: Map[String, String],
                     headers: Map[String, String]): Future[JsonNode] = Future {
    putAsJson(url, body, params, headers)
  }

  def putAsJson(url: String,
                body: String,
                params: Map[String, String],
                headers: Map[String, String]): JsonNode = {
    objectMapper.readTree(put(url, body, "application/json", params, headers))
  }

  def asyncDelete(url: String,
                  params: Map[String, String],
                  headers: Map[String, String]): Future[String] = Future {
    delete(url, params, headers)
  }

  def delete(url: String,
             params: Map[String, String],
             headers: Map[String, String]): String = {
    val request =
      requestBuilder(url, params, headers, json = false).delete().build()
    httpClient.newCall(request).execute().body().string()
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

    val loggingInterceptor = new HttpLoggingInterceptor(new Logger() {
      @Override def log(message: String): Unit = {
        //play.api.Logger.debug(message)
      }
    })
    loggingInterceptor.setLevel(Level.HEADERS)

    new OkHttpClient.Builder()
      .connectTimeout(60, TimeUnit.SECONDS)
      .writeTimeout(60, TimeUnit.SECONDS)
      .readTimeout(60, TimeUnit.SECONDS)
      .addInterceptor(loggingInterceptor)
      .proxy(proxy.authenticationType() match {
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
      .cookieJar(new CookieJar() {

        private val cookies = new util.ArrayList[Cookie]()

        override def saveFromResponse(url: HttpUrl, cookies: util.List[Cookie]) = {
          this.cookies.clear()
          this.cookies.addAll(cookies)
        }

        override def loadForRequest(url: HttpUrl) = {
          this.cookies
        }
      })
      .build
  }



  private def requestBuilder(url: String,
                             params: Map[String, String],
                             headers: Map[String, String],
                             json: Boolean) = {
    //    val urlBuilder = new HttpUrl.Builder().
    //    params.foreach { case (k, v) => urlBuilder.addQueryParameter(k, v) }
    //    urlBuilder.build()

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