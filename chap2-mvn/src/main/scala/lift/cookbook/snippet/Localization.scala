package lift.cookbook.snippet

import net.liftweb.http.S
import net.liftweb.util.BindHelpers._

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 24-Jun-14
 * Time: 7:10 PM
 */
class Localization {

  def dynamic = {
    "*" #> S.?("dynamic.text")
  }

}
