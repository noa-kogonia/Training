package ex3

fun compareTwoSentences(sen1: String, sen2: String): String {
    val regex = """^[,\.]|[,\.]$""".toRegex()
    val splitBy = "\\s+".toRegex()
    val words1 = sen1.split(splitBy).map { word ->
        word.replace(regex, "")
    }

    val words2 = sen2.split(splitBy).map { word ->
        word.replace(regex, "")
    }
    return words1.filterNot { words2.contains(it) }.toString()
}
