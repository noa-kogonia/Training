import java.util.Arrays;

public class CharArraySolution {

    public int solveEquation(String equation) {
        if (Utils.verifyEquationInput(equation)) {
            char[] characters = equation.toCharArray();
            int operatorLocation = findOperator(characters);

            if (operatorLocation == -1) {
                return operatorLocation;
            }

            String operator = Character.toString(characters[operatorLocation]);
            if (Utils.VALID_OPERATORS.contains(operator)) {
                int numOne = Integer.parseInt(
                        String.valueOf(Arrays.copyOfRange(characters, 0, operatorLocation)));
                int numTwo = Integer.parseInt(
                        String.valueOf(Arrays.copyOfRange(characters, operatorLocation + 1, characters.length)));
                return Utils.solveEquation(operator, numOne, numTwo);
            } else {
                return -1;
            }
        }

        return -1;
    }

    private int findOperator(char[] characters) {
        int stringCounter = 0;
        int operatorLoc = 0;
        for (int i = 0; i < characters.length; i++) {
            if (!Character.isDigit(characters[i])) {
                stringCounter++;
                operatorLoc = i;
            }
        }
        if (stringCounter == 1) {
            return operatorLoc;
        }
        return -1;
    }

}
