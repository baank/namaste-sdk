package models

object PanelType extends Enumeration {
  val Related, RecentlyUpdated, MostPopular, GitObject, Photo, Video, Form, Entity, List, User, Wiki, Document, Calendar = Value
}

class Panel(createdBy: String) extends AtlasObject(createdBy: String) {



}
