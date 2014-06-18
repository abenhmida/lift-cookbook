package lift.cookbook.snippet

import net.liftweb.http.S
import net.liftweb.common.Full
import net.liftweb.util.Helpers._

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 04-Jun-14
 * Time: 9:11 PM
 */
object Outer {

  def choose = {
    val loggedIn = S.param("loggedin").flatMap(asBoolean)
    loggedIn match {
      case Full(b) if b => ". inner-div [class+]" #> "lift:Inner.logged"
      case _ => ".inner-div [class+]" #> "lift:Inner.nonlogged"
    }
  }

}
