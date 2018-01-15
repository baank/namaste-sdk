package com.naden.sdk.models

import java.net.URI
import java.time.LocalDateTime

import io.circe.generic.JsonCodec
import squants.Money

import com.naden.sdk.util.CirceCodec._

@JsonCodec
sealed trait DateTimeStyle
object DateTimeStyle {
  case object None extends DateTimeStyle
  case object Short extends DateTimeStyle
  case object Medium extends DateTimeStyle
  case object Long extends DateTimeStyle
  case object Full extends DateTimeStyle
}

@JsonCodec
sealed trait Parameter
object Parameter {

  case class BooleanParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[String] = None,
                              required: Boolean,
                              validators: List[ParameterValidator] = List()) extends Parameter

  case class ColorParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Color] = None,
                            required: Boolean,
                            options: Seq[Color] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter

  case class ConnectionParameter(key: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[Connection] = None,
                                 required: Boolean,
                                 validators: List[ParameterValidator] = List()) extends Parameter

  case class CurrencyParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Money] = None,
                               required: Boolean,
                               options: Seq[Money] = Seq(),
                               validators: List[ParameterValidator] = List()) extends Parameter

  case class DateTimeParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[LocalDateTime] = None,
                               required: Boolean,
                               dateOptions: Seq[LocalDateTime] = Seq(),
                               dateStyle: DateTimeStyle = DateTimeStyle.Short,
                               timeStyle: DateTimeStyle = DateTimeStyle.Short,
                               validators: List[ParameterValidator] = List()) extends Parameter

  case class DecimalParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[BigDecimal] = None,
                              required: Boolean,
                              options: Seq[BigDecimal] = Seq(),
                              validators: List[ParameterValidator] = List()) extends Parameter

  case class DecimalRangeParameter(key: String,
                                   title: String,
                                   description: String,
                                   group: Option[String],
                                   default: Option[BigDecimal] = None,
                                   required: Boolean,
                                   minimumValue: BigDecimal = 0.0,
                                   maximumValue: BigDecimal = 100.0,
                                   validators: List[ParameterValidator] = List()) extends Parameter

  case class EmailParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter

  case class FileParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[File] = None,
                           required: Boolean,
                           validators: List[ParameterValidator] = List()) extends Parameter

  case class GeoAddressParameter(key: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[String] = None,
                                 required: Boolean,
                                 validators: List[ParameterValidator] = List()) extends Parameter

  case class GeoLocationParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  default: Option[String] = None,
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List()) extends Parameter

  case class HtmlParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           validators: List[ParameterValidator] = List()) extends Parameter

  case class ImageParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter

  case class IntegerParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[Integer] = None,
                              required: Boolean,
                              options: Seq[Integer] = Seq(),
                              validators: List[ParameterValidator] = List()) extends Parameter

  case class IntegerRangeParameter(key: String,
                                   title: String,
                                   description: String,
                                   group: Option[String],
                                   default: Option[Integer] = None,
                                   required: Boolean,
                                   minimumValue: Integer = 0,
                                   maximumValue: Integer = 100,
                                   validators: List[ParameterValidator] = List()) extends Parameter

  case class IPAddressParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                default: Option[String] = None,
                                required: Boolean,
                                options: Seq[String] = Seq(),
                                validators: List[ParameterValidator] = List()) extends Parameter

  // TODO
//  case class ListParameter[A](key: String,
//                              title: String,
//                              description: String,
//                              group: Option[String],
//                              default: Option[A] = None,
//                              required: Boolean,
//                              validators: List[ParameterValidator] = List()) extends Parameter

  case class NewPasswordParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  default: Option[String] = None,
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List()) extends Parameter

  case class PageParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[Page] = None,
                           required: Boolean,
                           validators: List[ParameterValidator]) extends Parameter

  case class PasswordParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               required: Boolean,
                               validators: List[ParameterValidator] = List()) extends Parameter

  case class SearchQueryParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  required: Boolean) extends Parameter

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
                             validators: List[ParameterValidator] = List()) extends Parameter

  case class TabularDataParameter(key: String,
                                  title: String,
                                  description: String,
                                  group: Option[String],
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List()) extends Parameter

  case class TagsParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           limit: Option[Int] = None,
                           allowDuplicates: Boolean = true,
                           validators: List[ParameterValidator] = List()) extends Parameter

  case class URIParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          default: Option[String] = None,
                          required: Boolean,
                          validators: List[ParameterValidator] = List()) extends Parameter

  case class UserParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           required: Boolean) extends Parameter

  case class VideoParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter
}