package services

import models.PageType

trait PageTypeService {

  def list(): List[PageType]

  def create(pageType: PageType): PageType

  def get(pageTypeId: String): PageType

  def getByName(pageTypeName: String): PageType

  def update(pageType: PageType): PageType

  def delete(pageType: PageType): PageType

  def find(term: String): List[PageType]

}
