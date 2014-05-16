package lift.cookbook.lib

import net.liftweb.util.Mailer._
import net.liftweb.util.Mailer

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 5/12/14
 * Time: 9:45 PM
 */
object SendEmail {

  def send_!(from: String, recipient: String, subject: String, body: String) = {
    val mailTypes = List(PlainMailBodyType(body), To(recipient))

    Mailer.msgSendImpl(From(from), Subject(subject), mailTypes)
  }

}
