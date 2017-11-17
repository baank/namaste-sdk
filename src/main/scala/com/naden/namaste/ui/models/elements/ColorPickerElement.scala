package com.naden.namaste.ui.models.elements

case class ColorPickerElement(name: String,
															label: String,
															allowEmpty: Boolean,
															disabled: Boolean = false,
															flat: Boolean,
															showInput: Boolean,
															showAlpha: Boolean,
															showInitial: Boolean,
															showPalette: Boolean,
															showPaletteOnly: Boolean,
															togglePaletteOnly: Boolean,
															togglePaletteMoreText: String = "More",
															hideAfterPaletteSelect: Boolean = false,
															selectionPalette: List[String] = List(),
															maxSelectionSize: Int = 3)
