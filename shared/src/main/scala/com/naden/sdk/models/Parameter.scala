package com.naden.sdk.models

import java.time.Instant

import squants.Money
import com.naden.sdk.util.CirceCodecs._
import enumeratum._

sealed trait DateTimeStyle extends EnumEntry
case object DateTimeStyle extends Enum[DateTimeStyle] with CirceEnum[DateTimeStyle] {
  case object None extends DateTimeStyle
  case object Short extends DateTimeStyle
  case object Medium extends DateTimeStyle
  case object Long extends DateTimeStyle
  case object Full extends DateTimeStyle
  val values = findValues
}

sealed trait Parameter extends EnumEntry {
  def key: String
  def title: String
  def description: String
  def group: Option[String]
  def required: Boolean
}

case object Parameter extends Enum[Parameter] with CirceEnum[Parameter] {

  case class BooleanParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[String] = None,
                              required: Boolean,
                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class ColorParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Color] = None,
                            required: Boolean,
                            options: Seq[Color] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class ConnectionParameter(key: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[Connection] = None,
                                 required: Boolean,
                                 validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class CurrencyParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Money] = None,
                               required: Boolean,
                               options: Seq[Money] = Seq(),
                               validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class DateTimeParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Instant] = None,
                               required: Boolean,
                               dateOptions: Seq[Instant] = Seq(),
                               dateStyle: DateTimeStyle = DateTimeStyle.Short,
                               timeStyle: DateTimeStyle = DateTimeStyle.Short,
                               validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class DecimalParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[BigDecimal] = None,
                              required: Boolean,
                              options: Seq[BigDecimal] = Seq(),
                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class DecimalRangeParameter(key: String,
                                   title: String,
                                   description: String,
                                   group: Option[String],
                                   default: Option[BigDecimal] = None,
                                   required: Boolean,
                                   minimumValue: BigDecimal = 0.0,
                                   maximumValue: BigDecimal = 100.0,
                                   validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class EmailParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class FileParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[File] = None,
                           required: Boolean,
                           validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class GeoAddressParameter(key: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[String] = None,
                                 required: Boolean,
                                 validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class GeoLocationParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  default: Option[String] = None,
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class HtmlParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class ImageParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class IntegerParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[Integer] = None,
                              required: Boolean,
                              options: Seq[Integer] = Seq(),
                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class IntegerRangeParameter(key: String,
                                   title: String,
                                   description: String,
                                   group: Option[String],
                                   default: Option[Integer] = None,
                                   required: Boolean,
                                   minimumValue: Integer = 0,
                                   maximumValue: Integer = 100,
                                   validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class IPAddressParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                default: Option[String] = None,
                                required: Boolean,
                                options: Seq[String] = Seq(),
                                validators: List[ParameterValidator] = List()) extends Parameter with Serializable

// TODO
//  case class ListParameter[A](key: String,
//                              title: String,
//                              description: String,
//                              group: Option[String],
//                              default: Option[A] = None,
//                              required: Boolean,
//                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class NewPasswordParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  default: Option[String] = None,
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class PageParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[Page] = None,
                           required: Boolean,
                           validators: List[ParameterValidator]) extends Parameter with Serializable

  case class PasswordParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               required: Boolean,
                               validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class SearchQueryParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  required: Boolean) extends Parameter with Serializable

  case class StringParameter(key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[String] = None,
                             required: Boolean,
                             idealLength: Option[(Int, Int)] = None,
                             maxLength: Option[Int] = None,
                             inputFormat: Option[String] = None,
                             options: List[String] = List(),
                             validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class TabularDataParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class TagsParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           limit: Option[Int] = None,
                           allowDuplicates: Boolean = true,
                           validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class URIParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          default: Option[String] = None,
                          required: Boolean,
                          validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class UserParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           required: Boolean) extends Parameter with Serializable

  case class VideoParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable
  val values = findValues
}