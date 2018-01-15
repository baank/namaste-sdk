package com.naden.sdk.plugin

import com.naden.sdk.models.{Component, Layout, ParameterValue}
import io.circe.{Decoder, Encoder}

import scala.collection.mutable

trait PanelType extends Service {

  def scripts: List[String] = List.empty

  def stylesheets: List[String] = List.empty

  def userEditable: Boolean = true

  def layout(parameterValues: List[ParameterValue]): List[Component]

  // TODO
 // def layout(parameterValues: List[ParameterValue]): Layout[Component]

  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean

}

object PanelType {
  val allPanelTypes: mutable.Map[String,PanelType] = mutable.Map.empty
}