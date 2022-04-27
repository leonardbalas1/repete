{
  // to return the result of executing f on the input s string when s != null

  def safeStringOp(s: String, f: String => String): String = {
    if (s != null) f(s)
    else s
  }

  val g: String => String = { s => s.toUpperCase() }
  safeStringOp("hello", g)
  safeStringOp(null, g)

  safeStringOp("hello", _.toUpperCase)
}
{
  def combination(x: Int, y: Int, f: (Int, Int) => Int): Int={
    f(x,y)
  }
  val f:(Int,Int)=>Int={
    (x,y)=>x+y
  }
  println(combination(5, 7, f))
}
{
  val doubler1: Int => Int={n=>
    n*2
  }

  val doubler2: Int => Int= n =>
    n * 2
  val doubler3: Int => Int= n =>{
    n * 2}



  val doubler4: Int => Int= n => n * 2

  val doubler: Int => Int= _*2

  val doubler5= (_: Int)* 2

  val twoInputs:(Int,String)=>String={(n, s )=>
    s*n
  }
  twoInputs(5, "hello")

}
{
  def double7(x: => Int): Int={
    println("Now doubling"+ x )
    2*x
  }
  double7(5)
}
{
  def factor(x:Int,y: Int): Boolean=y%x==0
  factor(2,6)

  val z= factor _
  val b=z(3,6)
}
{
  //companion object
  class Person(val name: String){

  }

  object Person{
    def apply(name: String): Person = new Person(name)
  }
  val damian= Person("Damian")
  damian.name
}
{
  import scala.util.Random
  val f:Int=>Int= { n =>
    println(s"n=${n}")
    if (n < 2) 3
    else 5
    n + Random.nextInt()
  }
  val ns=List(0,0,1,2,3,3)
  ns.distinctBy(f)
  val g:Int=>Boolean={n=>f(n)<4}
  ns.partition(g)
  ns.flatMap(n=>0 to n)
  ns.toSet
}
{
  Map.apply((1,"one"),(2,"two"), (3,"three"))
  Map((1,"one"),(2,"two"), (3,"three"))
  Map(
    (1,"one"),
    (2,"two"),
    (3,"three"))
  Map(
    1->"one",
    2->"two",
    3->"three")
}
{
  val razy2: Int=>Int=_*2

  println(List(1,2,3).map(razy2))
}
{
  object A {
    private val a = 1
    val b = "abc" + a
    var c = 5
    def f(x:Int) = x + 1
  }

  //A.a a is inaccesible because it is private

  A.b

  A.c = 0

  A.f(4)

  A f 4

}
{
  val f: Char => Boolean = c => c != 'e' && c != 'o'

  def f_def(c: Char):Boolean = c != 'e' && c != 'o'
  "hello".filter(f)
  "hello".filter(f_def)
}
{
  val r="asdlkjhfljdskfh".drop(5)
  println(s"Result: $r")
}
{
  "hello".apply(1)=='l'
}
{
  val g: String=> Int=s=>5
  g("hello")
}
{
  def nth(s:String, n:Int): Option[Char]= {
    if (s.nonEmpty && n >= 0) Some(s.charAt(n))
    else None
  }

  nth("", 0)
  nth("a", 0).contains("a")
  nth("ala", 1).contains('l')
  nth("ala", -1).isEmpty
}
{
  def max(a:Int,b: Int, c: Int)={
    def max(x: Int, y:Int)=if (x>y) x else y
    max(a, max(b,c))
  }
  max(32,21, 40)
}
{
  def log(d: Double) = println(f"Got value $d%.3f")
  log(2.324566)
}
{
  def power(x:Int,n:Int): Long={
    if(n >= 1) x* power(x,n-1)
    else 1
  }
  power(3,3)
}
{
  def power2(a: Int,b: Int, c: Int=1): Int={
    if(b<1) c
    else power2(a,b-1,a*c)
  }
  power2(4,2)
}
{
  "hello".++("world")
}
{
  val l= List(1,2,3,4,5)
  l.map(x=>x*2)
  def f(x: Int) = if (x > 2) Some(x) else None
  l.flatMap(x=> f(x))
}
{
  val s= (1,2)
  s._1
  s._2
}
{
  val l= List(1,2,3,4,5)
  def g(v:Int) = List(v-1, v, v+1)
  l.map(x => g(x))
}
{
  val m = Map(1 -> 2, 2 -> 4, 3 -> 6)
  m.toList
  m.flatMap(e => List(e._2))
  def h(k:Int, v:Int) = if (v > 2) Some(k->v) else None
  m.flatMap ( e => h(e._1,e._2) )
  m.flatMap { case (k,v) => h(k,v) }
}