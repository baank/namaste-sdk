package com.naden.sdk.plugin

import com.naden.sdk.models.{Layout, Parameter}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
trait PageType extends Service {

  def detailLayout(parameterValues: Map[Parameter, String]): Layout

  def listLayout(parameterValues: Map[Parameter, String]): Layout

  def linkedPanelTypes: Set[PanelType] = Set.empty

}