package services.mock

import javax.inject.{Inject, Singleton}

import models._

import scala.collection.{SortedMap, mutable}

@Singleton
class MockData @Inject()() {

  // Users

  var adminUser = {
    val adminUser = new User("Rachel", "Smith", "rachel.smith@gmail.com", None)
    val adminGroup = new Group("Administrators", None)
    adminUser.addToGroups(adminGroup)
    adminUser
  }

  var generalUsers = {
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

  //

  // Panels

  var recentlyUpdatedPanel = {
    val recentlyUpdatedPanel = new Panel("Recently Updated", Some(adminUser))
    recentlyUpdatedPanel.options += ("maxResults" -> 10, "restriction" -> "Current Type")
    recentlyUpdatedPanel
  }

  var relatedPanel = {
    val relatedPanel = new Panel("Related", Some(adminUser))
    relatedPanel.options += ("maxResults" -> 5, "restriction" -> "All Types")
    relatedPanel
  }

  var mostPopularPanel = {
    var mostPopularPanel = new Panel("Most Popular", Some(adminUser))
    mostPopularPanel.options += ("maxResults" -> 30, "restriction" -> "All Types")
    mostPopularPanel
  }

  var photoPanel = {
    var photoPanel = new Panel("Photo", Some(adminUser))
    photoPanel
  }

  var formPanel = {
    var formPanel = new Panel("Governance", Some(adminUser))
    formPanel.options += ("schema" -> mutable.SortedMap(
      ("Approver" -> "User", "Steward" -> "User")
    ))
    formPanel
  }

  var userPanel = {
    var userPanel = new Panel("User", Some(adminUser))
    userPanel.options += ("user" -> "Any")
    userPanel
  }

  var userListPanel = {
    var userListPanel = new Panel("User List", Some(adminUser))
    userListPanel.options += ("style" -> "Grid")
    userListPanel
  }

  // Page Type

  var tablePageType = {
    val tableType = new PageType("Table", Some(adminUser))
    tableType.detailColumnWidths = SortedMap(
      (0 -> Seq(1)),
      (1 -> Seq(4, 8)),
      (2 -> Seq(4, 4, 4))
    )

    tableType.detailPanels = SortedMap(
      ((0,0) -> Seq(photoPanel)),
      ((1,0) -> Seq(recentlyUpdatedPanel, formPanel1)),
      ((1,1) -> Seq(formPanel2, userPanel)),
      ((2,0) -> Seq(mostPopularPanel, userListPanel)),
      ((2,1) -> Seq(relatedPanel)),
      ((2,2) -> Seq(formPanel3)))
    )

    tableType
  }

  // Page

  var customerTablePage = {
    val customerTablePage = new Page("Customer Table", tablePageType, Some(adminUser))
    customerTablePage.panelValues += (formPanel -> Map("Title" -> "Test Title"))
    customerTablePage
  }
}
