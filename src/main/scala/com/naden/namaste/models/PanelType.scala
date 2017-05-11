package com.naden.namaste.models

case class PanelType(name: String,
                     description: String,
                     scripts: Seq[String],
                     stylesheets: Seq[String],
                     userEditable: Boolean,
                     createdBy: User)
    extends Object(createdBy) {

  object Colours extends Enumeration {
    val Red, Orange, Blue, Cyan, Green = Value
  }

}
