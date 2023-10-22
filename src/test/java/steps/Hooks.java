package steps;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class Hooks {

    WebDriver driver;

    @Before
    public void before(){
        driver = Driver.getDriver();

    }
}
