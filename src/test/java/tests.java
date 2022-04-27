import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class tests {
    Exe1 exe1 = new Exe1();
    private static final String ERR_MSG = "The number is not as expected: ";
    public tests() {
    }

    @Test
    public void solveEquationTestMultiply() {
        int res1 = exe1.solveEquation("10*2");
        int res2 = exe1.solveEquation2ndWay("10*2");
        Assertions.assertEquals(20, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(20, res2, "2nd func " + ERR_MSG + res2);
    }

    @Test
    public void solveEquationTestSplit() {
        int res1 = exe1.solveEquation("10/2");
        int res2 = exe1.solveEquation2ndWay("10/2");
        int res3 = exe1.solveEquationRegex("10/2");
        Assertions.assertEquals(5, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(5, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(5, res3, "3rd func " + ERR_MSG + res3);
    }

    @Test
    public void solveEquationTestSum() {
        int res1 = exe1.solveEquation("10+2");
        int res2 = exe1.solveEquation2ndWay("10+2");
        int res3 = exe1.solveEquationRegex("10+2");
        Assertions.assertEquals(12, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(12, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(12, res3, "3rd func " + ERR_MSG + res3);
    }

    @Test
    public void solveEquationTestInvalid() {
        int res1 = exe1.solveEquation("10-2");
        int res2 = exe1.solveEquation2ndWay("10-2");
        int res3 = exe1.solveEquationRegex("10-2");
        Assertions.assertEquals(-1, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(-1, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(-1, res3, "3rd func " + ERR_MSG + res3);
    }

    @Test
    public void solveEquationTestDivideByZero() {
        int res1 = exe1.solveEquation("10/0");
        int res2 = exe1.solveEquation2ndWay("10/0");
        int res3 = exe1.solveEquationRegex("10/0");
        Assertions.assertEquals(-1, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(-1, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(-1, res3, "3rd func " + ERR_MSG + res3);
    }

    @Test
    public void solveEquationTestString() {
        int res1 = exe1.solveEquation("Noa");
        int res2 = exe1.solveEquation2ndWay("Noa");
        int res3 = exe1.solveEquation2ndWay("Noa");
        Assertions.assertEquals(-1, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(-1, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(-1, res3, "3rd func " + ERR_MSG + res3);
    }

    @Test
    public void solveEquationTestNull() {
        int res1 = exe1.solveEquation(null);
        int res2 = exe1.solveEquation(null);
        int res3 = exe1.solveEquationRegex(null);
        Assertions.assertEquals(-1, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(-1, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(-1, res3, "3rd func " + ERR_MSG + res3);
    }

    @Test
    public void solveEquationTestEmptyString() {
        int res1 = exe1.solveEquation("");
        int res2 = exe1.solveEquation2ndWay("");
        int res3 = exe1.solveEquationRegex("");
        Assertions.assertEquals(-1, res1, "1st func "+ ERR_MSG + res1);
        Assertions.assertEquals(-1, res2, "2nd func " + ERR_MSG + res2);
        Assertions.assertEquals(-1, res3, "3rd func " + ERR_MSG + res3);
    }
}
