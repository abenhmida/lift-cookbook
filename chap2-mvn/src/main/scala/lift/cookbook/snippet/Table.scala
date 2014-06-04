package lift.cookbook.snippet

import net.liftweb.util.Helpers._

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 5/16/14
 * Time: 8:13 PM
 */
object Table {

  def dynamic = {
    val headers = 1 to 10
    val table = headers map {
      n => (1 to 10).map {
        in => n * in
      }
    }

    "th *" #> headers &
      "tbody tr *" #> table.map(r => "td *" #> r)

  }

}
