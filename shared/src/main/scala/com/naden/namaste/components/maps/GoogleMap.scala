package com.naden.namaste.components.maps

import com.naden.namaste.components.Component
import com.naden.namaste.components.maps.MapPosition.MapPosition
import com.naden.namaste.components.maps.MapType.MapType

case class GoogleMap(name: String,
            zoom: Option[Int] = None,
            center: Option[(Double, Double)] = None,
            centerToGeolocation: Boolean = false,
            tilt: Option[Boolean] = None,
            heading: Option[Int] = None,
            disableDefaultUI: Option[Boolean] = None,
            mapType: Option[MapType] = None,
            mapTypeControl: Option[Boolean] = None,
            mapTypePosition: Option[MapPosition] = None,
            panControl: Option[Boolean] = None,
            panPosition: Option[MapPosition] = None,
            zoomControl: Option[Boolean] = None,
            zoomPosition: Option[MapPosition] = None,
            scaleControl: Option[Boolean] = None,
            scalePosition: Option[MapPosition] = None,
            streetViewControl: Option[Boolean] = None,
            streetViewPosition: Option[MapPosition] = None,
            rotateControl: Option[Boolean] = None,
            rotatePosition: Option[MapPosition] = None,
            fullScreenControl: Option[Boolean] = None,
            fullScreenPosition: Option[MapPosition] = None,
            markers: List[Marker] = List()) extends Component

case class Marker(position: (Double, Double),
                  draggable: Boolean = false,
                  dropAnimation: Boolean = false)

object MapType extends Enumeration {
  type MapType = Value
  val ROADMAP = Value("roadmap")
  val SATLLITE = Value("satellite")
  val HYBRID = Value("hybrid")
  val TERRAIN = Value("terrain")
}

object MapPosition extends Enumeration {
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

object MapTypeControlSize extends Enumeration {
  type MapTypeControlSize = Value
  val HORIZONTAL_BAR = Value("HORIZONTAL_BAR")
  val DROPDOWN_MENU = Value("DROPDOWN_MENU")
}

object MapDropAnimation extends Enumeration {
  type MapDropAnimation = Value
  val BOUNCE = Value("BOUNCE")
  val DROP = Value("DROP")
}

object MapLayer extends Enumeration {
  type MapLayer = Value
  val BIKE = Value("Bicycling")
  val TRAFFIC = Value("Traffic")
  val TRANSIT = Value("Transit")
}