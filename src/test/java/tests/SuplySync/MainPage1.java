package tests.SuplySync;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class MainPage1 {

    WebDriver driver;

    public MainPage1(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @Test
    public void mainPage(){
     driver = Driver.getDriver();
     driver.get("https://supplysync.us/login");

    }

}
