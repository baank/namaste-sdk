package com.naden.sdk.models

import boopickle.Default._
import com.naden.sdk.models.parameters._

trait Parameter {
  def key: String
  def title: String
  def description: String
  def group: Option[String]
  def required: Boolean
}

object Parameter {

  implicit val parameters: Pickler[Parameter] = compositePickler[Parameter].
      addConcreteType[BooleanParameter].
      addConcreteType[ColorParameter].
      addConcreteType[ConnectionParameter].
      addConcreteType[CurrencyParameter].
      addConcreteType[DateTimeParameter].
      addConcreteType[DecimalParameter].
      addConcreteType[DecimalRangeParameter].
      addConcreteType[EmailParameter].
      addConcreteType[FileParameter].
      addConcreteType[GeoAddressParameter].
      addConcreteType[GeoLocationParameter].
      addConcreteType[HtmlParameter].
      addConcreteType[ImageParameter].
      addConcreteType[IntegerParameter].
      addConcreteType[IntegerRangeParameter].
      addConcreteType[IPAddressParameter].
      addConcreteType[NewPasswordParameter].
      addConcreteType[PageParameter].
      addConcreteType[SearchQueryParameter].
      addConcreteType[StringParameter].
      addConcreteType[TabularDataParameter].
      addConcreteType[TagsParameter].
      addConcreteType[URIParameter].
      addConcreteType[UserParameter].
      addConcreteType[VideoParameter]
}