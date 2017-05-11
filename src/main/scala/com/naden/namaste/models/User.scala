package com.naden.namaste.models

case class User(firstName: String,
                lastName: String,
                emailAddress: String,
                createdBy: User,
                groups: Set[Group])
    extends Object(createdBy)


