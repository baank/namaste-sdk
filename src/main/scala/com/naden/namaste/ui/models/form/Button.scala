package com.naden.namaste.ui.models.form

import com.naden.namaste.ui.models.{Color, ColorAccent}
import com.naden.namaste.ui.models.Color.Color
import com.naden.namaste.ui.models.ColorAccent.ColorAccent
import com.naden.namaste.ui.models.form.Size.Size

case class Button(name: String,
                  label: String,
                  size: Size = Size.DEFAULT,
                  color: Color = Color.DEFAULT,
                  colorAccent: ColorAccent = ColorAccent.DEFAULT,
                  labeled: Boolean = false,
                  rounded: Boolean = false,
                  floating: Boolean = false)


object IconPosition extends Enumeration {
  type IconPosition = Value
  val LEFT = Value
  val RIGHT = Value
}

object Size extends Enumeration {
  type Size = Value
  val DEFAULT = Value("")
  val EXTRA_LARGE = Value("xlg")
  val LARGE = Value("lg")
  val SMALL = Value("sm")
  val MINI = Value("xs")
}