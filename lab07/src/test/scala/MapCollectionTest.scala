import org.scalatest.funsuite.AnyFunSuite

class MapCollectionTest extends AnyFunSuite:

  test("testSumValues1") {
    val input = Map("A" -> 1, "B" -> 2, "C" -> 10)
    val output = 13
    assert(MapCollection.sumValues(input)===output)
  }

  test("testConcatKeys1") {
    val input = Map("A" -> 1, "B" -> 2, "C" -> 10)
    val output = "ABC"
    assert(MapCollection.concatKeys(input)===output)
  }

  test("testAddToMap1") {
    val input1 = "B"
    val input2 = 4
    val input3 = Map("A" -> 3, "B" -> 1, "C" -> 2)
    val output = Map("A" -> 3, "B" -> 5, "C" -> 2)
    assert(MapCollection.addToMap(input1,input2,input3)===output)
  }

  test("testToMap1") {
    val input = List("A", "B", "A", "C", "C", "A")
    val output = Map("A" -> 3, "B" -> 1, "C" -> 2)
    assert(MapCollection.toMap(input)===output)

  }
  
  test("testFusion1") {
    val input1 = Map("A" -> 2, "B" -> 2)
    val input2 = Map("A" -> 5, "C" -> 10)
    val output = Map("A" -> 7, "B" -> 2, "C" -> 10)
    assert(MapCollection.fusion(input1,input2)===output)
  }

  test("testInvert1") {
    val input = Map("A" -> 1, "B" -> 2, "C" -> 1)
    val output = Map( 1 -> List("A", "C"),  2 -> List("B") )
    assert(MapCollection.invert(input)===output)
  }

