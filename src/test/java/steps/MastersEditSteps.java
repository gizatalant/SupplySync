package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.MastersPage;



public class MastersEditSteps {
    MastersPage mastersPage = new MastersPage();
    Faker faker = new Faker();

    @Given("admin locates Masters field")
    public void admin_locates_masters_field() {
        mastersPage.master.click();

    }
    @When("locates the section with the three dots and clicks on them")
    public void locates_the_section_with_the_three_dots_and_clicks_on_them() {
        mastersPage.threeDot.click();

    }

    @When("from the dropdown menu clicks on the Edit button")
    public void from_the_dropdown_menu_clicks_on_the_edit_button() {
        mastersPage.edit.click();

    }

    @Then("makes some changes to the required fields")
    public void makes_some_changes_to_the_required_fields() throws InterruptedException {


        mastersPage.firstName.click();
        Thread.sleep(2000);
        for (int i = 0; i < 30; i++) {
            mastersPage.firstName.sendKeys(Keys.BACK_SPACE);
        }
        String fakeFirstName = faker.name().firstName();
        mastersPage.firstName.sendKeys(fakeFirstName);

        mastersPage.lastName.click();
        for (int i = 0; i < 30; i++) {
            mastersPage.lastName.sendKeys(Keys.BACK_SPACE);
        }
        String fakeLastName = faker.name().lastName();
        mastersPage.lastName.sendKeys(fakeLastName);

        mastersPage.passwordInput.sendKeys("l");
    }

    @And("clicks on the Save button")
    public void clicks_on_the_save_button() {
        mastersPage.saveButtonMasterField.click();

    }

    @Then("admin verifies that the changes were successfully saved")
    public void admin_verifies_that_the_changes_were_successfully_saved() {
        Assert.assertTrue("Editing failed", mastersPage.masterChangedSuccessfully.isDisplayed());
        System.out.println("Master changed successfully");
    }
}
