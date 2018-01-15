package com.naden.sdk.components.maps

import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class GoogleMap(name: String,
            zoom: Option[Int] = None,
            center: Option[(Double, Double)] = None,
            centerToGeolocation: Boolean = false,
            tilt: Boolean = false,
            heading: Option[Int] = None,
            disableDefaultUI: Boolean = false,
            mapType: Option[MapType] = None,
            mapTypeControl: Boolean = false,
            mapTypePosition: Option[MapPosition] = None,
            panControl: Boolean = false,
            panPosition: Option[MapPosition] = None,
            zoomControl: Boolean = false,
            zoomPosition: Option[MapPosition] = None,
            scaleControl: Boolean = false,
            scalePosition: Option[MapPosition] = None,
            streetViewControl: Boolean = false,
            streetViewPosition: Option[MapPosition] = None,
            rotateControl: Boolean = false,
            rotatePosition: Option[MapPosition] = None,
            fullScreenControl: Boolean = false,
            fullScreenPosition: Option[MapPosition] = None,
            markers: List[Marker] = List.empty) extends Component

@JsonCodec
case class Marker(position: (Double, Double),
                  draggable: Boolean = false,
                  dropAnimation: Boolean = false)

@JsonCodec
sealed trait MapType
object MapType {
  case object Roadmap extends MapType
  case object Satellite extends MapType
  case object Hybrid extends MapType
  case object Terrain extends MapType
}

@JsonCodec
sealed trait MapPosition
object MapPosition {
  case object TopLeft extends MapPosition
  case object TopCenter extends MapPosition
  case object TopRight extends MapPosition
  case object LeftTop extends MapPosition
  case object LeftCenter extends MapPosition
  case object LeftBottom extends MapPosition
  case object RightTop extends MapPosition
  case object RightCenter extends MapPosition
  case object RightBottom extends MapPosition
  case object BottomLeft extends MapPosition
  case object BottomCenter extends MapPosition
  case object BottomRight extends MapPosition
}

@JsonCodec
sealed trait MapTypeControlSize
object MapTypeControlSize {
  case object HorizontalBar extends MapTypeControlSize
  case object DropdownMenu extends MapTypeControlSize
}

@JsonCodec
sealed trait MapDropAnimation
object MapDropAnimation {
  case object Bounce extends MapDropAnimation
  case object Drop extends MapDropAnimation
}

@JsonCodec
sealed trait MapLayer
object MapLayer {
  case object Bike extends MapLayer
  case object Traffic extends MapLayer
  case object Transit extends MapLayer
}