import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSolution {

    public int solveEquation(String equation) {
        if (Utils.getInstance().verifyEquationInput(equation)) {
            String regex = "(\\d+)([\\+,\\*,\\/])(\\d+)";
            Pattern expPattern = Pattern.compile(regex);
            Matcher expMatcher = expPattern.matcher(equation);

            if (expMatcher.matches()) {
                String operator = expMatcher.group(2);
                int numBefore = Integer.parseInt(expMatcher.group(1));
                int numAfter = Integer.parseInt(expMatcher.group(3));

                if (Utils.VALID_OPERATORS.contains(operator))
                    return Utils.getInstance().calcRes(operator, numBefore, numAfter);
            }
        }
        return -1;
    }
}
