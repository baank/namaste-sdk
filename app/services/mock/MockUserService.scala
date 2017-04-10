package services.mock

import javax.inject.{Inject, Singleton}

import models.User
import services.UserService

import scala.collection.mutable

@Singleton
class MockUserService @Inject()(mockData: MockData) extends UserService {

  val users = mutable.ListBuffer[User]()

  users += mockData.adminUser
  users ++= mockData.generalUsers

  def list(): List[User] = {
    users.result()
  }

  def create(user: User): User = {
    users += user
    user
  }

  def get(userId: String): User = {
    users.filter(_.guid.equals(userId)).head
  }

  def update(user: User): User = {
    user
  }

  def delete(user: User): User = {
    users -= user
    user
  }

  def find(term: String): List[User] = {
    users.filter(_.firstName.contains(term)).filter(_.lastName.contains(term)).result()
  }
}