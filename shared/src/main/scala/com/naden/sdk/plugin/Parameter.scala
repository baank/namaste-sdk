package com.naden.sdk.plugin

trait Parameter {
  def key: String
  def title: String
  def description: String
  def group: Option[String]
  def validators: Seq[ParameterValidator]
}
