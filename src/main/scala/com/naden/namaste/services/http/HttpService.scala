package com.naden.namaste.services.http

import com.fasterxml.jackson.databind.JsonNode
import com.naden.namaste.plugin.Service

import scala.concurrent.Future

trait HttpService extends Service {

  def get(url: String,
          params: Map[String, String],
          headers: Map[String, String]): Future[String]

  def getAsJson(url: String,
                params: Map[String, String],
                headers: Map[String, String]): Future[JsonNode]

  def post(url: String,
           params: Map[String, String],
           body: String,
           mimeType: String,
           headers: Map[String, String]): Future[String]

  def post(url: String,
           params: Map[String, String],
           body: Map[String, String],
           headers: Map[String, String]): Future[String]

  def postAsJson(url: String,
                 params: Map[String, String],
                 body: String,
                 mimeType: String,
                 headers: Map[String, String]): Future[JsonNode]

  def postAsJson(url: String,
                 params: Map[String, String],
                 body: Map[String, String],
                 headers: Map[String, String]): Future[JsonNode]

  def binaryPost(url: String,
                 params: Map[String, String],
                 resourcePath: String,
                 headers: Map[String, String]): Future[String]

  def put(url: String,
          params: Map[String, String],
          body: String,
          mimeType: String,
          headers: Map[String, String]): Future[String]

  def putAsJson(url: String,
                params: Map[String, String],
                body: String,
                mimeType: String,
                headers: Map[String, String]): Future[JsonNode]
}
