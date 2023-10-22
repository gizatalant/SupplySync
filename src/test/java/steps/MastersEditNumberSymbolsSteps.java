package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.MastersPage;
import utilities.Driver;

public class MastersEditNumberSymbolsSteps {
    WebDriver driver = Driver.getDriver();
    MastersPage mastersPage = new MastersPage();


    @Then("makes some changes to the location field with numbers and symbols")
    public void makes_some_changes_to_the_location_field_with_numbers_and_symbols() {
                Actions actions = new Actions(driver);
        actions.moveToElement(mastersPage.location).click().keyDown(Keys.COMMAND).sendKeys("a")
                .keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).sendKeys("1237*#@%").build().perform();
        mastersPage.passwordInput.sendKeys("m");

    }

    @Then("numbers and symbols should be allowed")
    public void numbers_and_symbols_should_be_allowed() {
        Assert.assertTrue(mastersPage.masterChangedSuccessfully.isDisplayed());
        System.out.println("Numbers and symbols allowed");
    }

}
