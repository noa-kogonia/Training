import java.util.Arrays;
import java.util.List;

public class Utils {
    public static final List<String> VALID_OPERATORS = Arrays.asList("*", "+", "/");

    private Utils() {}

    private static final Utils instance = new Utils();

    public static Utils getInstance() {
        return instance;
    }

    public int calcRes(String operator, int numBefore, int numAfter) {
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

    public boolean verifyEquationInput(String equation) {
        return equation != null && !equation.isEmpty();
    }

}
