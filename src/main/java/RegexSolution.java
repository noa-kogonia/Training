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
                int numBefore = Integer.parseInt(expMatcher.group(1));
                int numAfter = Integer.parseInt(expMatcher.group(3));

                if (Utils.VALID_OPERATORS.contains(operator)){
                    return Utils.solveEquation(operator, numBefore, numAfter);
                }
            }
        }
        return -1;
    }
}
