package com.naden.sdk.models

import org.threeten.bp.LocalDateTime
import java.util.UUID

import io.circe.generic.JsonCodec
import shapeless._
import shapeless.labelled.FieldType
import shapeless.record._

@JsonCodec
sealed trait Status
object Status {
  case object Active extends Status
  case object Delete extends Status
}

abstract class Entity {

  val createdBy: User

  val guid: UUID = UUID.randomUUID()
  val createTime: LocalDateTime = LocalDateTime.now
  val status: Status = Status.Active
  val updateTime: LocalDateTime = createTime
  val updatedBy: User = createdBy
  val version = 0L
  val icon = "Default.png"
  val relationships: Map[String, UUID] = Map()

  override def equals(o: Any): Boolean = o match {
    case that: Entity => that.guid.equals(this.guid)
    case _            => false
  }

  override final def hashCode(): Int = guid.hashCode
}

object Entity {
  trait ToMap[L <: HList] { def apply(l: L): Map[String, Any] }

  trait LowPriorityToMap {
    implicit def hconsToMap1[K <: Symbol, V, T <: HList](implicit
                                                            wit: Witness.Aux[K],
                                                            tmrT: Lazy[ToMap[T]]
                                                           ): ToMap[FieldType[K, V] :: T] = (l: FieldType[K, V] :: T) => {
      tmrT.value(l.tail) + (wit.value.name -> l.head)
    }
  }

  object ToMap extends LowPriorityToMap {
    implicit val hnilToMap: ToMap[HNil] = (l: HNil) => {
      Map.empty
    }

    implicit def hconsToMap0[K <: Symbol, V, R <: HList, T <: HList](implicit
                                                                        wit: Witness.Aux[K],
                                                                        gen: LabelledGeneric.Aux[V, R],
                                                                        tmrH: Lazy[ToMap[R]],
                                                                        tmrT: Lazy[ToMap[T]]
                                                                       ): ToMap[FieldType[K, V] :: T] = (l: FieldType[K, V] :: T) => {
      tmrT.value(l.tail) + (wit.value.name -> tmrH.value(gen.to(l.head)))
    }
  }

  implicit class ToMapOps[A](val a: A) extends AnyVal {
    def toMap[L <: HList](implicit
                             gen: LabelledGeneric.Aux[A, L],
                             tmr: Lazy[ToMap[L]]
                            ): Map[String, Any] = tmr.value(gen.to(a))
  }
}

