package services.mock

import javax.inject.{Inject, Singleton}

import models.PageType
import services.PageTypeService

import scala.collection.mutable

@Singleton
class MockPageTypeService @Inject()(mockData: MockData) extends PageTypeService {

  val pageTypes = mutable.ListBuffer[PageType]()

  pageTypes += mockData.tablePageType

  def list(): List[PageType] = {
    pageTypes.result()
  }

  def create(pageType: PageType): PageType = {
    pageTypes += pageType
    pageType
  }

  def getByName(pageTypeName: String): PageType = {
    pageTypes.filter(_.name.equals(pageTypeName)).head
  }

  def get(pageTypeId: String): PageType = {
    pageTypes.filter(_.guid.equals(pageTypeId)).head
  }

  def update(pageType: PageType): PageType = {
    pageType
  }

  def delete(pageType: PageType): PageType = {
    pageTypes -= pageType
    pageType
  }

  def find(term: String): List[PageType] = {
    pageTypes.filter(_.name.contains(term)).result()
  }
}