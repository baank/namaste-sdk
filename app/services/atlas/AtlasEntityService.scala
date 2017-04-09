package services.atlas

import javax.inject.{Inject, Singleton}

import models.Entity
import services.EntityService

import scala.util.Try

@Singleton
class AtlasEntityService @Inject()(atlasService: AtlasService) extends EntityService {

  def list(): List[Entity] = {

  }

  def create(entity: Entity): Entity = {

  }

  def get(entityID: String): Entity = {

  }

  def update(entity: Entity): Entity = {

  }

  def delete(entity: Entity): Entity = {

  }

  def find(term: String): List[Entity] = {

  }

}