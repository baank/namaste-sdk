package com.naden.sdk.util

import java.net.URI

import boopickle.Default._
import com.naden.sdk.plugin.{PageType, PanelType}
import org.threeten.bp.LocalDateTime
import squants.market.Money

object BoopickleCodecs {

	implicit val localDateTimePickler: Pickler[LocalDateTime] = transformPickler((t: Long) => DateUtils.fromMillis(t))(DateUtils.toMillis)
	implicit val moneyPickler: Pickler[Money] = transformPickler((s: String) => Money(s).get)(_.toString)
	implicit val pageTypePickler: Pickler[PageType] = transformPickler((s: String) => ReflectUtils.classForName[PageType](s))(_.getClass.getName)
	implicit val panelTypePickler: Pickler[PanelType] = transformPickler((s: String) => ReflectUtils.classForName[PageType](s))(_.getClass.getName)
	implicit val uriPickler: Pickler[URI] = transformPickler((s: String) => URI.create(s))(_.toString)

}