package ex1;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static final List<String> VALID_OPERATORS = Arrays.asList("*", "+", "/");

    public static int solveEquation(String operator, int numOne, int numTwo) {
        switch (operator) {
            case "*":
                return numOne * numTwo;
            case "/":
                if (numTwo == 0){
                    return -1;
                }
                return numOne / numTwo;
            case "+":
                return numOne + numTwo;
        }
        return -1;
    }

    public static boolean verifyEquationInput(String equation) {
        return equation != null && !equation.isEmpty();
    }

}
