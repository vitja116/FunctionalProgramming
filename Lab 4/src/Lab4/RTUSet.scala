
package Lab4

object RTUSet {
  /**
    * We define a set by its characteristic function
    */
  type Set = Int => Boolean

  /**
    * If  a set contains an element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Singleton set from one element
    */
  def singletonSet(elem: Int): Set = _ == elem

  /**
    * Union of the two sets
    */
  def union(s: Set, t: Set): Set = (x : Int) => s(x) || t(x)

  /**
    * Intersection of the two sets
    */
  def intersect(s: Set, t: Set): Set = (x : Int) => s(x) && t(x)

  /**
    * Difference of two given sets
    */
  def diff(s: Set, t: Set): Set = (x : Int) => s(x) && !t(x)

  /**
    * Filter
    */
  def filter(s: Set, p: Int => Boolean): Set = (x: Int) => p(x) && s(x)

  /** =========== For brave enough =========== */


  val bound = 1000

  /**
    * if  all bounded integers within s satisfy p
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }


  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, !p(_))


  def map(s: Set, f: Int => Int): Set = (x: Int) => s(f(x))

  def mapSet(s: Set, f: Int => Int): Set = (x: Int) => !forall(s, f(_) != x)

  /**
    * Displays the contents of a set
    */
  def toString(s: Set): String = {
    def removeTrailingComma (str: String) = if (str.endsWith(",")) str.substring(0, str.length() - 1) else str
    def iter(a: Int, str: String): String = {
      if (a > bound) f"${removeTrailingComma(str)}}"
      else if (s(a)) iter(a + 1, f"${str}${a},")
      else iter(a + 1, str)
    }
    return iter(-bound, "{")
  }
}