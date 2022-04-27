import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exe1 {
    int string_counter = 0;
    List<String> validOperators = new ArrayList<String>() {{
        add("*");
        add("+");
        add("/");
    }};

    public boolean verifyEquationInput(String equation) {
        return equation != null && !equation.isEmpty();
    }

    public int findOperator(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if (!Character.isDigit(characters[i])) {
                string_counter++;
                return i;
            }
        }
        return -1;
    }

    public int solveEquation(String equation) {

        if (verifyEquationInput(equation)) {
            char[] characters = equation.toCharArray();
            int operatorLocation = findOperator(characters);

            if (verifyOperator(Character.toString(characters[operatorLocation]), operatorLocation)) {
                int numBefore = Integer.parseInt(
                        String.valueOf(
                                Arrays.copyOfRange(characters, 0, operatorLocation))
                );
                int numAfter = Integer.parseInt(
                        String.valueOf(
                                Arrays.copyOfRange(characters, operatorLocation + 1, characters.length))
                );

                if (numAfter == 0) return -1;
                return calcRes(Character.toString(characters[operatorLocation]), numBefore, numAfter);
            }
        }
        return -1;
    }

    public boolean verifyOperator(String operatorVal, int operatorLocation) {

        if (operatorLocation == -1) return false;
        if (string_counter > 1) return false;
        return validOperators.contains(operatorVal);
    }


    public int solveEquation2ndWay(String equation) {
        if (equation == null || equation.isEmpty()) return -1;

        if (findOperator(equation) != null) {
            String[] parts = equation.split(findOperator(equation));
            return calculateRes(
                    findOperator(equation),
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1])
            );
        }
        return -1;
    }


    public String findOperator(String equation) {
        for (String operator : validOperators) {
            if (equation.contains(operator)) return "\\" + operator;
        }
        return null;
    }

    public int calculateRes(String operator, int numBefore, int numAfter) {
        switch (operator) {
            case "\\/":
                if (numAfter == 0) return -1;
                return numBefore / numAfter;
            case "\\*":
                return numBefore * numAfter;
            case "\\+":
                return numBefore + numAfter;
        }
        return -1;
    }


    public int solveEquationRegex(String equation) {
        if(equation == null || equation.isEmpty()){
            return -1;
        }

        String regex = "(\\d+)([\\+,\\*,\\/])(\\d+)";
        Pattern expPattern = Pattern.compile(regex);
        Matcher expMatcher = expPattern.matcher(equation);

        if (expMatcher.matches()) {
            String operator = expMatcher.group(2);
            int numBefore = Integer.parseInt(expMatcher.group(1));
            int numAfter = Integer.parseInt(expMatcher.group(3));

            if (validOperators.contains(operator)) {
                return calcRes(operator, numBefore, numAfter);
            }
        }
        return -1;
    }

    public int calcRes(String operator, int numBefore, int numAfter) {
        switch (operator) {
            case "*":
                return numBefore * numAfter;
            case "/":
                if (numAfter == 0) return -1;
                return numBefore / numAfter;
            case "+":
                return numBefore + numAfter;
        }
        return -1;
    }
}
