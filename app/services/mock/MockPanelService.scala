package services.mock

import javax.inject.{Inject, Singleton}

import models.Panel
import services.PanelService

import scala.collection.mutable

@Singleton
class MockPanelService @Inject()(mockData: MockData) extends PanelService {

  val panels = mutable.ListBuffer[Panel]()

  panels += mockData.formPanel
  panels += mockData.mostPopularPanel
  panels += mockData.photoPanel
  panels += mockData.recentlyUpdatedPanel
  panels += mockData.relatedPanel
  panels += mockData.userListPanel
  panels += mockData.userPanel

  def list(): List[Panel] = {
    panels.result()
  }

  def create(panel: Panel): Panel = {
    panels += panel
    panel
  }

  def get(pageId: String): Panel = {
    panels.filter(_.guid.equals(pageId)).head
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