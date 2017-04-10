package services.mock

import javax.inject.{Inject, Singleton}

import models.{Page, PageType}
import services.PageService

import scala.collection.mutable

@Singleton
class MockPageService @Inject()(mockData: MockData) extends PageService {

  val entities = mutable.ListBuffer[Page]()

  entities += mockData.customerTablePage
  println("Mock Customer Table Page ID = " + mockData.customerTablePage.linkId)

  def list(): List[Page] = {
    entities.result()
  }

  def create(page: Page): Page = {
    entities += page
    page
  }

  def getByLinkId(pageType: PageType, pageLinkId: String): Page = {
    entities.head
    //entities.filter(_.pageType.equals(pageType)).filter(_.linkId.equals(pageLinkId)).head
  }

  def get(pageId: String): Page = {
    entities.filter(_.guid.equals(pageId)).head
  }

  def update(page: Page): Page = {
    page
  }

  def delete(page: Page): Page = {
    entities -= page
    page
  }

  def find(term: String): List[Page] = {
    entities.filter(_.name.contains(term)).result()
  }
}