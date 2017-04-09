package services.mock

import javax.inject.{Inject, Singleton}

import models.{Entity, EntityType, Panel, User}
import services.{EntityService, EntityTypeService, PanelService, UserService}

import scala.collection.mutable

@Singleton
class MockEntityService @Inject()(entityTypeService: EntityTypeService, panelService: PanelService, userService: UserService) extends EntityService {

  val entities = mutable.ListBuffer[Entity]()

  val entityTypes = entityTypeService.list()
  val panels = panelService.list()
  val users = userService.list()



  entities += new Entity("Table 1")
//
//  val u1 = new User("Michael", "Thomson", null)
//  val et1 = new EntityType("Database Table", u1)
//  et1.cols = 3
//  et1.rows = 5
//  et1.panels += ((1,1) -> new Panel(u1))

  //val e1 = new Entity("Table 1", et1, u1)




  def list(): List[Entity] = {
    entities.result()
  }

  def create(entity: Entity): Entity = {
    entities += entity
    entity
  }

  def get(entityId: String): Entity = {
    entities.filter(_.guid.equals(entityId)).head
  }

  def update(entity: Entity): Entity = {
    entity
  }

  def delete(entity: Entity): Entity = {
    entities -= entity
    entity
  }

  def find(term: String): List[Entity] = {
    entities.filter(_.name.contains(term)).result()
  }
}