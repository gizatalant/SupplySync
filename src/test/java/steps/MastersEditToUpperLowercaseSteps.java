package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.MastersPage;


public class MastersEditToUpperLowercaseSteps {
    MastersPage mastersPage = new MastersPage();
    Faker faker = new Faker();

    @Then("makes some changes to the required fields in uppercase and lowercase")
    public void makes_some_changes_to_the_required_fields_in_uppercase_and_lowercase() throws InterruptedException {
        mastersPage.firstName.click();
        Thread.sleep(2000);
        for (int i = 0; i < 30; i++) {
            mastersPage.firstName.sendKeys(Keys.BACK_SPACE);
        }
        String fakeFirstName2 = faker.name().firstName().toUpperCase();
        mastersPage.firstName.sendKeys(fakeFirstName2);

        mastersPage.lastName.click();
        for (int i = 0; i < 30; i++) {
            mastersPage.lastName.sendKeys(Keys.BACK_SPACE);
        }
        String fakeLastName2 = faker.name().lastName().toLowerCase();
        mastersPage.lastName.sendKeys(fakeLastName2);

        mastersPage.passwordInput.sendKeys("l");
    }

    @Then("uppercase and lowercase should be allowed")
    public void uppercase_and_lowercase_should_be_allowed() throws InterruptedException {
        Assert.assertTrue(mastersPage.masterChangedSuccessfully.isDisplayed());
        Thread.sleep(1000);
        System.out.println("The master's name can be changed to uppercase and lowercase");
    }


}
