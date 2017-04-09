package services.mock

import javax.inject.{Inject, Singleton}

import models.{EntityType}
import services.{EntityTypeService, PanelService, UserService}

import scala.collection.mutable

@Singleton
class MockEntityTypeService @Inject()(panelService: PanelService, userService: UserService) extends EntityTypeService {

  val entityTypes = mutable.ListBuffer[EntityType]()

  def list(): List[EntityType] = {
    entityTypes.result()
  }

  def create(entityType: EntityType): EntityType = {
    entityTypes += entityType
    entityType
  }

  def get(entityTypeId: String): EntityType = {
    entityTypes.filter(_.guid.equals(entityTypeId)).head
  }

  def update(entityType: EntityType): EntityType = {
    entityType
  }

  def delete(entityType: EntityType): EntityType = {
    entityTypes -= entityType
    entityType
  }

  def find(term: String): List[EntityType] = {
    entityTypes.filter(_.name.contains(term)).result()
  }
}