package com.naden.sdk.plugin

import com.naden.sdk.models.Page
import com.naden.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

trait PageImporter extends Service {

  def importPages(pages: Seq[Page], progressObserver: ProgressObserver)

  def requiredPageTypes[PT <: PageType]: List[PT]

  def decoder: Decoder[PageImporter]

  def encoder: Encoder[PageImporter]
}
