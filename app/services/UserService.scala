package services

import java.util.UUID
import models.User

trait UserService {

  def list()

  def create(user: User)

  def get(id: UUID)

  def update(user: User)

  def delete(user: User)

  def find(term: String)

}
