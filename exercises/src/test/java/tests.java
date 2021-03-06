import ex1.CharArraySolution;
import ex1.RegexSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class tests {
    CharArraySolution charArraySolution = new CharArraySolution();
    RegexSolution regexSolution = new RegexSolution();
    private static final String ERR_MSG = "The number is not as expected: ";

    public tests() {
    }

    static Stream<Arguments> EquationAndSolutionProvider() {
        return Stream.of(
                arguments("10*2", 20),
                arguments("10/2", 5),
                arguments("10+2", 12),
                arguments("10-2", -1),
                arguments("10/0", -1),
                arguments("Noa", -1),
                arguments("", -1),
                arguments(null, -1),
                arguments("10+*7", -1),
                arguments("a*b", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("EquationAndSolutionProvider")
    public void solveEquationTest(String equation, int expected) {
        int res1 = charArraySolution.solveEquation(equation);
        int res2 = regexSolution.solveEquation(equation);
        Assertions.assertEquals(expected, res1, "Char Array Solution " + ERR_MSG + res1);
        Assertions.assertEquals(expected, res2, "Regex Solution " + ERR_MSG + res2);
    }
}
