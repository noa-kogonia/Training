package ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSolution {
    private final String REGEX = "(\\d+)([\\+,\\*,\\/])(\\d+)";

    public int solveEquation(String equation) {
        if (Utils.verifyEquationInput(equation)) {
            Pattern expPattern = Pattern.compile(REGEX);
            Matcher expMatcher = expPattern.matcher(equation);

            if (expMatcher.matches()) {
                String operator = expMatcher.group(2);
                int numOne = Integer.parseInt(expMatcher.group(1));
                int numTwo = Integer.parseInt(expMatcher.group(3));
                return Utils.solveEquation(operator, numOne, numTwo);
            }
        }
        return -1;
    }
}
