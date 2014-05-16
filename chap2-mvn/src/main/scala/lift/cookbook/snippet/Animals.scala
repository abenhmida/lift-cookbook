package lift.cookbook.snippet


import net.liftweb.util.BindHelpers._
import xml.Text

/**
 * Created with IntelliJ IDEA.
 * User: Aymen Ben Hmida
 * Date: 5/14/14
 * Time: 8:32 PM
 */
object Animals {

  def list = {
    val animals = List(
      ("Dog", "(Canis lupus familiaris)"),
      ("Cat", "(Felis catus)"),
      ("Giraffe", "(Giraffa camelopardalis)"),
      ("Lion", "(Panthera leo)"),
      ("Horse", "(Equus ferus caballus)")

    )

    "li *" #> animals.map {
      a =>
        ".name *" #> Text(a._1) & ".sname *" #> Text(a._2)
    }
  }


}
