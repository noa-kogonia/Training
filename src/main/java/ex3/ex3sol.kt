package ex3

fun compareTwoSentencesReturnDiff(sen1: String, sen2: String): String {
    val words1 = splitSentenceIntoWords(sen1)
    val words2 = splitSentenceIntoWords(sen2)
    val diff = findDiff(words1, words2).toString()
    diff.replace("[", "(")
    diff.replace("]", ")")

    return diff
}

fun findDiff(sen1: List<String>, sen2: List<String>): List<String> {
    val diffList = sen1.filterNot { sen2.contains(it) }.toMutableList()
    diffList.addAll(sen2.filterNot { sen1.contains(it) })
    return diffList
}

fun splitSentenceIntoWords(sen: String): List<String> {
    val regex = """^[,\.]|[,\.]$""".toRegex()
    val splitBy = "\\s+".toRegex()
    val words = sen.split(splitBy).map { word ->
        word.replace(regex, "")
    }
    return words
}

