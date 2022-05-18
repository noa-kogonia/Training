package ex2

fun isCorrectCapitalization(word: String?): Boolean {
    val regex = "(^[A-Z][A-Z]+)||(^[A-Z][a-z]+)||(^[a-z][a-z]+)"
    if((word == null) || word.isEmpty()) return false
    return word.matches(regex.toRegex())
}

