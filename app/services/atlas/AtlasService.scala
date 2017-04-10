package services.atlas

import java.util.UUID

import models.Page

class AtlasService {

  // Admin

  def adminSession(): Unit =  {

  }

  def adminStack(): Unit =  {

  }

  def adminStatus(): Unit =  {

  }

  def adminVersion(): Unit =  {

  }

  // Lineage

  def hiveLineageInputGraph(table: String): Unit = {

  }

  def hiveLineageOutputGraph(table: String): Unit = {

  }

  def hiveLineageSchema(table: String): Unit = {

  }

  def lineageInputGraph(pageId: UUID) = {

  }

  def lineageOutputGraph(pageId: UUID) = {

  }

  def lineageSchema(pageId: UUID) = {

  }

  // Page

  def page(pageId: Option[UUID]): Unit = {

  }

  def createPage(page: Page): Unit = {

  }

  def updatePage(page: Page): Unit = {

  }

  def deletePage(page: Page) = {

  }

  def pageAudit(pageId: UUID): Unit = {

  }

  def pageTraitDefinitions(guid: String, traitName: Option[String]): Unit = {

  }

  def pageTraits(guid: Option[UUID], traitName: Option[String]): Unit = {

  }

  def pageQualifiedName(pageType: String, property: String, value: String): Unit = {

  }

  // Search

  def search(query: String, limit: Option[Int], offset: Option[Int]) = {

  }

  def searchDSL(query: String, limit: Option[Int], offset: Option[Int]) = {

  }

  def searchFullText(query: String, limit: Option[Int], offset: Option[Int]) = {

  }

  def searchGremlin(query: String) = {

  }

  // Page Types

  def createPageType() = {

  }

  def updatePageType() = {

  }

  def pageTypes(typeCategory: Option[String], superType: Option[String], notSuperType: Option[String]): Unit = {

  }

  def pageTypes(typeName: String) = {

  }
}