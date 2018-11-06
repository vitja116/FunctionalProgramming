package lab5.wordCount

object WordCount {
    fun phrase(string: String): Map<String, Number> =
        Regex("[a-zA-Z0-9]+(\'[a-zA-Z0-9]+)?")
            .findAll(string.toLowerCase())
            .map { it.value }
            .groupingBy { it }
            .fold(0) { acc, word -> acc + 1}
}