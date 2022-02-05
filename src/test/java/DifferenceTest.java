import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DifferenceTest {

    @BeforeMethod
    public void preconditions(){
        System.out.println("Pre-conditions");
    }

    @DataProvider(name = "difference")
    public Object[][] calculator() {
        return new Object[][]{
                {3.0, 4.0, -1.0, "Incorrect 3.0, 4.0, -1.0"},
                {2.0, 7.0, -5.0, "Incorrect 2.0, 2.0, 7.0, -5.0"},
                {1.3, 4.0, -2.7, "Incorrect 1.3, 4.0, -2.7"},
                {3.0, 1.2, 1.8, "Incorrect 3.0, 1.2, 1.8"},
                {10.0, 2.0, 8.0, "Incorrect 10.0, 2.0, 8.0"},
        };
    }

    @Test(dataProvider = "difference",
            description = " Difference Test",
            invocationCount = 3,
            threadPoolSize = 2)
    public void pluralTest(double a, double b, double actualResult, String message) {
        double result = Calculator.difference(a, b);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postconditions(){
        System.out.println("Post-conditions");
    }
}

