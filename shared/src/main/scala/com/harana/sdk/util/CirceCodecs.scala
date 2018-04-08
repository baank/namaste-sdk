package com.harana.sdk.util

import java.net.URI
import java.time.Instant

import cats.syntax.either._
import com.harana.sdk.components.cards._
import com.harana.sdk.components.elements._
import com.harana.sdk.components.lists._
import com.harana.sdk.components.maps._
import com.harana.sdk.components.panels._
import com.harana.sdk.components.structure._
import com.harana.sdk.components.widgets._
import com.harana.sdk.models._
import com.harana.sdk.parameters._
import com.harana.sdk.plugin.Service
import com.harana.sdk.utils.ReflectUtils
import io.circe._
import io.circe.generic.semiauto._
import io.circe.syntax._
import squants.market.Money

object CirceCodecs {

	implicit def decodeComponent: Decoder[Component] = Decoder.instance[Component] { c =>
		val content = c.downField("component").success.get
		c.downField("type").as[String].getOrElse(throw new Exception("Component type not found")).toLowerCase match {
			case "eventcard" => deriveDecoder[EventCard].apply(content)
			case "imagecard" => deriveDecoder[ImageCard].apply(content)
			case "invoicecard" => deriveDecoder[InvoiceCard].apply(content)
			case "pagecard" => deriveDecoder[PageCard].apply(content)
			case "questioncard" => deriveDecoder[QuestionCard].apply(content)
			case "searchresultcard" => deriveDecoder[SearchResultCard].apply(content)
			case "usercard" => deriveDecoder[UserCard].apply(content)
			case "videocard" => deriveDecoder[VideoCard].apply(content)
			case "badgeelement" => deriveDecoder[BadgeElement].apply(content)
			case "buttonelement" => deriveDecoder[ButtonElement].apply(content)
			case "checkboxelement" => deriveDecoder[CheckboxElement].apply(content)
			case "colorpickerelement" => deriveDecoder[ColorPickerElement].apply(content)
			case "fileuploadelement" => deriveDecoder[FileUploadElement].apply(content)
			case "labelelement" => deriveDecoder[LabelElement].apply(content)
			case "lineseperatorelement" => deriveDecoder[LineSeperatorElement].apply(content)
			case "multiselectelement" => deriveDecoder[MultiSelectElement].apply(content)
			case "passwordfieldelement" => deriveDecoder[PasswordFieldElement].apply(content)
			case "passwordgeneratorelement" => deriveDecoder[PasswordGeneratorElement].apply(content)
			case "radiobuttonelement" => deriveDecoder[RadioButtonElement].apply(content)
			case "selectelement" => deriveDecoder[SelectElement].apply(content)
			case "sliderelement" => deriveDecoder[SliderElement].apply(content)
			case "switchelement" => deriveDecoder[SwitchElement].apply(content)
			case "tagelement" => deriveDecoder[TagElement].apply(content)
			case "textareaelement" => deriveDecoder[TextAreaElement].apply(content)
			case "textfieldelement" => deriveDecoder[TextFieldElement].apply(content)
			case "commentslist" => deriveDecoder[CommentsList].apply(content)
			case "eventslist" => deriveDecoder[EventsList].apply(content)
			case "fileslist" => deriveDecoder[FilesList].apply(content)
			case "imageslist" => deriveDecoder[ImagesList].apply(content)
			case "tagslist" => deriveDecoder[TagsList].apply(content)
			case "taskslist" => deriveDecoder[TasksList].apply(content)
			case "userslist" => deriveDecoder[UsersList].apply(content)
			case "googlemap" => deriveDecoder[GoogleMap].apply(content)
			case "vectormap" => deriveDecoder[VectorMap].apply(content)
			case "calendarpanel" => deriveDecoder[CalendarPanel].apply(content)
			case "commentspanel" => deriveDecoder[CommentsPanel].apply(content)
			case "searchresultspanel" => deriveDecoder[SearchResultsPanel].apply(content)
			case "timerpanel" => deriveDecoder[TimerPanel].apply(content)
			case "accordionstructure" => deriveDecoder[AccordionStructure].apply(content)
			case "gridstructure" => deriveDecoder[GridStructure].apply(content)
			case "pillsstructure" => deriveDecoder[PillsStructure].apply(content)
			case "tabsstructure" => deriveDecoder[TabsStructure].apply(content)
			case "areachartwidget" => deriveDecoder[AreaChartWidget].apply(content)
			case "barchartwidget" => deriveDecoder[BarChartWidget].apply(content)
			case "counterstatswidget" => deriveDecoder[CounterStatsWidget].apply(content)
			case "donutstatswidget" => deriveDecoder[DonutStatsWidget].apply(content)
			case "donutwidget" => deriveDecoder[DonutWidget].apply(content)
			case "piechartwidget" => deriveDecoder[PieChartWidget].apply(content)
			case "progressstatswidget" => deriveDecoder[ProgressStatsWidget].apply(content)
			case "timerwidget" => deriveDecoder[TimerWidget].apply(content)
		}
	}

	implicit def encodeComponent: Encoder[Component] = Encoder.instance[Component] { component =>
		val componentType = component.getClass.getSimpleName.toLowerCase
		val json = componentType match {
			case "eventcard" => deriveEncoder[EventCard].apply(component.asInstanceOf[EventCard])
			case "imagecard" => deriveEncoder[ImageCard].apply(component.asInstanceOf[ImageCard])
			case "invoicecard" => deriveEncoder[InvoiceCard].apply(component.asInstanceOf[InvoiceCard])
			case "pagecard" => deriveEncoder[PageCard].apply(component.asInstanceOf[PageCard])
			case "questioncard" => deriveEncoder[QuestionCard].apply(component.asInstanceOf[QuestionCard])
			case "searchresultcard" => deriveEncoder[SearchResultCard].apply(component.asInstanceOf[SearchResultCard])
			case "usercard" => deriveEncoder[UserCard].apply(component.asInstanceOf[UserCard])
			case "videocard" => deriveEncoder[VideoCard].apply(component.asInstanceOf[VideoCard])
			case "badgeelement" => deriveEncoder[BadgeElement].apply(component.asInstanceOf[BadgeElement])
			case "buttonelement" => deriveEncoder[ButtonElement].apply(component.asInstanceOf[ButtonElement])
			case "checkboxelement" => deriveEncoder[CheckboxElement].apply(component.asInstanceOf[CheckboxElement])
			case "colorpickerelement" => deriveEncoder[ColorPickerElement].apply(component.asInstanceOf[ColorPickerElement])
			case "fileuploadelement" => deriveEncoder[FileUploadElement].apply(component.asInstanceOf[FileUploadElement])
			case "labelelement" => deriveEncoder[LabelElement].apply(component.asInstanceOf[LabelElement])
			case "lineseperatorelement" => deriveEncoder[LineSeperatorElement].apply(component.asInstanceOf[LineSeperatorElement])
			case "multiselectelement" => deriveEncoder[MultiSelectElement].apply(component.asInstanceOf[MultiSelectElement])
			case "passwordfieldelement" => deriveEncoder[PasswordFieldElement].apply(component.asInstanceOf[PasswordFieldElement])
			case "passwordgeneratorelement" => deriveEncoder[PasswordGeneratorElement].apply(component.asInstanceOf[PasswordGeneratorElement])
			case "radiobuttonelement" => deriveEncoder[RadioButtonElement].apply(component.asInstanceOf[RadioButtonElement])
			case "selectelement" => deriveEncoder[SelectElement].apply(component.asInstanceOf[SelectElement])
			case "sliderelement" => deriveEncoder[SliderElement].apply(component.asInstanceOf[SliderElement])
			case "switchelement" => deriveEncoder[SwitchElement].apply(component.asInstanceOf[SwitchElement])
			case "tagelement" => deriveEncoder[TagElement].apply(component.asInstanceOf[TagElement])
			case "textareaelement" => deriveEncoder[TextAreaElement].apply(component.asInstanceOf[TextAreaElement])
			case "textfieldelement" => deriveEncoder[TextFieldElement].apply(component.asInstanceOf[TextFieldElement])
			case "commentslist" => deriveEncoder[CommentsList].apply(component.asInstanceOf[CommentsList])
			case "eventslist" => deriveEncoder[EventsList].apply(component.asInstanceOf[EventsList])
			case "fileslist" => deriveEncoder[FilesList].apply(component.asInstanceOf[FilesList])
			case "imageslist" => deriveEncoder[ImagesList].apply(component.asInstanceOf[ImagesList])
			case "tagslist" => deriveEncoder[TagsList].apply(component.asInstanceOf[TagsList])
			case "taskslist" => deriveEncoder[TasksList].apply(component.asInstanceOf[TasksList])
			case "userslist" => deriveEncoder[UsersList].apply(component.asInstanceOf[UsersList])
			case "googlemap" => deriveEncoder[GoogleMap].apply(component.asInstanceOf[GoogleMap])
			case "vectormap" => deriveEncoder[VectorMap].apply(component.asInstanceOf[VectorMap])
			case "calendarpanel" => deriveEncoder[CalendarPanel].apply(component.asInstanceOf[CalendarPanel])
			case "commentspanel" => deriveEncoder[CommentsPanel].apply(component.asInstanceOf[CommentsPanel])
			case "searchresultspanel" => deriveEncoder[SearchResultsPanel].apply(component.asInstanceOf[SearchResultsPanel])
			case "timerpanel" => deriveEncoder[TimerPanel].apply(component.asInstanceOf[TimerPanel])
			case "accordionstructure" => deriveEncoder[AccordionStructure].apply(component.asInstanceOf[AccordionStructure])
			case "gridstructure" => deriveEncoder[GridStructure].apply(component.asInstanceOf[GridStructure])
			case "pillsstructure" => deriveEncoder[PillsStructure].apply(component.asInstanceOf[PillsStructure])
			case "tabsstructure" => deriveEncoder[TabsStructure].apply(component.asInstanceOf[TabsStructure])
			case "areachartwidget" => deriveEncoder[AreaChartWidget].apply(component.asInstanceOf[AreaChartWidget])
			case "barchartwidget" => deriveEncoder[BarChartWidget].apply(component.asInstanceOf[BarChartWidget])
			case "counterstatswidget" => deriveEncoder[CounterStatsWidget].apply(component.asInstanceOf[CounterStatsWidget])
			case "donutstatswidget" => deriveEncoder[DonutStatsWidget].apply(component.asInstanceOf[DonutStatsWidget])
			case "donutwidget" => deriveEncoder[DonutWidget].apply(component.asInstanceOf[DonutWidget])
			case "piechartwidget" => deriveEncoder[PieChartWidget].apply(component.asInstanceOf[PieChartWidget])
			case "progressstatswidget" => deriveEncoder[ProgressStatsWidget].apply(component.asInstanceOf[ProgressStatsWidget])
			case "timerwidget" => deriveEncoder[TimerWidget].apply(component.asInstanceOf[TimerWidget])
		}

		Json.obj("type" -> componentType.asJson, "component" -> json)
	}

	implicit def decodeEntity: Decoder[Entity] = Decoder.instance[Entity] { c =>
		val content = c.downField("entity").success.get
		c.downField("type").as[String].getOrElse(throw new Exception("Entity type not found")).toLowerCase match {
			case "comment" => deriveDecoder[Comment].apply(content)
			case "event" => deriveDecoder[Event].apply(content)
			case "file" => deriveDecoder[File].apply(content)
			case "image" => deriveDecoder[Image].apply(content)
			case "invoice" => deriveDecoder[Invoice].apply(content)
			case "group" => deriveDecoder[Group].apply(content)
			case "page" => deriveDecoder[Page].apply(content)
			case "panel" => deriveDecoder[Panel].apply(content)
			case "question" => deriveDecoder[Question].apply(content)
			case "task" => deriveDecoder[Task].apply(content)
			case "user" => deriveDecoder[User].apply(content)
			case "video" => deriveDecoder[Video].apply(content)
		}
	}

	implicit def encodeEntity: Encoder[Entity] = Encoder.instance[Entity] { entity =>
		val entityType = entity.getClass.getSimpleName.toLowerCase
		val json = entityType match {
			case "user" => deriveEncoder[User].apply(entity.asInstanceOf[User])
			case "comment" => deriveEncoder[Comment].apply(entity.asInstanceOf[Comment])
			case "event" => deriveEncoder[Event].apply(entity.asInstanceOf[Event])
			case "file" => deriveEncoder[File].apply(entity.asInstanceOf[File])
			case "image" => deriveEncoder[Image].apply(entity.asInstanceOf[Image])
			case "invoice" => deriveEncoder[Invoice].apply(entity.asInstanceOf[Invoice])
			case "group" => deriveEncoder[Group].apply(entity.asInstanceOf[Group])
			case "page" => deriveEncoder[Page].apply(entity.asInstanceOf[Page])
			case "panel" => deriveEncoder[Panel].apply(entity.asInstanceOf[Panel])
			case "question" => deriveEncoder[Question].apply(entity.asInstanceOf[Question])
			case "task" => deriveEncoder[Task].apply(entity.asInstanceOf[Task])
			case "video" => deriveEncoder[Video].apply(entity.asInstanceOf[Video])
		}
		Json.obj("type" -> entityType.asJson, "entity" -> json)
	}

	implicit def decodeParameter: Decoder[Parameter] = Decoder.instance[Parameter] { c =>
		val content = c.downField("parameter").success.get
		c.downField("type").as[String].getOrElse(throw new Exception("Parameter type not found")).toLowerCase match {
			case "booleanparameter" => deriveDecoder[BooleanParameter].apply(content)
			case "colorparameter" => deriveDecoder[ColorParameter].apply(content)
			case "connectionparameter" => deriveDecoder[ConnectionParameter].apply(content)
			case "moneyparameter" => deriveDecoder[MoneyParameter].apply(content)
			case "datetimeparameter" => deriveDecoder[DateTimeParameter].apply(content)
			case "decimalparameter" => deriveDecoder[DecimalParameter].apply(content)
			case "decimalrangeparameter" => deriveDecoder[DecimalRangeParameter].apply(content)
			case "emailparameter" => deriveDecoder[EmailParameter].apply(content)
			case "fileparameter" => deriveDecoder[FileParameter].apply(content)
			case "geoaddressparameter" => deriveDecoder[GeoAddressParameter].apply(content)
			case "geolocationparameter" => deriveDecoder[GeoLocationParameter].apply(content)
			case "htmlparameter" => deriveDecoder[HtmlParameter].apply(content)
			case "imageparameter" => deriveDecoder[ImageParameter].apply(content)
			case "integerparameter" => deriveDecoder[IntegerParameter].apply(content)
			case "integerangeparameter" => deriveDecoder[IntegerRangeParameter].apply(content)
			case "ipaddressparameter" => deriveDecoder[IPAddressParameter].apply(content)
			//case "listparameter" => deriveDecoder[ListParameter].apply(content)
			case "newpasswordparameter" => deriveDecoder[NewPasswordParameter].apply(content)
			case "pageparameter" => deriveDecoder[PageParameter].apply(content)
			case "passwordparameter" => deriveDecoder[PasswordParameter].apply(content)
			case "searchqueryparameter" => deriveDecoder[SearchQueryParameter].apply(content)
			case "stringparameter" => deriveDecoder[StringParameter].apply(content)
			case "tagsparameter" => deriveDecoder[TagsParameter].apply(content)
			case "uriparameter" => deriveDecoder[URIParameter].apply(content)
			case "userparameter" => deriveDecoder[UserParameter].apply(content)
			case "videoparameter" => deriveDecoder[VideoParameter].apply(content)
		}
	}

	implicit def encodeParameter: Encoder[Parameter] = Encoder.instance[Parameter] { parameter =>
		val entityType = parameter.getClass.getSimpleName.toLowerCase
		val json = entityType match {
			case "booleanparameter" => deriveEncoder[BooleanParameter].apply(parameter.asInstanceOf[BooleanParameter])
			case "colorparameter" => deriveEncoder[ColorParameter].apply(parameter.asInstanceOf[ColorParameter])
			case "connectionparameter" => deriveEncoder[ConnectionParameter].apply(parameter.asInstanceOf[ConnectionParameter])
			case "moneyparameter" => deriveEncoder[MoneyParameter].apply(parameter.asInstanceOf[MoneyParameter])
			case "datetimeparameter" => deriveEncoder[DateTimeParameter].apply(parameter.asInstanceOf[DateTimeParameter])
			case "decimalparameter" => deriveEncoder[DecimalParameter].apply(parameter.asInstanceOf[DecimalParameter])
			case "decimalrangeparameter" => deriveEncoder[DecimalRangeParameter].apply(parameter.asInstanceOf[DecimalRangeParameter])
			case "emailparameter" => deriveEncoder[EmailParameter].apply(parameter.asInstanceOf[EmailParameter])
			case "fileparameter" => deriveEncoder[FileParameter].apply(parameter.asInstanceOf[FileParameter])
			case "geoaddressparameter" => deriveEncoder[GeoAddressParameter].apply(parameter.asInstanceOf[GeoAddressParameter])
			case "geolocationparameter" => deriveEncoder[GeoLocationParameter].apply(parameter.asInstanceOf[GeoLocationParameter])
			case "htmlparameter" => deriveEncoder[HtmlParameter].apply(parameter.asInstanceOf[HtmlParameter])
			case "imageparameter" => deriveEncoder[ImageParameter].apply(parameter.asInstanceOf[ImageParameter])
			case "integerparameter" => deriveEncoder[IntegerParameter].apply(parameter.asInstanceOf[IntegerParameter])
			case "integerangeparameter" => deriveEncoder[IntegerRangeParameter].apply(parameter.asInstanceOf[IntegerRangeParameter])
			case "ipaddressparameter" => deriveEncoder[IPAddressParameter].apply(parameter.asInstanceOf[IPAddressParameter])
			//case "listparameter" => deriveEncoder[ListParameter].apply(parameter.asInstanceOf[ListParameter])
			case "newpasswordparameter" => deriveEncoder[NewPasswordParameter].apply(parameter.asInstanceOf[NewPasswordParameter])
			case "pageparameter" => deriveEncoder[PageParameter].apply(parameter.asInstanceOf[PageParameter])
			case "passwordparameter" => deriveEncoder[PasswordParameter].apply(parameter.asInstanceOf[PasswordParameter])
			case "searchqueryparameter" => deriveEncoder[SearchQueryParameter].apply(parameter.asInstanceOf[SearchQueryParameter])
			case "stringparameter" => deriveEncoder[StringParameter].apply(parameter.asInstanceOf[StringParameter])
			case "tagsparameter" => deriveEncoder[TagsParameter].apply(parameter.asInstanceOf[TagsParameter])
			case "uriparameter" => deriveEncoder[URIParameter].apply(parameter.asInstanceOf[URIParameter])
			case "userparameter" => deriveEncoder[UserParameter].apply(parameter.asInstanceOf[UserParameter])
			case "videoparameter" => deriveEncoder[VideoParameter].apply(parameter.asInstanceOf[VideoParameter])
		}
		Json.obj("type" -> entityType.asJson, "parameter" -> json)
	}

	implicit def encodeEither[A, B](implicit encoderA: Encoder[A], encoderB: Encoder[B]): Encoder[Either[A, B]] = {
		o: Either[A, B] => o.fold(_.asJson, _.asJson)
	}

	implicit def decodeEither[A, B](implicit decoderA: Decoder[A], decoderB: Decoder[B]): Decoder[Either[A, B]] = {
		c: HCursor => c.as[A] match {
			case Right(a) => Right(Left(a))
			case _ => c.as[B].map(Right(_))
		}
	}

	implicit def decodeSubEntity[A <: Entity]: Decoder[Entity] = decodeEntity
	implicit val decodeInstant: Decoder[Instant] = Decoder.decodeLong.emap { long => Either.catchNonFatal(Instant.ofEpochMilli(long)).leftMap(_ => "Malformed Money") }
	implicit val decodeMoney: Decoder[Money] = Decoder.decodeString.emap { str => Money(str).toEither.leftMap(_ => "Malformed Money") }
	implicit def decodeService[A <: Service]: Decoder[A] = Decoder.decodeString.emap { str => Either.catchNonFatal(ReflectUtils.classForName[A](str)).leftMap(_ => "Malformed Service") }
	implicit val decodeUri: Decoder[URI] = Decoder.decodeString.emap { str => Either.catchNonFatal(URI.create(str)).leftMap(_ => "Malformed URL") }

	implicit def encodeSubEntity[A <: Entity]: Encoder[Entity] = encodeEntity
	implicit val encodeInstant: Encoder[Instant] = Encoder.encodeLong.contramap[Instant](_.toEpochMilli)
	implicit val encodeMoney: Encoder[Money] = Encoder.encodeString.contramap[Money](_.toString)
	implicit def encodeService[A <: Service]: Encoder[A] = Encoder.encodeString.contramap[A](_.getClass.getName)
	implicit val encodeUri: Encoder[URI] = Encoder.encodeString.contramap[URI](_.toString)
}
