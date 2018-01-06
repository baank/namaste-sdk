package com.naden.sdk.services.http

import java.io.InputStream

import com.fasterxml.jackson.databind.JsonNode

import scala.concurrent.Future

trait HttpService {

  def asyncGet(url: String,
               params: Map[String, String] = Map.empty,
               headers: Map[String, String] = Map.empty): Future[String]

  def get(url: String,
          params: Map[String, String] = Map.empty,
          headers: Map[String, String] = Map.empty): String

  def asyncGetAsBytes(url: String,
                      params: Map[String, String] = Map.empty,
                      headers: Map[String, String] = Map.empty): Future[Array[Byte]]

  def getAsBytes(url: String,
                 params: Map[String, String] = Map.empty,
                 headers: Map[String, String] = Map.empty): Array[Byte]

  def asyncGetAsJson(url: String,
                     params: Map[String, String] = Map.empty,
                     headers: Map[String, String] = Map.empty): Future[JsonNode]

  def getAsJson(url: String,
                params: Map[String, String] = Map.empty,
                headers: Map[String, String] = Map.empty): JsonNode

  def asyncPost(url: String,
                body: String,
                mimeType: String,
                params: Map[String, String] = Map.empty,
                headers: Map[String, String] = Map.empty): Future[String]

  def post(url: String,
           body: String,
           mimeType: String,
           params: Map[String, String] = Map.empty,
           headers: Map[String, String] = Map.empty): String

  def asyncPostAsJson(url: String,
                      body: String,
                      params: Map[String, String] = Map.empty,
                      headers: Map[String, String] = Map.empty): Future[JsonNode]

  def postAsJson(url: String,
                 body: String,
                 params: Map[String, String] = Map.empty,
                 headers: Map[String, String] = Map.empty): JsonNode

  def postForm(url: String,
               formBody: Map[String, String],
               params: Map[String, String] = Map.empty,
               headers: Map[String, String] = Map.empty): String

  def asyncPostForm(url: String,
                    formBody: Map[String, String],
                    params: Map[String, String] = Map.empty,
                    headers: Map[String, String] = Map.empty): Future[String]

  def asyncPostFormAsJson(url: String,
                          formBody: Map[String, String],
                          params: Map[String, String] = Map.empty,
                          headers: Map[String, String] = Map.empty): Future[JsonNode]

  def postFormAsJson(url: String,
                     formBody: Map[String, String],
                     params: Map[String, String] = Map.empty,
                     headers: Map[String, String] = Map.empty): JsonNode

  def asyncBinaryPost(url: String,
                      resourcePath: String,
                      mimeType: String,
                      fileName: String,
                      params: Map[String, String] = Map.empty,
                      headers: Map[String, String] = Map.empty): Future[String]

  def binaryPost(url: String,
                 resourcePath: String,
                 mimeType: String,
                 fileName: String,
                 params: Map[String, String] = Map.empty,
                 headers: Map[String, String] = Map.empty): String

  def asyncStreamPost(url: String,
                      inputStream: InputStream,
                      mimeType: String,
                      fileName: String,
                      params: Map[String, String] = Map.empty,
                      headers: Map[String, String] = Map.empty): Future[String]

  def streamPost(url: String,
                 inputStream: InputStream,
                 mimeType: String,
                 fileName: String,
                 params: Map[String, String] = Map.empty,
                 headers: Map[String, String] = Map.empty): String

  def asyncPut(url: String,
               body: String,
               mimeType: String,
               params: Map[String, String] = Map.empty,
               headers: Map[String, String] = Map.empty): Future[String]

  def put(url: String,
          body: String,
          mimeType: String,
          params: Map[String, String] = Map.empty,
          headers: Map[String, String] = Map.empty): String

  def asyncPutAsJson(url: String,
                     body: String,
                     params: Map[String, String] = Map.empty,
                     headers: Map[String, String] = Map.empty): Future[JsonNode]

  def putAsJson(url: String,
                body: String,
                params: Map[String, String] = Map.empty,
                headers: Map[String, String] = Map.empty): JsonNode

  def asyncDelete(url: String,
                  params: Map[String, String] = Map.empty,
                  headers: Map[String, String] = Map.empty): Future[String]

  def delete(url: String,
             params: Map[String, String] = Map.empty,
             headers: Map[String, String] = Map.empty): String
}