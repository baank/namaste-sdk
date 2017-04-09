package services

import models.Panel

trait PanelService {

  def list(): List[Panel]

  def create(panel: Panel): Panel

  def get(panelId: String): Panel

  def update(panel: Panel): Panel

  def delete(panel: Panel): Panel

  def find(term: String): List[Panel]

}
