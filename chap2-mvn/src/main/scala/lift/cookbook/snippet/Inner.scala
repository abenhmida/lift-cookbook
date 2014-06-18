package lift.cookbook.snippet

import net.liftweb.util.Helpers._

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 04-Jun-14
 * Time: 9:21 PM
 */
object Inner {
  def logged = {
    "div *" #> "Should only be visible when user is logged in"
  }

  def nonlogged = {
    "div *" #> "Should only be visible when user is not logged in"
  }
}