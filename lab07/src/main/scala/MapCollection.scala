object MapCollection:


  /***
   * TODO: Sum all values of map m
   *       Example: m = Map("A" -> 1, "B" -> 2, "C" -> 10) ; returns 13
   */
  def sumValues(m: Map[String, Int]): Int =
    m.map((s,i) => i).sum



  /***
   * TODO: concatenate all the keys of map m
   *       Example: m1 = Map("A" -> 1, "B" -> 2, "C" -> 10) ; returns "ABC"
   */
  def concatKeys(m: Map[String, Int]): String =
    m.map((s,i) => s).mkString

  
  /***
   * TODO: Add a String s as a key of map m. If s does not exist, add with value i, if it exists, sum i to the value.
   *       Example: s = "B", i=4, m = Map("A" -> 3, "B" -> 1, "C" ->2) ; returns Map("A" -> 3, "B" -> 5, "C" ->2)
   */
  def addToMap(s: String, i: Int, m: Map[String, Int]): Map[String, Int] =
    if (!m.contains(s)) m + (s -> i)
    else m + (s -> (m.get(s).get + i))
    //m + (s -> (m.getOrElse(s, 0) + i))
  
  /***
   * TODO: transform the list of String into a map which keys are each unique String in m, and which values are the number of occurrences of the key.
   *       use the previous addToMap function
   *       Example: l = List("A", "B", "A", "C", "C", "A") ; returns Map("A" -> 3, "B" -> 1, "C" ->2)
   */
  def toMap(l: List[String]): Map[String, Int] =
    if(l.isEmpty) Map()
    //else addToMap(l.head,l.count(el => el == l.head),toMap(l.tail.filterNot(el => el == l.head)))
    else addToMap(l.head, 1, toMap(l.tail))
    
  /***
   * TODO: Create a fusion of maps m1 and m2, by adding the values of equal keys
   *       use the previous addToMap function
   *       Example: m1 = Map("A" -> 1, "B" -> 2) ; m2 = Map("A" -> 5, "C" -> 10) ; returns Map( "A" -> 6, "B" -> 2, "C" -> 10)
   */
  def fusion(m1: Map[String, Int], m2: Map[String, Int]): Map[String, Int] =
    if (m1.isEmpty) m2
    else addToMap(m1.head._1, m1.head._2, fusion(m1.tail, m2))


  /***
   * TODO: Transform the map m into a Map which keys are the values of m and which values are the list of
   *       m keys. Create at least two scalatest tests.
   *       Example: m = Map("A" -> 1, "B" -> 2, "C" -> 1) ; returns Map( 1 -> List("A", "C"), 2 -> List("B"))
   */
  def invert[A,B](m: Map[A, B]): Map[B, List[A]] =

    m.foldLeft(Map.empty[B,List[A]]) { case (m2, (a,b)) => m2 + (b -> (m2.getOrElse(b,List()) ::: List(a)))}


    /*def aux(l: List[(A, B)]) : List[(B,List[A])] =
      l match
        case Nil => Nil
        case (x,y)::t => (y, l.filter(_._2==y).map(_._1)) :: aux(t.filterNot(_._2==y))*/

    //aux(m.toList).toMap

