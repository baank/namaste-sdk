package services

import models.PanelType

trait PanelTypeService {

  def list(): List[PanelType]

  def get(panelName: String): PanelType

  def find(term: String): List[PanelType]

}
