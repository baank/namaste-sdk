package com.naden.namaste.ui.models.elements

import com.naden.namaste.ui.models.Color.Color

case class LabelElement(title: String,
                        color: Color,
                        icon: String,
                        rounded: Boolean,
                        square: Boolean,
                        block: Boolean,
                        flat: Boolean)
