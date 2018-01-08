package com.naden.sdk.models

case class Layout[+A](rows: List[Row[A]])

case class Row[+A](columns: List[Column[A]])

case class Column[+A](contents: List[A],
                     width: ColumnWidth,
                     offset: ColumnOffset = ColumnOffset.None)

sealed trait ColumnOffset
object ColumnOffset {
  case object None extends ColumnOffset
  case object One extends ColumnOffset
  case object Two extends ColumnOffset
  case object Three extends ColumnOffset
  case object Four extends ColumnOffset
  case object Five extends ColumnOffset
  case object Six extends ColumnOffset
  case object Seven extends ColumnOffset
  case object Eight extends ColumnOffset
  case object Nine extends ColumnOffset
  case object Ten extends ColumnOffset
  case object Eleven extends ColumnOffset
  case object Twelve extends ColumnOffset
}

sealed trait ColumnWidth
object ColumnWidth {
  case object One extends ColumnWidth
  case object Two extends ColumnWidth
  case object Three extends ColumnWidth
  case object Four extends ColumnWidth
  case object Five extends ColumnWidth
  case object Six extends ColumnWidth
  case object Seven extends ColumnWidth
  case object Eight extends ColumnWidth
  case object Nine extends ColumnWidth
  case object Ten extends ColumnWidth
  case object Eleven extends ColumnWidth
  case object Twelve extends ColumnWidth
}