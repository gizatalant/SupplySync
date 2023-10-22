package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MastersPage;


public class MastersBlockSteps {

    MastersPage mastersPage = new MastersPage();

    @When("locates the section with the three dots")
    public void locatesTheSectionWithTheThreeDots() {
        mastersPage.blockThreeDot.click();
    }
    @Then("from the dropdown menu clicks on the Block button")
    public void from_the_dropdown_menu_clicks_on_the_block_button() {
        mastersPage.block.click();
    }
    @Then("verifies the master is locked")
    public void verifies_the_master_is_locked() throws InterruptedException {
        if (mastersPage.mastersField.isDisplayed()){
            Thread.sleep(1000);
            System.out.println("Master blocked");
        }
        else {
            System.out.println("Error");
        }
    }


}
