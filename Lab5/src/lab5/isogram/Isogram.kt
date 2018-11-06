package lab5.isogram

object Isogram {
    fun isIsogram(string: String): Boolean = !string
                .toLowerCase()
                .filter { !setOf(' ', '-').contains(it) }
                .groupingBy { it }
                .fold(0) { acc, value -> acc + 1 }
                .any { it.value > 1 }
}
