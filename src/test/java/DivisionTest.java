import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest {

    @BeforeMethod
    public void preconditions(){
        System.out.println("Pre-conditions");
    }

    @DataProvider(name = "division")
    public Object[][] calculator() {
        return new Object[][]{
                {3.0, 4.0, 0.75, "Incorrect 3.0, 4.0, 0.75"},
                {2.0, 7.0, 0.2857142857142857, "Incorrect 2.0, 7.0, 00.2857142857142857"},
                {1.3, 4.0, 0.325, "Incorrect 1.3, 4.0, 0.325"},
                {3.0, 1.2, 2.5, "Incorrect 3.0, 1.2, 2.5"},
                {10.0, 2.0, 5.0, "Incorrect 10.0, 2.0, 5.0"},
        };
    }

    @Test(dataProvider = "division",
            description = " Division Test",
            invocationCount = 2)
    public void pluralTest(double a, double b, double actualResult, String message) {
        double result = Calculator.division(a, b);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postconditions(){
        System.out.println("Post-conditions");
    }
}
