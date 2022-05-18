import ex2.isCorrectCapitalization
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
}