package services.atlas

import java.util.UUID

import models.Entity

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

  def lineageInputGraph(entityId: UUID) = {

  }

  def lineageOutputGraph(entityId: UUID) = {

  }

  def lineageSchema(entityId: UUID) = {

  }

  // Entity

  def entity(entityId: Option[UUID]): Unit = {

  }

  def createEntity(entity: Entity): Unit = {

  }

  def updateEntity(entity: Entity): Unit = {

  }

  def deleteEntity(entity: Entity) = {

  }

  def entityAudit(entityId: UUID): Unit = {

  }

  def entityTraitDefinitions(guid: String, traitName: Option[String]): Unit = {

  }

  def entityTraits(guid: Option[UUID], traitName: Option[String]): Unit = {

  }

  def entityQualifiedName(entityType: String, property: String, value: String): Unit = {

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

  // Entity Types

  def createEntityType() = {

  }

  def updateEntityType() = {

  }

  def entityTypes(typeCategory: Option[String], superType: Option[String], notSuperType: Option[String]): Unit = {

  }

  def entityTypes(typeName: String) = {

  }
}