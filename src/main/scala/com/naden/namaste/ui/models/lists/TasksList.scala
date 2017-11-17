package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.Task

case class TasksList(title: String,
                     icon: String,
                     tasks: List[Task])