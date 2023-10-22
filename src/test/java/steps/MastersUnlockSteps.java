package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MastersPage;


public class MastersUnlockSteps {

    MastersPage mastersPage = new MastersPage();


    @When("locates the section with the three dots and clicks")
    public void locatesTheSectionWithTheThreeDotsAndClicks() {
        mastersPage.unlockThreeDot.click();
    }


    @Then("from the dropdown menu clicks on the Unlock button")
    public void from_the_dropdown_menu_clicks_on_the_unlock_button() {
        mastersPage.unlock.click();

    }
    @Then("verifies the master is unlocked")
    public void verifies_the_master_is_unlocked() throws InterruptedException {
        if (mastersPage.mastersField.isDisplayed()){
            Thread.sleep(1000);
            System.out.println("Master unlocked");
        }
        else {
            System.out.println("Error");
        }
    }


}
