package Lab3

object Lab3 
{
  val DEFAULT_PRECISION = 0.0001
  private def square(x: Double) = x * x
  private def isGoodEnough(y: Double, x: Double, precision: Double) = Math.abs(square(y) - x) < precision
  private def improve(y: Double, x: Double) = (y + x/y) / 2
  private def sqrtIter(y: Double, x: Double, precision: Double): Double = if (isGoodEnough(y, x, precision)) 
    y else sqrtIter(improve(y, x), x, precision)
  def sqrt(x: Double, precision: Double = DEFAULT_PRECISION) =
    if (x > 0) Math.round(sqrtIter(1, x, precision) * (1/precision)) * precision
    else if (x == 0) 0.0
    else throw new IllegalArgumentException("x should be positive or 0")
  }