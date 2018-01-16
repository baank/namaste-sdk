package com.naden.sdk.plugin

import com.naden.sdk.models.{Component, Parameter}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
trait PanelType extends Service {

  def scripts: List[String] = List.empty

  def stylesheets: List[String] = List.empty

  def userEditable: Boolean = true

  def layout(parameterValues: List[(Parameter, String)]): List[Component]

  // TODO
 // def layout(parameterValues: List[ParameterValue]): Layout[Component]

  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean

}