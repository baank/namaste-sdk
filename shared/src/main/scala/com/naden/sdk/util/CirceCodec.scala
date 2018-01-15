package com.naden.sdk.util

import java.net.URI
import java.time.LocalDateTime
import java.util.UUID

import cats.syntax.either._
import com.naden.sdk.models.Component
import com.naden.sdk.plugin.{PageType, PanelType}
import io.circe._
import io.circe.syntax._
import squants.market.Money
import io.circe.generic.semiauto._

import scala.reflect.macros.blackbox

object CirceCodec {

	implicit def pageTypeDecoder[A](implicit ev: Decoder[A]): Decoder[PageType[A]] = Decoder.instance { c =>
		ev.tryDecode(c)
	}

	implicit def pageTypeEncoder[A](implicit ev: Encoder[A]): Encoder[PageType[A]] = deriveEncoder[PageType[A]]


	//	implicit def decodePageType[]: Decoder[PageType[A]] = Decoder.instance[PageType] { c =>
//		val pageTypeName = c.downField("type").as[String].getOrElse(throw new Exception("Page Type type not found"))
//
//
//	}
//
//	implicit def encodePageType: Encoder[PageType] = Encoder.instance[PageType] { pageType =>
//		val pageTypeName = PageType.allPageTypes.filter(p => p._2.equals(pageType)).head._1
//		Json.obj("type" -> pageTypeName.asJson)
//	}

	implicit val decodeLocalDateTime: Decoder[LocalDateTime] = Decoder.decodeLong.emap { long =>
		Either.catchNonFatal(DateUtils.fromMillis(long)).leftMap(_ => "Malformed Money")
	}

	implicit val decodeMoney: Decoder[Money] = Decoder.decodeString.emap { str =>
		Money(str).toEither.leftMap(_ => "Malformed Money")
	}

	implicit val decodeUri: Decoder[URI] = Decoder.decodeString.emap { str =>
		Either.catchNonFatal(URI.create(str)).leftMap(_ => "Malformed URL")
	}

	implicit val decodeUuid: Decoder[UUID] = Decoder.decodeString.emap { str =>
		Either.catchNonFatal(UUID.fromString(str)).leftMap(_ => "Malformed UUID")
	}

	implicit val encodeLocalDateTime: Encoder[LocalDateTime] =
		Encoder.encodeLong.contramap[LocalDateTime](DateUtils.toMillis)

	implicit val encodeMoney: Encoder[Money] =
		Encoder.encodeString.contramap[Money](_.toString)

	implicit val encodeUri: Encoder[URI] =
		Encoder.encodeString.contramap[URI](_.toString)

	implicit val encodeUuid: Encoder[UUID] =
		Encoder.encodeString.contramap[UUID](_.toString)


	//	implicit def decodeComponent: Decoder[Component = {
	//		Decoder[String].prepare(_.downField("type")).flatMap { component =>
	//			Component.allComponents(component).decoder.asInstanceOf[Decoder[Component
	//		}
	//	}
	//
	//	implicit def encodeComponent: Encoder[Component = Encoder.instance { component =>
	//		Json.obj("type" -> component.getClass.getName.asJson, "component" -> component.encoder.asInstanceOf[Encoder[Component](component))
	//	}
	//

	////
	////		PageType.allPageTypes(pageType).decoder
	////
	////
	////		Decoder[String].prepare(_.downField("type")).flatMap { pageType =>
	////			PageType.allPageTypes(pageType).decoder
	//		}
}
//
//	implicit def encodePageType: Encoder[PageType] = Encoder.instance { pageType =>
//		val subPageType = pageType.as
//		Json.obj("type" -> pageType.getClass.getName.asJson, "pageType" -> pageType.encoder(pageType.asInstanceOf[pageType.getClass]))
//	}
//
//	implicit def decodePanelType: Decoder[PanelType] = {
//		Decoder[String].prepare(_.downField("type")).flatMap { panelType =>
//			PanelType.allPanelTypes(panelType).decoder
//		}
//	}
//
//	implicit def encodePanelType: Encoder[PanelType] = Encoder.instance { panelType =>
//		Json.obj("type" -> panelType.getClass.getName.asJson, "panelType" -> panelType.encoder(panelType))
//	}

//	implicit def componentDecoder[A](implicit ev: Component
//	implicit def componentCoder[A](implicit ev: Component
//
