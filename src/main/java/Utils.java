import java.util.Arrays;
import java.util.List;

public class Utils {
    public static final List<String> VALID_OPERATORS = Arrays.asList("*", "+", "/");

    public static int solveEquation(String operator, int numBefore, int numAfter) {
        switch (operator) {
            case "*":
                return numBefore * numAfter;
            case "/":
                if (numAfter == 0){
                    return -1;
                }
                return numBefore / numAfter;
            case "+":
                return numBefore + numAfter;
        }
        return -1;
    }

    public static boolean verifyEquationInput(String equation) {
        return equation != null && !equation.isEmpty();
    }

}
