package services

import models.{Page, PageType}

trait PageService {

  def list(): List[Page]

  def create(page: Page): Page

  def getByLinkId(pageType: PageType, pageLinkId: String): Page

  def get(pageId: String): Page

  def update(page: Page): Page

  def delete(page: Page): Page

  def find(term: String): List[Page]

}
