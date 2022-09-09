import MapCollection.{addToMap, fusion}

val list1 = List("A", "B", "A", "C", "C", "A")


def listToTuples (l: List[String]) : List[(String, Int)] =
  l match
    case Nil => Nil
    case (h::t) => (h, l.filter(_ == h).size) :: listToTuples(l.filterNot(_ == h))

val list2 = listToTuples(list1)

def fusion(m1: Map[String, Int], m2: Map[String, Int]): Map[String, Int] =
  if (m1.isEmpty) m2
  else addToMap(m1.head.head, m1.head.tail.head, fusion(m1.tail, m2))

val m1 = Map("A" -> 1, "B" -> 2)
val m2 = Map("A" -> 5, "C" -> 10)

fusion(m1, m2)

def fusionFold(m1: Map[String, Int], m2: Map[String, Int]): Map[String, Int] =


def addToMap(s: String, i: Int, m: Map[String, Int]): Map[String, Int] =
  if (!m.contains(s)) m + (s -> i)
  else m + (s -> (m.get(s).get + i))

val m80 = Map("A" -> 5, "C" -> 10, "D" -> 5)
addToMap(m80.head.head, 1, m80)

Map("A" -> 6, "B" -> 10, "C" -> 20).foldLeft(Map("A" -> 1)){case (a, (k,v)) => addToMap(k,v,a)}
