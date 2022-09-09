import org.scalatest.funsuite.AnyFunSuite

class SetCollectionTest extends AnyFunSuite:

  test("testFlatten1") {
    val input = Set(List("A", "B"), List("C", "D"))
    val output = Set("A", "B", "C", "D")
    assert(SetCollection.flatten(input)===output)
  }

  test("testIntersection1") {
    val input = Set(Set("A", "B", "C"), Set("C", "D"))
    val output = Set("C")
    assert(SetCollection.intersection(input)===output)
  }
  test("testUnion1") {
    val input = Set(Set("A", "B", "C"), Set("C", "D"))
    val output = Set("A", "B", "C", "D")
    assert(SetCollection.union(input)===output)
  }

  test("testExpand1") {
    val input1 = Set("A", "B")
    val input2 = Set(2, 3)
    val output = Set( ("A", 2), ("A", 3) , ("B", 2), ("B", 3))
    assert(SetCollection.expand(input1,input2)===output)
  }

  test("testExpandMap1") {
    val input1 = Set("A", "B")
    val input2 = Set(2, 3)
    val output = Set( ("A", 2), ("A", 3) , ("B", 2), ("B", 3))
    assert(SetCollection.expandMap(input1,input2)===output)
  }
