package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import squants.Money
import com.naden.sdk.util.CirceCodecs._
import enumeratum._

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

sealed trait DateTimeStyle extends EnumEntry
case object DateTimeStyle extends Enum[DateTimeStyle] with CirceEnum[DateTimeStyle] {
  case object None extends DateTimeStyle
  case object Short extends DateTimeStyle
  case object Medium extends DateTimeStyle
  case object Long extends DateTimeStyle
  case object Full extends DateTimeStyle
  val values = findValues
}

@EnableReflectiveInstantiation
sealed trait Parameter extends EnumEntry {
  def title: String
  def description: String
  def group: Option[String]
  def required: Boolean
  def id: ParameterId
}

@EnableReflectiveInstantiation
case object Parameter extends Enum[Parameter] with CirceEnum[Parameter] {

  type ParameterId = UUID

  case class BooleanParameter(title: String,
                              description: String,
                              group: Option[String],
                              default: Option[String] = None,
                              required: Boolean,
                              validators: List[ParameterValidator] = List(),
                              id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class ColorParameter(title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Color] = None,
                            required: Boolean,
                            options: Seq[Color] = Seq(),
                            validators: List[ParameterValidator] = List(),
                            id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class ConnectionParameter(title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[Connection] = None,
                                 required: Boolean,
                                 validators: List[ParameterValidator] = List(),
                                 id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class CurrencyParameter(title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Money] = None,
                               required: Boolean,
                               options: Seq[Money] = Seq(),
                               validators: List[ParameterValidator] = List(),
                               id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class DateTimeParameter(title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Instant] = None,
                               required: Boolean,
                               dateOptions: Seq[Instant] = Seq(),
                               dateStyle: DateTimeStyle = DateTimeStyle.Short,
                               timeStyle: DateTimeStyle = DateTimeStyle.Short,
                               validators: List[ParameterValidator] = List(),
                               id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class DecimalParameter(title: String,
                              description: String,
                              group: Option[String],
                              default: Option[BigDecimal] = None,
                              required: Boolean,
                              options: Seq[BigDecimal] = Seq(),
                              validators: List[ParameterValidator] = List(),
                              id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class DecimalRangeParameter(title: String,
                                   description: String,
                                   group: Option[String],
                                   default: Option[BigDecimal] = None,
                                   required: Boolean,
                                   minimumValue: BigDecimal = 0.0,
                                   maximumValue: BigDecimal = 100.0,
                                   validators: List[ParameterValidator] = List(),
                                   id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class EmailParameter(title: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List(),
                            id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class FileParameter(title: String,
                           description: String,
                           group: Option[String],
                           default: Option[File] = None,
                           required: Boolean,
                           validators: List[ParameterValidator] = List(),
                           id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class GeoAddressParameter(title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[String] = None,
                                 required: Boolean,
                                 validators: List[ParameterValidator] = List(),
                                 id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class GeoLocationParameter(title: String,
                                  description: String,
                                  group: Option[String],
                                  default: Option[String] = None,
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List(),
                                  id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class HtmlParameter(title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           validators: List[ParameterValidator] = List(),
                           id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class ImageParameter(title: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List(),
                            id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class IntegerParameter(title: String,
                              description: String,
                              group: Option[String],
                              default: Option[Integer] = None,
                              required: Boolean,
                              options: Seq[Integer] = Seq(),
                              validators: List[ParameterValidator] = List(),
                              id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class IntegerRangeParameter(title: String,
                                   description: String,
                                   group: Option[String],
                                   default: Option[Integer] = None,
                                   required: Boolean,
                                   minimumValue: Integer = 0,
                                   maximumValue: Integer = 100,
                                   validators: List[ParameterValidator] = List(),
                                   id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class IPAddressParameter(title: String,
                                description: String,
                                group: Option[String],
                                default: Option[String] = None,
                                required: Boolean,
                                options: Seq[String] = Seq(),
                                validators: List[ParameterValidator] = List(),
                                id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

// TODO
//  case class ListParameter[A](id: ParameterId,
//                              title: String,
//                              description: String,
//                              group: Option[String],
//                              default: Option[A] = None,
//                              required: Boolean,
//                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable

  case class NewPasswordParameter(title: String,
                                  description: String,
                                  group: Option[String],
                                  default: Option[String] = None,
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List(),
                                  id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class PageParameter(title: String,
                           description: String,
                           group: Option[String],
                           default: Option[Page] = None,
                           required: Boolean,
                           validators: List[ParameterValidator],
                           id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class PasswordParameter(title: String,
                               description: String,
                               group: Option[String],
                               required: Boolean,
                               validators: List[ParameterValidator] = List(),
                               id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class SearchQueryParameter(title: String,
                                  description: String,
                                  group: Option[String],
                                  required: Boolean,
                                  id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class StringParameter(title: String,
                             description: String,
                             group: Option[String],
                             default: Option[String] = None,
                             required: Boolean,
                             idealLength: Option[(Int, Int)] = None,
                             maxLength: Option[Int] = None,
                             inputFormat: Option[String] = None,
                             options: List[String] = List(),
                             validators: List[ParameterValidator] = List(),
                             id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class TabularDataParameter(title: String,
                                  description: String,
                                  group: Option[String],
                                  required: Boolean,
                                  validators: List[ParameterValidator] = List(),
                                  id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class TagsParameter(title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           limit: Option[Int] = None,
                           allowDuplicates: Boolean = true,
                           validators: List[ParameterValidator] = List(),
                           id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class URIParameter(title: String,
                          description: String,
                          group: Option[String],
                          default: Option[String] = None,
                          required: Boolean,
                          validators: List[ParameterValidator] = List(),
                          id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class UserParameter(title: String,
                           description: String,
                           group: Option[String],
                           required: Boolean,
                           id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

  case class VideoParameter(title: String,
                            description: String,
                            group: Option[String],
                            required: Boolean,
                            validators: List[ParameterValidator] = List(),
                            id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
  val values = findValues
}