package bootstrap.liftweb

import _root_.net.liftweb.common._
import _root_.net.liftweb.util._
import _root_.net.liftweb.http._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("lift.cookbook")

    val isAdmin_? = If(() => {
      S.param("admin").flatMap(asBoolean).openOr(false)
    }, () => RedirectWithState("/",
      MessageState("Authorized personnel only" -> NoticeType.Warning)))

    def sitemap = SiteMap(
      Menu.i("menu.home") / "index" >> LocGroup("content"),
      Menu("Admin") / "admin" >> Hidden
        submenus(
        Menu(Loc("List", List("list"), "List Contacts",
          isAdmin_?, LocGroup("admin"))),
        Menu(Loc("Create", List("create"), "Create Contact",
          isAdmin_?, LocGroup("admin"))),
        Menu(Loc("Edit", List("edit"), "Edit Contact",
          isAdmin_?, LocGroup("admin"))),
        Menu(Loc("Delete", List("delete"), "Delete Contact",
          isAdmin_?, LocGroup("admin"))),
        Menu(Loc("View", List("view"), "View Contact",
          isAdmin_?, LocGroup("admin")))
        ),
      Menu("Search") / "search" >> LocGroup("content"),
      Menu("Contact Us") / "contact" >> LocGroup("footer"),
      Menu("About Us") / "about" >> LocGroup("footer"),
      Menu(Loc("Static", Link(List("static"), true,
        "/static/index"),
        "menu.static", LocGroup("content"))),
      Menu.i("Animals") / "pages/listAnimals",
      Menu.i("Dynamic Table") / "pages/dynamicTables",
      Menu(Loc("403", "403" :: Nil, "403", Hidden)),
      Menu(Loc("404", "404" :: Nil, "404", Hidden)),
      Menu(Loc("500", "500" :: Nil, "500", Hidden))
    )

    LiftRules.setSiteMap(sitemap)

    LiftRules.resourceNames = "i18n/resources"  ::  LiftRules.resourceNames


    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))


    LiftRules.dispatch.append{
      case Req("error-500" :: Nil, _,_)  => {
        () => Full(InternalServerErrorResponse())
      }
      case Req("error-403" :: Nil, _,_)  => {
        () => Full(ForbiddenResponse())
      }
    }

    LiftRules.responseTransformers.append {
      case r if r.toResponse.code == 403 =>
        RedirectResponse("/403")
      case r if r.toResponse.code == 404 =>
        RedirectResponse("/404")
      case r if r.toResponse.code == 500 =>
        RedirectResponse("/500")
      case r => r
    }
  }
}

