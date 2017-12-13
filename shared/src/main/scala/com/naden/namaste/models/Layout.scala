package com.naden.namaste.models

import com.naden.namaste.models.ColumnHorizontalAlignment.ColumnHorizontalAlignment
import com.naden.namaste.models.ColumnOffset.ColumnOffset
import com.naden.namaste.models.ColumnStyle.ColumnStyle
import com.naden.namaste.models.ColumnVerticalAlignment.ColumnVerticalAlignment
import com.naden.namaste.models.ColumnWidth.ColumnWidth
import com.naden.namaste.models.RowJustification.RowJustification

case class Layout[A](rows: List[Row[A]])

case class Row[A](columns: List[Column[A]],
                  justification: RowJustification = RowJustification.Default)

case class Column[A](contents: List[A],
                     width: ColumnWidth = ColumnWidth.Auto,
                     style: ColumnStyle = ColumnStyle.Default,
                     horizontalAlignment: ColumnHorizontalAlignment = ColumnHorizontalAlignment.Default,
                     verticalAlignment: ColumnVerticalAlignment = ColumnVerticalAlignment.Default,
                     offset: ColumnOffset = ColumnOffset.None)

object RowJustification extends Enumeration {
  type RowJustification = Value
  val Default = Value
  val Start = Value
  val Center = Value
  val End = Value
  val Around = Value
  val Between = Value
}

object ColumnHorizontalAlignment extends Enumeration {
  type ColumnHorizontalAlignment = Value
  val Default = Value
  val Start = Value
  val Center = Value
  val End = Value
}

object ColumnVerticalAlignment extends Enumeration {
  type ColumnVerticalAlignment = Value
  val Default = Value
  val Start = Value
  val Center = Value
  val End = Value
}

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

object ColumnStyle extends Enumeration {
  type ColumnStyle = Value
  val Default = Value
  val LineBreak = Value
  val ClearFix = Value
}

object ColumnWidth extends Enumeration {
  type ColumnWidth = Value
  val Auto = Value
  val FitToContent = Value
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