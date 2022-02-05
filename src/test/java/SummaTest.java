import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SummaTest {

    @BeforeMethod
    public void preconditions(){
        System.out.println("Pre-conditions");
    }

    @DataProvider(name = "summa")
    public Object[][] calculator() {
        return new Object[][]{
                {3.0, 4.0, 7.0, "Incorrect 3.0, 4.0, 7.0"},
                {2.0, 7.0, 9.0, "Incorrect 2.0, 7.0, 9.0"},
                {1.3, 4.0, 5.3, "Incorrect 1.3, 4.0, 5.3"},
                {3.2, 1.2, 4.4, "Incorrect 3.2, 1.2, 4.4"},
                {0.0, 1.0, 1.0, "Incorrect 0.0, 1.0, 1.0"},
        };
    }

    @Test(dataProvider = "summa",
            description = " Summa Test",
            priority = 1)
    public void pluralTest1(double a, double b, double actualResult, String message) {
        double result = Calculator.summa(a, b);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postconditions(){
        System.out.println("Post-conditions");
    }
}

