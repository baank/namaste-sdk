package services.atlas

import javax.inject.{Inject, Singleton}

import models.User
import services.UserService

@Singleton
class AtlasUserService @Inject() (atlasService: AtlasService) extends UserService {

  def list(): List[User] = {
    null
  }

  def create(user: User): User = {
    null
  }

  def get(userId: String): User = {
    null
  }

  def update(user: User): User = {
    null
  }

  def delete(user: User): User = {
    null
  }

  def find(term: String): List[User] = {
    null
  }

}