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

    def sitemap = SiteMap(
      Menu.i("Home") / "index",
      Menu.i("Animals") / "pages/listAnimals",
      Menu.i("Dynamic Table") / "pages/dynamicTables"
    )

    LiftRules.setSiteMap(sitemap)
    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))
  }
}

