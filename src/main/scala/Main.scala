package game

import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.JSApp

import engine.Resource

import upickle.default._

object Main extends JSApp {

  // Just to test nested case classes. They work! \o/
  sealed trait Component
  case class Coord(value: Int, foo: String = "defaultFoo")
  case class SpatialComponent(x: Coord, y: Coord) extends Component
  case class PhysicsComponent(physics: Int) extends Component
  case class GameObject(id: Int, name: String, components: Array[Component])

  def main(): Unit = {
    var res = Resource("aasdadsd")
    println(res)
    println(res.get())
    jsontest()
  }

  def jsontest(): Unit = {
    var jsontest = """
    {
      "id":5,
      "name":"TestGO",
      "components":[
        {
          "$type":"game.Main.SpatialComponent",
          "x":{"value":5,"foo":"xxx"},
          "y":{"value":6}
        },
        {
          "$type":"game.Main.PhysicsComponent",
          "physics":5
        }
      ]
    }
    """
    println("jsontest")
    var parsed = read[GameObject](jsontest)
    println(write(parsed))
  }
}
