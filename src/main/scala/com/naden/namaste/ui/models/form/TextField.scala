package com.naden.namaste.ui.models.form

case class TextField(name: String,
                     label: String,
                     idealLength: Option[(Int, Int)] = None,
                     maxLength: Option[Int] = None,
                     inputFormat: Option[String] = None,
                     placeholder: String,
                     value: String)
