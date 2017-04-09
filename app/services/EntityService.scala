package services

import models.Entity

trait EntityService {

  def list(): List[Entity]

  def create(entity: Entity): Entity

  def get(entityId: String): Entity

  def update(entity: Entity): Entity

  def delete(entity: Entity): Entity

  def find(term: String): List[Entity]

}
