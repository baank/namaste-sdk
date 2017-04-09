package services.atlas

import javax.inject.{Inject, Singleton}

import models.User
import services.UserService

import scala.util.Try

@Singleton
class AtlasUserService @Inject() (atlasService: AtlasService) extends UserService {

  def list(): List[User] = {

  }

  def create(user: User): User = {

  }

  def get(userId: String): User {

  }

  def update(user: User): User = {

  }

  def delete(user: User): User = {

  }

  def find(term: String): List[User] = {

  }

}