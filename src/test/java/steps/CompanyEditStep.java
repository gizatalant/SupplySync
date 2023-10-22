package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CompaniesPage;
import pages.LoginPage;
import utilities.Driver;
import java.time.Duration;


public class CompanyEditStep {
    WebDriver driver = Driver.getDriver();
    CompaniesPage companiesPage = new CompaniesPage();
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("the admin navigates to Supply Sync login page")
    public void the_admin_navigates_to_supply_sync_login_page() {
        driver.get("https://supplysync.us/login");
    }

    @When("the admin enters email, password and clicks login button")
    public void the_admin_enters_email_and_password() {
        loginPage.login();
    }

    @When("admin navigates to edit companies page")
    public void admin_navigates_to_edit_companies_page() {
        companiesPage.companiesSectionButton.click();
    }

    @When("admin clicks the edit button of company to edit")
    public void admin_clicks_the_edit_button_of_company_to_edit() {
        companiesPage.threeDotEditButton.click();
        companiesPage.editButton.click();
    }

    @Then("admin performs editing actions, saves and verifies the changes")
    public void admin_performs_editing_actions_saves_and_verifies_the_changes() throws InterruptedException {
        companiesPage.name.click();
        Thread.sleep(2000);
        for (int i = 0; i < 30; i++) {
            companiesPage.name.sendKeys(Keys.BACK_SPACE);
        }
        String fakeCompany = faker.company().name();
        companiesPage.name.sendKeys(fakeCompany);


        companiesPage.email.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.email.sendKeys(Keys.BACK_SPACE);
        }
        String fakeEmail = faker.internet().emailAddress();
        companiesPage.email.sendKeys(fakeEmail);

        companiesPage.address.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.address.sendKeys(Keys.BACK_SPACE);
        }
        String fakeAddress = faker.country().capital();
        companiesPage.address.sendKeys(fakeAddress);

        companiesPage.phoneNumber.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.phoneNumber.sendKeys(Keys.BACK_SPACE);
        }
        String fakePhoneNumber = faker.phoneNumber().phoneNumber();
        companiesPage.phoneNumber.sendKeys(fakePhoneNumber);

        companiesPage.saveButton.click();
        String pageSource = driver.getPageSource();

        if (pageSource.contains(fakeCompany)) {
            System.out.println("Name verified");
        }
        if (pageSource.contains(fakeAddress)) {
            System.out.println("Address verified");
        }
        if (pageSource.contains(fakePhoneNumber)) {
            System.out.println("Number verified");
        }
        if (pageSource.contains(fakeEmail)) {
            System.out.println("Email verified");
        }

        WebElement verificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-caiLqq cYMnth']")));
        String messageText = verificationMessage.getText();

        System.out.println("Actual Message: " + messageText);

        if (messageText.equals("Company successfully changed")) {
            System.out.println("Verified");
        } else {
            System.out.println("Not verified");
        }
    }
}


