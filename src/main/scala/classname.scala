
class ClassName[A] private (val clazz: Class[A]) {
  override def toString(): String = {
    clazz.getName
  }
}

object ClassName {
  def create[A](clazz: Class[A]): ClassName[A] = new ClassName(clazz)
  def create[A]()(implicit m: ClassManifest[A]) = new ClassName(m.erasure)
}

object Main extends App {
  val c1 = ClassName.create(classOf[String])
  println(c1.toString)

  val c2 = ClassName.create[Int]
  println(c2.toString)
}
