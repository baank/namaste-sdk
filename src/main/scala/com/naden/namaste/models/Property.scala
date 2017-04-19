package com.naden.namaste.models

case class Property(var name: String, createdBy: Option[User]) extends Object(createdBy) {

}
