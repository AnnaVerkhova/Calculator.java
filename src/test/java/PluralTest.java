import org.testng.Assert;
import org.testng.annotations.*;

public class PluralTest {

    @BeforeMethod
    public void preconditions(){
        System.out.println("Pre-conditions");
    }

    @DataProvider(name = "plural")
    public Object[][] calculator() {
        return new Object[][]{
                {3.0, 4.0, 12.0, "Incorrect 3.0, 4.0 ,12.0"},
                {2.0, 7.0, 14.0, "Incorrect 2.0, 7.0, 14.0"},
                {1.3, 4.0, 5.2, "Incorrect 1.3, 4.0, 5.2"},
                {3.2, 1.2, 3.84, "Incorrect 3.2, 1.2, 3.84"},
                {0.0, 1.0, 0.0, "Incorrect 0.0, 1.0, 0.0"},
        };
    }

    @Test(dataProvider = "plural",
            description = " Plural Test"
           // dependsOnMethods ="preconditions"
    )
    public void pluralTest(double a, double b, double actualResult, String message) {
        double result = Calculator.plural(a, b);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postconditions(){
        System.out.println("Post-conditions");
    }
}
