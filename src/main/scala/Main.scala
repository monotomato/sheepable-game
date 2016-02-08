package game

import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.JSApp

import engine.Resource

import upickle.default._

object Main extends JSApp {

  // Just to test nested case classes. They work! \o/
  case class Coord(value: Int, foo: String = "defaultFoo")
  case class SpatialComponent(x: Coord, y: Coord)
  case class GameObject(id: Int, name: String, spatial: SpatialComponent)

  def main(): Unit = {
    var res = Resource("aasdadsd")
    println(res)
    println(res.get())
    jsontest()
  }

  def jsontest(): Unit = {
    val spatjson =
      """
      {
        "x":{"value":1312},
        "y":{"value":3, "foo":"qqqq"}
      }
      """
    val gameobjectjson =
      """
      {
        "id":1,
        "name": "TestGameObject",
        "spatial":{
          "x":{"value":3},
          "y":{"value":3, "foo":"asd"}
        }
      }
      """

    var spatial = read[SpatialComponent](spatjson);

    var gameObject = read[GameObject](gameobjectjson);

    println(spatial)
    println(gameObject)
  }
}
