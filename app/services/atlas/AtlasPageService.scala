package services.atlas

import javax.inject.{Inject, Singleton}

import models.{Page, PageType}
import services.PageService

@Singleton
class AtlasPageService @Inject()(atlasService: AtlasService) extends PageService {

  def list(): List[Page] = {
    null
  }

  def create(page: Page): Page = {
    null
  }

  def getByLinkId(pageType: PageType, pageLinkId: String): Page = {
    null
  }

  def get(pageID: String): Page = {
    null
  }

  def update(page: Page): Page = {
    null
  }

  def delete(page: Page): Page = {
    null
  }

  def find(term: String): List[Page] = {
    null
  }
}