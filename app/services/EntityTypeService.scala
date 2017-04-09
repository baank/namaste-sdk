package services

import models.EntityType


trait EntityTypeService {

  def list(): List[EntityType]

  def create(entityType: EntityType): EntityType

  def get(entityTypeId: String): EntityType

  def update(entityType: EntityType): EntityType

  def delete(entityType: EntityType): EntityType

  def find(term: String): List[EntityType]

}
