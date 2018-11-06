package lab5.isbnVerifier

class IsbnVerifier {
    fun isValid(isbn: String): Boolean =
            isbn
                .matches(Regex("[0-9](-?[0-9]){8}-?[0-9X]")) &&
            isbn
                .filter { it != '-' }
                .map { c -> if (Character.isDigit(c)) c - '0' else 10 }
                .mapIndexed { index, digit -> digit * (10 - index) }
                .sum() % 11 == 0
}
