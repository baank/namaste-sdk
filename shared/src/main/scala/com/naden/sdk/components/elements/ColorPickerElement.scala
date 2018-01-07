package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import boopickle.Default._

case class ColorPickerElement(name: String,
                              label: String,
                              allowEmpty: Boolean = false,
                              disabled: Boolean = false,
                              flat: Boolean = false,
                              showInput: Boolean = false,
                              showAlpha: Boolean = false,
                              showInitial: Boolean = false,
                              showPalette: Boolean = false,
                              showPaletteOnly: Boolean = false,
                              togglePaletteOnly: Boolean = false,
                              togglePaletteMoreText: String = "More",
                              hideAfterPaletteSelect: Boolean = false,
                              selectionPalette: List[String] = List.empty,
                              maxSelectionSize: Int = 3) extends Component
