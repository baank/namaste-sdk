package com.naden.namaste.ui.components

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div
import org.scalajs.dom.document
import squants.market.Money

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Main") object Main {

  @dom def sample: Binding[Div] = {
    <div>{ Money.apply("3").get.amount.toString() }</div>
  }

  @JSExport def app(): Unit = {
    dom.render(document.getElementById("container"), sample)
  }

  def main(args: Array[String]): Unit = {
    println("Welcome to Namaste")
  }
}