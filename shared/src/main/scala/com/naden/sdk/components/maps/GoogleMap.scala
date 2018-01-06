package com.naden.sdk.components.maps

import com.naden.sdk.components.Component
import com.naden.sdk.components.maps.MapPosition.MapPosition
import com.naden.sdk.components.maps.MapType.MapType

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

case class Marker(position: (Double, Double),
                  draggable: Boolean = false,
                  dropAnimation: Boolean = false)

case object MapType extends Enumeration {
  type MapType = Value
  val ROADMAP = Value("roadmap")
  val SATELLITE = Value("satellite")
  val HYBRID = Value("hybrid")
  val TERRAIN = Value("terrain")
}

case object MapPosition extends Enumeration {
  type MapPosition = Value
  val TOP_LEFT = Value("TOP_LEFT")
  val TOP_CENTER = Value("TOP_CENTER")
  val TOP_RIGHT = Value("TOP_RIGHT")
  val LEFT_TOP = Value("LEFT_TOP")
  val LEFT_CENTER = Value("LEFT_CENTER")
  val LEFT_BOTTOM = Value("LEFT_BOTTOM")
  val RIGHT_TOP = Value("RIGHT_TOP")
  val RIGHT_CENTER = Value("RIGHT_CENTER")
  val RIGHT_BOTTOM = Value("RIGHT_BOTTOM")
  val BOTTOM_LEFT = Value("BOTTOM_LEFT")
  val BOTTOM_CENTER = Value("BOTTOM_CENTER")
  val BOTTOM_RIGHT = Value("BOTTOM_RIGHT")
}

case object MapTypeControlSize extends Enumeration {
  type MapTypeControlSize = Value
  val HORIZONTAL_BAR = Value("HORIZONTAL_BAR")
  val DROPDOWN_MENU = Value("DROPDOWN_MENU")
}

case object MapDropAnimation extends Enumeration {
  type MapDropAnimation = Value
  val BOUNCE = Value("BOUNCE")
  val DROP = Value("DROP")
}

case object MapLayer extends Enumeration {
  type MapLayer = Value
  val BIKE = Value("Bicycling")
  val TRAFFIC = Value("Traffic")
  val TRANSIT = Value("Transit")
}
