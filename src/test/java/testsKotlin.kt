import ex2.isCorrectCapitalization
import ex3.compareTwoSentencesReturnDiff
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class testsKotlin {

     private fun wordAndExpectedProvider(): Stream<Arguments?>? {
        return Stream.of(
            Arguments.arguments("NOA", true),
            Arguments.arguments("Noa", true),
            Arguments.arguments("noa", true),
            Arguments.arguments("nOA", false),
            Arguments.arguments("NOa", false),
            Arguments.arguments("No1A", false),
            Arguments.arguments("NOA1", false),
            Arguments.arguments(null, false),
            Arguments.arguments("", false)
        )
    }

    @ParameterizedTest
    @MethodSource("wordAndExpectedProvider")
    fun isCorrectCapitalization_test(word:String?, expected: Boolean){
        val res: Boolean = isCorrectCapitalization(word)
        Assertions.assertEquals(expected, res, "The word is not according to the requested format, expected: $expected, actual: $res")
    }


    private fun sentencesAndDiffsProvider(): Stream<Arguments?>? {
        return Stream.of(
            Arguments.arguments("I adopted a cat", "I adopted a dog", "(cat, dog)"),
            Arguments.arguments("My name is Noa Kogonia", "My name is Maxim Shoustin","(Noa, Kogonia, Maxim, Shoustin)"),
            Arguments.arguments("Banana Apple Pineapple", "Apple Banana Pineapple", "()"),
            Arguments.arguments("I adopted a cat", "I adopted a cat", "()"),
            Arguments.arguments("I adopted a cat", "I a cat adopted", "()"),
        )
    }

    @ParameterizedTest
    @MethodSource("sentencesAndDiffsProvider")
    fun compareTwoSentences_test(sentence1:String, sentence2:String, diffs:String){
        val res: String = compareTwoSentencesReturnDiff(sentence1,sentence2)
        Assertions.assertEquals(diffs,res,"the diffs couldn't be found - or wrong")
    }
}