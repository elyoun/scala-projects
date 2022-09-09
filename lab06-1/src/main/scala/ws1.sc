def combineLists2(ls:List[Double]*): Seq[List[Double]]=
  ls
//val list1 = List(10.0, 40.0, 30.0), List(20.0, 50.0, 30.0), List(30.0, 60.0, 30.0)
//combineLists2(List(10,40), List(20,50), List(30,60)).toList
//list1.head.size
//val res = List(list1.map(_.head).sum) :: List(list1.map(_.tail).map(_.head).sum)

val list2 = List(List(10,40), List(20,50), List(30,60))
List(list2.map(_.head).sum) :: List((list2.map(_.tail)).map(_.head).sum)
val res2= list2.map(_.tail)
res2.map(_.head).sum

list2.transpose
list2.map(_.head)
list2.map(_.tail)





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

combineLists(List(10,40,4), List(20,50,56), List(30,60,43)) ("sum")
combineLists(List(18.7, 16.3) , List(11.5, 12.1),  List(18.1, 19.9)) ("product")

def combineLists2(ls:List[Double]*) (op:String) : List[Double]=
  op match
    case "sum" => ls.map(_.sum).toList
    case "product" => ls.map(_.product).toList
    case "min" => ls.map(_.min).toList
    case "max" => ls.map(_.max).toList


combineLists2(List(10.0,40.0,4.0), List(20.0,50.0,56.0), List(30.0,60.0,43.0)) ("sum")


