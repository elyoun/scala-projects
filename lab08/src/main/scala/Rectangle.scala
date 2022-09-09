import scala.annotation.tailrec

object Rectangle:

  // Functions to manipule rectangle represented by a tuple (x,y), where
  // x and y are integers that represent the rectangle's measure in some
  // unit measure (not important for the exercises)

  //An alias
  type Rectangle = (Int, Int)

  def r2String( r : Rectangle): String =
    "rectangle with sides " + "(" + r._1 + ", " + r._2 + ")"  + " in some unit of measure"

  def perimeter( r : Rectangle): Long =
    r._1 * 2 + r._2 * 2

  def area( r : Rectangle): Long =
    r._1 * r._2

  def fPerimeter(x : Rectangle, y : Rectangle) : Boolean =
    if(perimeter(x) < perimeter(y)) true
    else false

  def fArea(x : Rectangle, y : Rectangle) : Boolean =
    if(area(x) < area(y)) true
    else false

  def sortRectangles (l : List[Rectangle], f:(Rectangle,Rectangle) => Boolean ) : List[Rectangle] =
    l.sortWith((x,y) => f(x,y))

  def greatestTriangle(r : Rectangle): Int =
    @tailrec
    def commonDenom (x: Int, y: Int, c: Int): Int =
      if (x % c == 0 && y % c == 0) commonDenom(x, y, c+1)
      else c

    commonDenom(r._1, r._2, 1)

  def numberOfSquares(r:Rectangle, s:Int): Int =
    (r._1 / s) * (r._2 / s)

  def sumSidesR(l : List[Rectangle]) : (Int, Int) =
    l.reduceLeft((a,b) => ((a._1 + b._1),(a._2 + b._2)))


  def sumSidesJ(l : List[Rectangle]) : (Int, Int) =

    l.foldLeft((0,0))((a,b) => ((a._1 min a._2) + (b._1 min b._2), (a._1 max a._2) + (b._1 max b._2)))

  def mapByF(l : List[Rectangle], f:  Rectangle => Long):Map[Long, List[(Int, Int)]] =

    def addToMap(s: Long, i: (Int, Int), m: Map[Long, List[(Int, Int)]]): Map[Long, List[(Int, Int)]] = 
      if (!m.contains(s)) m + (s -> List(i))
      else m + (s -> (m.get(s).get :+ i))

    l.foldLeft(Map[Long, List[(Int, Int)]]()){case (la, (i1,i2)) => addToMap(f(i1,i2), (i1,i2), la)}

  def mapWithUniqueByF(l : List[Rectangle], f:  Rectangle => Long):Map[Long, List[(Int, Int)]] =

    val list1 = l.toSet

    def addToMap(s: Long, i: (Int, Int), m: Map[Long, List[(Int, Int)]]): Map[Long, List[(Int, Int)]] =
      if (!m.contains(s)) m + (s -> List(i))
      else m + (s -> (m.get(s).get :+ i))

    list1.foldLeft(Map[Long, List[(Int, Int)]]()){case (la, (i1,i2)) => addToMap(f(i1,i2), (i1,i2), la)}





