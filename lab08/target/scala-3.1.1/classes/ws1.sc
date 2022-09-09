
import Rectangle.{Rectangle, perimeter}

import scala.annotation.tailrec

type Rectangle = (Int, Int)

def perimeter( r : Rectangle): Long =
  r._1 * 2 + r._2 * 2

def fPerimeter(x : Rectangle, y : Rectangle) : Boolean =
  if(perimeter(x) < perimeter(y)) true
  else false

def sortRectangles (l : List[Rectangle], f:(Rectangle,Rectangle) => Boolean ) : List[Rectangle] =
  l.sortWith((x,y) => f(x,y))

sortRectangles((List( (8,9), (7,100), (1,1))), fPerimeter)

def greatestTriangle(r : Rectangle): Int =
  @tailrec
  def commonDenom (x: Int, y: Int, c: Int): Int =
    if (x % c == 0 && y % c == 0) c
    else commonDenom(x, y, c-1)

  commonDenom(r._1, r._2, List(r._1, r._2).min)

greatestTriangle(16, 12)

val list1 = List( (30,20), (1080,200), (1000, 2000) )
val list2 = List(1,2,3,4)

list1.reduceLeft((a,b) => ((a._1 + b._1),(a._2 + b._2)))

val list3 = List( (2,4), (4,2), (3,3), (3,3), (4,4))

val listmap = list3.map(perimeter(_))
val listingz = (listmap.head, list3.head)

listmap.head
list3.foldLeft(List())((a,b) => (a,b))

val m = Map(6.toLong -> List((1,2)))
m.get(6).get
m.contains(6)

def addToMap(s: Long, i: (Int, Int), m: Map[Long, List[(Int, Int)]]): Map[Long, List[(Int, Int)]] =
  if (!m.contains(s)) m + (s -> List(i))
  else m + (s -> (m.get(s).get :+ i))

def mapByF(l : List[Rectangle], f:  Rectangle => Long):Map[Long, List[(Int, Int)]] =

  def addToMap(s: Long, i: (Int, Int), m: Map[Long, List[(Int, Int)]]): Map[Long, List[(Int, Int)]] =
    if (!m.contains(s)) m + (s -> List(i))
    else m + (s -> (m.get(s).get :+ i))

  l.foldLeft(Map[Long, List[(Int, Int)]]()){case (la, (i1,i2)) => addToMap(f(i1,i2), (i1,i2), la)}

mapByF(List( (2,4), (4,2), (3,3), (3,3), (4,4)), perimeter)

list3.filterNot(list3.head == _)