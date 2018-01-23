package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.{Component, Tag}

case class TasksList(title: String,
            icon: String,
            tags: List[Tag]) extends Component


object TasksList {
	implicit val pickler: Pickler[TasksList] = generatePickler[TasksList]
}