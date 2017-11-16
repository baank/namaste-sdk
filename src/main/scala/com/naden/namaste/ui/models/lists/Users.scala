package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.User

case class Users(users: List[User],
                 showTitle: Boolean,
                 showOnline: Boolean,
                 showMessenging: Boolean)

case class UsersGroup(name: String,
                      users: List[User])
