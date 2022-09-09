object SetCollection:
  /***
   * TODO: flatten the Set sl, without using the flatten function. Create at least two scalatest tests.
   *       Example: s = Set(List("A", "B"), List("C", "D") ; returns Set("A", "B", "C", "D")
   */
  def flatten [A](sl: Set[List[A]]): Set[A] =
    if sl.isEmpty then Set()
    else sl.head.toSet ++ flatten(sl.tail)

  /***
   * TODO: calculate the intersection of all the sets in ss. Create at least two scalatest tests.
   *       Example: s = Set(List("A", "B", "C"), List("C", "D") ; returns Set("C")
   */
  def intersection[A](ss: Set[Set[A]]): Set[A] =
    if ss.size == 1 then ss.head
    else ss.head & intersection(ss.tail)

  /***
   * TODO: calculate the union of all the sets in ss. Create at least two scalatest tests.
   *       Example: s = Set(List("A", "B"), List("C", "D") ; returns Set("A", "B", "C", "D")
   */
  def union[A](ss: Set[Set[A]]): Set[A] =
    if ss.size == 1 then ss.head
    else ss.head | intersection(ss.tail)
  /***
   * TODO: expand the Set s to contain as many tuples as the combination of set s with set si. Create at least two scalatest tests.
   *       Example: s = Set("A", "B") ; si = Set(2, 3) ; returns Set( ("A", 2), ("A", 3) , ("B", 2), ("B", 3))
   */
  def expand[A,B](ss: Set[A], si: Set[B]): Set[(A, B)] =
    def aux (h: A, si: List[B]): List[(A,B)] =
      if (si.isEmpty) List()
      else (h, si.head) :: aux(h, si.tail)
    
    if(ss.isEmpty) Set()
    else aux(ss.head, si.toList).toSet ++ expand(ss.tail, si) 
  
  def expandMap[A,B](ss: Set[A], si: Set[B]): Set[(A, B)] =
    ss.map(x => si.map(y => (x,y))).flatten
