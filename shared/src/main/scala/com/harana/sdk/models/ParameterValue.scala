package com.harana.sdk.models

import java.net.{InetAddress, URI}
import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Connection.ConnectionId
import com.harana.sdk.models.File.FileId
import com.harana.sdk.models.Image.ImageId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.Video.VideoId
import squants.market.Money

import scala.util.Try
import com.harana.sdk.util.CirceCodecs._
import io.circe.generic.JsonCodec

@JsonCodec
case class ParameterValue(value: String) {

	def asBoolean: Option[Boolean] = {
		Try {
			value.toBoolean
		}.toOption
	}

	def asColor: Option[Color] = {
		Try {
			val map = MapUtils.fromString(value)
				Color(map("red").toInt, map("green").toInt, map("blue").toInt, map("alpha").toDouble)
		}.toOption
	}

	def asConnectionId: Option[ConnectionId] = {
		Try {
			UUID.fromString(value)
		}.toOption
	}

	def asDecimal: Option[BigDecimal] = {
		Try {
			BigDecimal(value)
		}.toOption
	}

	def asDecimalRange: Option[(BigDecimal, BigDecimal)] = {
		Try {
			val array = value.split(",")
			(BigDecimal(array(0)), BigDecimal(array(1)))
		}.toOption
	}

	def asFileId: Option[FileId] = {
		Try {
			UUID.fromString(value)
		}.toOption
	}

	def asGeoAddress: Option[GeoAddress] = {
		Try {
			val map = MapUtils.fromString(value)
			GeoAddress(
				map("unitNumber"),
				map("streetNumber"),
				map("streetName"),
				map("streetType"),
				map("city"),
				map("postalCode"),
				map("state"),
				map("country")
			)
		}.toOption
	}

	def asGeoLocation: Option[(Double, Double)] = {
		Try {
			val array = value.split(", ")
			(array(0).toDouble, array(1).toDouble)
		}.toOption
	}

	def asImageId: Option[ImageId] = {
		Try {
			UUID.fromString(value)
		}.toOption
	}

	def asInstant: Option[Instant] = {
		Try {
			Instant.parse(value)
		}.toOption
	}

	def asInteger: Option[Int] = {
		Try {
			value.toInt
		}.toOption
	}

	def asIntegerRange: Option[(Int, Int)] = {
		Try {
			val array = value.split(", ")
			(array(0).toInt, array(1).toInt)
		}.toOption
	}

	def asIPAddress: Option[InetAddress] = {
		Try {
			InetAddress.getByName(value)
		}.toOption
	}

	def asParameterList: Option[List[ParameterValue]] = {
		Try {
			value.split(", ").map(ParameterValue(_)).toList
		}.toOption
	}

	def asMoney: Option[Money] = {
		Try {
			val array = value.split(" ")
			Money(BigDecimal(array(0)), array(1))
		}.toOption
	}

	def asSearchQuery: Option[SearchQuery] = {
		Try {
			val map = MapUtils.fromString(value)
			SearchQuery(map("query"))
		}.toOption
	}

	def asString: Option[String] =
		Some(value)

	def asStringList: Option[List[String]] = {
		Try {
			value.split(",").toList
		}.toOption
	}

	def asTags: Option[List[String]] = {
		Try {
			value.split(",").toList
		}.toOption
	}

	def asURI: Option[URI] = {
		Try {
			new URI(value)
		}.toOption
	}

	def asUserId: Option[UserId] = {
		Try {
			UUID.fromString(value)
		}.toOption
	}

	def asVideoId: Option[VideoId] = {
		Try {
			UUID.fromString(value)
		}.toOption
	}

	override def toString = value
}

object ParameterValue {
	def apply(value: Boolean): ParameterValue = apply(value.toString)

	def apply(value: Color): ParameterValue = {
		val map = Map(
			"red" -> String.valueOf(value.red),
			"green" -> String.valueOf(value.green),
			"blue" -> String.valueOf(value.blue),
			"alpha" -> String.valueOf(value.alpha))
		apply(MapUtils.toString(map))
	}

	def apply(value: Money): ParameterValue = apply(value.toString())
	def apply(value: Instant): ParameterValue = apply(value.toString)
	def apply(value: BigDecimal): ParameterValue = apply(value.toString)
	def apply(value1: BigDecimal, value2: BigDecimal): ParameterValue = apply(s"${value1.toString}, ${value2.toString}")

	def apply(value: GeoAddress): ParameterValue = {
		val map = Map(
			"unitNumber" -> value.unitNumber,
			"streetNumber" -> value.streetNumber,
			"streetName" -> value.streetName,
			"streetType" -> value.streetType,
			"city" -> value.city,
			"postalCode" -> value.postalCode,
			"state" -> value.state,
			"country" -> value.country)
		apply(MapUtils.toString(map))
	}

	def apply(value1: Double, value2: Double): ParameterValue = apply(s"${value1.toString}, ${value2.toString}")
	def apply(value: Integer): ParameterValue = apply(value.toString)
	def apply(value1: Integer, value2: Integer): ParameterValue = apply(s"${value1.toString}, ${value2.toString}")
	def apply(value: InetAddress): ParameterValue = apply(value.toString)
	def apply(value: List[_]): ParameterValue = apply(value.mkString(", "))

	def apply(value: SearchQuery): ParameterValue = {
		val map = Map(
			"query" -> value.query
		)
		apply(MapUtils.toString(map))
	}

	def apply(value: URI): ParameterValue = apply(value.toString)
	def apply(value: UUID): ParameterValue = apply(value.toString)
}

object MapUtils {

	def toString(values: Map[String, String]): String = {
		values.map { case (key,value) => s"$key: $value" }.mkString(", ")
	}

	def fromString(string: String): Map[String, String] = {
		string.split(", ").map { value =>
			val pair = value.split(": ")
			pair(0) -> pair(1)
		}.toMap
	}
}
