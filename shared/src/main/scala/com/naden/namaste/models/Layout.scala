package com.naden.namaste.models

import com.naden.namaste.models.ColumnOffset.ColumnOffset
import com.naden.namaste.models.ColumnWidth.ColumnWidth

case class Layout[+A](rows: List[Row[A]])

case class Row[+A](columns: List[Column[A]])

case class Column[+A](contents: List[A],
                     width: ColumnWidth,
                     offset: ColumnOffset = ColumnOffset.None)

object ColumnOffset extends Enumeration {
  type ColumnOffset = Value
  val None = Value
  val One = Value
  val Two = Value
  val Three = Value
  val Four = Value
  val Five = Value
  val Six = Value
  val Seven = Value
  val Eight = Value
  val Nine = Value
  val Ten = Value
  val Eleven = Value
  val Twelve = Value
}

object ColumnWidth extends Enumeration {
  type ColumnWidth = Value
  val One = Value
  val Two = Value
  val Three = Value
  val Four = Value
  val Five = Value
  val Six = Value
  val Seven = Value
  val Eight = Value
  val Nine = Value
  val Ten = Value
  val Eleven = Value
  val Twelve = Value
}