object Dummy:
  def stringToInt(s: String): Int = s.toInt

  def combineLists(ls:List[Double]*) (op:String) : List[Double]=
    val n = ls.head.size

    def aux(l: Seq[List[Double]], n: Int) : List[Double] =
    /*l match
      case h::Nil => Nil
      case l => List(ls.map(_.head).sum) :: aux(l.map(_.tail), n-1)
    */
      if (n<=0) Nil
      else op match
        case "sum" => l.map(_.head).sum :: aux(l.map(_.tail), n-1)
        case "product" => l.map(_.head).product :: aux(l.map(_.tail), n-1)
        case "min" => l.map(_.head).min :: aux(l.map(_.tail), n-1)
        case "max" => l.map(_.head).max :: aux(l.map(_.tail), n-1)

    ls match
      case Nil => Nil
      case ls => aux(ls, n)

  def combineLists2(ls:List[Double]*) (op:String) : List[Double]=
    op match
      case "sum" => ls.map(_.sum).toList
      case "product" => ls.map(_.product).toList
      case "min" => ls.map(_.min).toList
      case "max" => ls.map(_.max).toList