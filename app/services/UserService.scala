package services

import models.User

trait UserService {

  def list(): List[User]

  def create(user: User): User

  def get(userId: String): User

  def update(user: User): User

  def delete(user: User): User

  def find(term: String): List[User]

}
