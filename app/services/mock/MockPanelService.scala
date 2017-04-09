package services.mock

import javax.inject.{Inject, Singleton}

import models.{Panel}
import services.{PanelService, UserService}

import scala.collection.mutable

@Singleton
class MockPanelService @Inject()(userService: UserService) extends PanelService {

  val panels = mutable.ListBuffer[Panel]()

  panels += MockData.formPanel
  panels += MockData.mostPopularPanel
  panels += MockData.photoPanel
  panels += MockData.recentlyUpdatedPanel
  panels += MockData.relatedPanel
  panels += MockData.userListPanel
  panels += MockData.userPanel

  def list(): List[Panel] = {
    panels.result()
  }

  def create(panel: Panel): Panel = {
    panels += panel
    panel
  }

  def get(entityId: String): Panel = {
    panels.filter(_.guid.equals(entityId)).head
  }

  def update(panel: Panel): Panel = {
    panel
  }

  def delete(panel: Panel): Panel = {
    panels -= panel
    panel
  }

  def find(term: String): List[Panel] = {
    panels.filter(_.name.contains(term)).result()
  }
}