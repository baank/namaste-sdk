package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object ColorPickerElement {

  @dom
  def apply(name: String,
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
            selectionPalette: List[String] = List(),
            maxSelectionSize: Int = 3): Binding[Div] = {
    <div></div>
  }
}