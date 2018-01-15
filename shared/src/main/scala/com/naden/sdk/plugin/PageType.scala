package com.naden.sdk.plugin

import com.naden.sdk.models.{Layout, ParameterValue}

import scala.collection.mutable

trait PageType[T] extends Service {

  def detailLayout(parameterValues: List[ParameterValue]): Layout

  def listLayout(parameterValues: List[ParameterValue]): Layout

  def linkedPanelTypes: Set[PanelType] = Set.empty

}

object PageType {
	val allPageTypes: mutable.Map[String, PageType[_]] = mutable.Map.empty
}