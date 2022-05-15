import java.util.Arrays;

public class CharArraySolution {
    int string_counter = 0;

    public int solveEquation(String equation) {

        if (Utils.getInstance().verifyEquationInput(equation)) {
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
                return Utils.getInstance().calcRes(Character.toString(characters[operatorLocation]), numBefore, numAfter);
            }
        }
        return -1;
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


    public boolean verifyOperator(String operatorVal, int operatorLocation) {
        if (operatorLocation == -1 || string_counter > 1) {
            return false;
        }
        return Utils.VALID_OPERATORS.contains(operatorVal);
    }
}
