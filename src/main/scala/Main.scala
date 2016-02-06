package game

import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.JSApp
import engine.Resource

object Main extends JSApp {

  def main(): Unit = {
    var res = Resource("aasdadsd")
    println(res)
    println(res.get())
  }

  def init(): Unit = {

  }
}
