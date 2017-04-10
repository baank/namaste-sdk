package controllers

import javax.inject.{Inject, Singleton}

import org.apache.commons.lang3.text.WordUtils
import play.api.mvc.{AbstractController, ControllerComponents}
import services.{PageService, PageTypeService}

@Singleton
class PageController @Inject()(pageTypeService: PageTypeService, pageService: PageService, components: ControllerComponents, assetsFinder: AssetsFinder) extends AbstractController(components) {

//  def home(pageType: String, pageId: String) = Action {
//    val page = pageService.get(pageId)
//    Ok(views.html.Page(page, "Your new application is ready.", assetsFinder))
//  }
//
//  def list(pageType: String) = Action {
//    val page = pageService.list()
//    Ok(views.html.Page(page, "Your new application is ready.", assetsFinder))
//  }

  def page(pageTypeName: String, pageLinkId: String) = Action {
    val pageType = pageTypeService.getByName(WordUtils.capitalizeFully(pageTypeName))
    val page = pageService.getByLinkId(pageType, pageLinkId)
    Ok(views.html.Page(pageType.detailColumnWidths, pageType.detailPanels.toMap, page.panelValues.toMap, page.name, assetsFinder))
  }
}
