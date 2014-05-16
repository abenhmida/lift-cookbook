package lift.cookbook.snippet

import net.liftweb.common.Logger
import net.liftweb.util.Helpers._
import scala.xml.Text

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 5/10/14
 * Time: 10:25 PM
 */
class ListUser extends Logger {

  def log(text: String) {
    text match {
      case str if str.length == 0 => error("user with no name")
      case str if str == "Forbidden" => warn("this user shouldn't have access")
      case str => debug("user name: " + str)
    }
  }

  def list = {
    val users = List("John", "Sarah", "Peter", "Sam", "", "Forbidden")
    info("list Users")
    "li .name *" #> users.map {
      user => {
        log(user)
        Text(user)
      }
    }
  }

}
