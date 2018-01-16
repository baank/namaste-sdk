package com.naden.sdk.plugin

import com.naden.sdk.models.{Layout, ParameterValue}

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

@EnableReflectiveInstantiation
trait PageType extends Service {

  def detailLayout(parameterValues: List[ParameterValue]): Layout

  def listLayout(parameterValues: List[ParameterValue]): Layout

  def linkedPanelTypes: Set[PanelType] = Set.empty

}