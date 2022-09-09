import scala.language.adhocExtensions
import org.scalatest.funsuite.AnyFunSuite

/*Incomplete testing*/

class testDummy extends AnyFunSuite:
  test("Dummy test") {
    val input = "7"
    val expected = 7
    assert(Dummy.stringToInt(input) === expected)
  }

  test("combineLists1"){
    val input = (List(18.7,16.3), List(11.5,12.1), List(18.1,19.9))
    val input2 = ("sum")
    val expected = List(48.3, 48.3)
    assert(Dummy.combineLists(input) (input2) === expected)
  }
