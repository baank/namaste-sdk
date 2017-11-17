package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.User

case class Users(title: String,
                 icon: String,
                 users: List[User],
                 showPosition: Boolean,
                 showOnline: Boolean,
                 showMessenging: Boolean)

case class UsersGroup(name: String,
                      users: List[User])
