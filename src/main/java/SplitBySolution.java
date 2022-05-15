import java.util.Objects;

public class SplitBySolution {

    public int solveEquation(String equation) {
        if (Utils.getInstance().verifyEquationInput(equation)) {
            if (findOperator(equation) != null) {
                String[] parts = equation.split(Objects.requireNonNull(findOperator(equation)));
                return Utils.getInstance().calcRes(
                        Objects.requireNonNull(findOperator(equation)).replace("\\",""),
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1])
                );
            }
        }
        return -1;
    }

    private String findOperator(String equation) {
        for (String operator : Utils.VALID_OPERATORS) {
            if (equation.contains(operator)) return "\\" + operator;
        }
        return null;
    }

}
