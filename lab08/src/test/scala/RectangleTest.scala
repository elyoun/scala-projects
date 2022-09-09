import org.scalatest.funsuite.AnyFunSuite

class RectangleTest extends AnyFunSuite:

  test("testSortRectangle 1") {
    val input1 = List( (8,9), (7,100), (1,1))
    val input2 = Rectangle.fPerimeter
    val output = List((1,1), (8,9), (7,100))
    assert(Rectangle.sortRectangles(input1,input2 ) === output)
  }

  test("testR2String 1") {
    val input = (2,4)
    val output = "rectangle with sides (2, 4) in some unit of measure"
    assert(Rectangle.r2String((2,4)) === output)
  }  
  
  test("testPerimeter 1") {
    val input = (2,4)
    val output = 12
    assert(Rectangle.perimeter(input) === output)
  }

  test("testArea1") {
    val input = (2,2)
    val output = 4
    assert(Rectangle.area(input) === output)
  }

  test("testFarea1") {
    val input1 = (2,2)
    val input2 = (200,200)
    val output = true
    assert(Rectangle.fArea(input1,input2) === output)
  }

  test("testFperimeter1") {
    val input1 = (2,2)
    val input2 = (200,200)
    val output = true
    assert(Rectangle.fPerimeter(input1,input2) === output)
  }

  test("testGreatestTriangle") {
    val input1 = (8,9)
    val output = 2
    assert(Rectangle.greatestTriangle(input1) === output)
  }

  test("testNumberOfSquares") {
    val input1 = (8,2)
    val input2 = 2
    val output = 4
    assert(Rectangle.numberOfSquares(input1, input2) === output)
  }

  test("testNumberOfSquares 2") {
    val input1 = (8,2)
    val input2 = 3
    val output = 0
    assert(Rectangle.numberOfSquares(input1, input2) === output)
  }

  test("testNumberOfSquares 3") {
    val input1 = (7,3)
    val input2 = 3
    val output = 2
    assert(Rectangle.numberOfSquares(input1, input2) === output)
  }

  test("testNumberOfSquares 4") {
    val input1 = (3,7)
    val input2 = 3
    val output = 2
    assert(Rectangle.numberOfSquares(input1, input2) === output)
  }

  test("testNumberOfSquares 5") {
    val input1 = (3,8)
    val input2 = 3
    val output = 2
    assert(Rectangle.numberOfSquares(input1, input2) === output)
  }

  test("testNumberOfSquares 6") {
    val input1 = (3,9)
    val input2 = 3
    val output = 3
    assert(Rectangle.numberOfSquares(input1, input2) === output)
  }

  test("sumSidesR 1") {
    val input = List( (10,20), (100,200), (1000, 2000) )
    val output = (1110,2220)
    assert(Rectangle.sumSidesR(input) === output)
  }

  test("sumSidesJ 1") {
    val input = List( (30,20), (1080,200), (1000, 2000) )
    val output = (20+200+1000,30+1080+2000)
    assert(Rectangle.sumSidesJ(input) === output)
  }

  test("mapByF 1") {
    val input1 =  List( (2,4), (4,2), (3,3), (3,3), (4,4))
    val input2 = Rectangle.perimeter
    val output = Map(12 -> List((2,4), (4,2), (3,3), (3,3)), 16 -> List((4,4)))
    assert(Rectangle.mapByF(input1, input2) === output)
  }

  test("mapWithUniqueByF") {
    val input1 =  List( (2,4), (4,2), (3,3), (3,3), (4,4))
    val input2 = Rectangle.perimeter
    val output = Map(12 -> List((2,4), (4,2), (3,3)), 16 -> List((4,4)))
    assert(Rectangle.mapWithUniqueByF(input1, input2) === output)
  }