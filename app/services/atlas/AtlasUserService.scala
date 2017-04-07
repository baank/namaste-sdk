package services.atlas

import java.util.UUID
import javax.inject.{Inject, Singleton}

import models.User
import services.UserService

@Singleton
class AtlasUserService @Inject() (atlasService: AtlasService) extends UserService {

  def list() = {

  }

  def create(user: User) = {

  }

  def get(id: UUID) = {

  }

  def update(user: User) = {

  }

  def delete(user: User) = {

  }

  def find(term: String) = {

  }

}