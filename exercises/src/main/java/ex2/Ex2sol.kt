package ex2

fun isCorrectCapitalization(word: String?): Boolean {
    if((word == null) || word.isEmpty()){
        return false
    }
    val regex = "(^[A-Z]+)||(^[A-Z][a-z]+)||(^[a-z]+)"
    return word.matches(regex.toRegex())
}

