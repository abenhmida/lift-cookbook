package lift.cookbook.snippet

import net.liftweb.http.js.JE.{JsFunc, JsRaw}
import net.liftweb.http.js.JsCmds
import net.liftweb.http.js.JsCmds.{Script, JsCrVar}

import net.liftweb.util.BindHelpers._

import scala.xml.Text

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 29-Jun-14
 * Time: 2:14 PM
 */
object JsCommand {

  def jsCommand = {
    val command1 = JsCrVar("fromServer",
      JsRaw( """$("#cmd2").html("this string was send from server")"""))
    val command2 = JsFunc("myFunction").cmd
    val command3 = JsCmds.SetHtml("cmd3",
      Text("changing element content using Lift's JsCmds"))
    val command5 = confirm

    "*" #> Script(command1 & command2 & command3 & command5)
  }

  def confirm = {
    val numbers = (1 to 10).toList
    val jsFunc =
      """
         var numbers = [ """ + numbers.mkString(",") + """];
         for (i = 1; i <= """ + numbers.size + """; i++) {
            $("#cmd4").append('< button data-number = "' + i + '" > ' +i + '</ button > ');
         }
        $("#cmd4 button").click(function() {
          confirm('Do you really want to delete number: ' +$(this).data("number"));
        });"""
  .stripMargin
    JsRaw(jsFunc).cmd
}

}
