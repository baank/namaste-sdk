package com.naden.namaste.ui.models.maps

import com.naden.namaste.ui.models.maps.MapType.MapType
import com.naden.namaste.ui.models.maps.Position.Position

case class GoogleMaps(name: String,
                      zoom: Option[Int] = None,
                      center: Option[(Double, Double)] = None,
                      centerToGeolocation: Boolean = false,
                      tilt: Option[Boolean] = None,
                      heading: Option[Int] = None,
                      disableDefaultUI: Option[Boolean] = None,
                      mapType: Option[MapType] = None,
                      mapTypeControl: Option[Boolean] = None,
                      mapTypePosition: Option[Position] = None,
                      panControl: Option[Boolean] = None,
                      panPosition: Option[Position] = None,
                      zoomControl: Option[Boolean] = None,
                      zoomPosition: Option[Position] = None,
                      scaleControl: Option[Boolean] = None,
                      scalePosition: Option[Position] = None,
                      streetViewControl: Option[Boolean] = None,
                      streetViewPosition: Option[Position] = None,
                      rotateControl: Option[Boolean] = None,
                      rotatePosition: Option[Position] = None,
                      fullScreenControl: Option[Boolean] = None,
                      fullScreenPosition: Option[Position] = None,
                      markers: List[Marker] = List())

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

object Position extends Enumeration {
  type Position = Value
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
  val BOTTOM_RIGHT = Value("BOTTOM_RIGHT")}

object MapTypeControlSize extends Enumeration {
  type MapTypeControlSize = Value
  val HORIZONTAL_BAR = Value("HORIZONTAL_BAR")
  val DROPDOWN_MENU = Value("DROPDOWN_MENU")
}

object DropAnimation extends Enumeration {
  type DropAnimation = Value
  val BOUNCE = Value("BOUNCE")
  val DROP = Value("DROP")
}

object Layer extends Enumeration {
  type Layer = Value
  val BIKE = Value("Bicycling")
  val TRAFFIC = Value("Traffic")
  val TRANSIT = Value("Transit")
}