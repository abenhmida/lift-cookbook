package lift.cookbook.snippet

import lift.cookbook.lib.SendEmail
import net.liftweb.util.Props
import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml
import scala.xml.Text

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 5/12/14
 * Time: 9:51 PM
 */
class EmailSnippet {

  def sendNow() = {
    SendEmail.send_!(Props.get("mail.user").get,
      "aymen.benhmida@lapostee.net",
      "Sending e-mail using GMail",
      "Here is the body content.")
  }

  def sendEmail = {
    "*" #> SHtml.link("#", () => sendNow(), Text("Send Email"))
  }

}
