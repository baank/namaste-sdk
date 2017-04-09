package services.mock

import models.{EntityType, Group, Panel, User}

import scala.collection.mutable

object MockData {


  // Entity Type

  def getTableType = {
    val tableType = new EntityType("Table", Some(adminUser))
    tableType.rows = 2
    tableType.cols = 2
    tableType.panels += ((0,0) -> recentlyUpdatedPanel)
    tableType.panels += ((0,1) -> recentlyUpdatedPanel)
    tableType.panels += ((1,0) -> recentlyUpdatedPanel)
    tableType.panels += ((1,1) -> recentlyUpdatedPanel)
    tableType
  }


  // Panels

  def recentlyUpdatedPanel = {
    val recentlyUpdatedPanel = new Panel("Recently Updated", Some(adminUser))
    recentlyUpdatedPanel.options += ("maxResults" -> 10, "restriction" -> "Current Type")
    recentlyUpdatedPanel
  }

  def relatedPanel = {
    val relatedPanel = new Panel("Related", Some(adminUser))
    relatedPanel.options += ("maxResults" -> 5, "restriction" -> "All Types")
    relatedPanel
  }

  def mostPopularPanel = {
    var mostPopularPanel = new Panel("Most Popular", Some(adminUser))
    mostPopularPanel.options += ("maxResults" -> 30, "restriction" -> "All Types")
    mostPopularPanel
  }

  def photoPanel = {
    var photoPanel = new Panel("Photo", Some(adminUser))
    photoPanel
  }

  def formPanel = {
    var formPanel = new Panel("Form", Some(adminUser))
    formPanel.options += ("schema" -> mutable.SortedMap(
      ("Title" -> "Text Field", "Description" -> "Rich Text Field")
    ))
    formPanel
  }

  def userPanel = {
    var userPanel = new Panel("User", Some(adminUser))
    userPanel.options += ("user" -> "Any")
    userPanel
  }

  def userListPanel = {
    var userListPanel = new Panel("User List", Some(adminUser))
    userListPanel.options += ("style" -> "Grid")
    userListPanel
  }

  // Users

  def adminUser = {
    val adminUser = new User("Rachel", "Smith", "rachel.smith@gmail.com", None)
    val adminGroup = new Group("Administrators", None)
    adminUser.addToGroups(adminGroup)
    adminUser
  }

  def generalUsers = {
    val userGroup = new Group("Users", Some(adminUser))
    val dataStewardsGroup = new Group("Data Stewards", Some(adminUser))

    val firstNames = List("Michael", "Jack", "Julie", "Rachael", "Nathan", "Chloe", "Sandra", "Brock")
    val lastNames = List("Thomson", "Smith", "Jackson", "Reynolds", "Cruise", "Park")

    val users = mutable.ListBuffer[User]()

    for (firstName <- firstNames; lastName <- lastNames) {
      val user = new User(firstName, lastName, s"$firstName.$lastName@gmail.com", Some(adminUser))
      user.addToGroups(userGroup)
      users += user
    }

    users.result()
  }





}
