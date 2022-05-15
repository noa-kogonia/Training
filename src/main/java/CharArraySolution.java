import java.util.Arrays;

public class CharArraySolution {

    public int solveEquation(String equation) {

        if (Utils.verifyEquationInput(equation)) {
            char[] characters = equation.toCharArray();
            int operator_location = findOperator(characters);

            if (operator_location != -1) {
                if (Utils.VALID_OPERATORS.contains(Character.toString(characters[operator_location]))) {
                    int numBefore = Integer.parseInt(
                            String.valueOf(Arrays.copyOfRange(characters, 0, operator_location)));
                    int numAfter = Integer.parseInt(
                            String.valueOf(Arrays.copyOfRange(characters, operator_location + 1, characters.length)));
                    return Utils.solveEquation(Character.toString(characters[operator_location]), numBefore, numAfter);
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    private int findOperator(char[] characters) {
        int string_counter = 0;
        int operator_loc = 0;
        for (int i = 0; i < characters.length; i++) {
            if (!Character.isDigit(characters[i])) {
                string_counter++;
                operator_loc = i;
            }
        }
        if (string_counter == 1) {
            return operator_loc;
        }
        return -1;
    }

}
