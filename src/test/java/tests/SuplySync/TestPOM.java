package tests.SuplySync;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;

public class TestPOM {

    WebDriver driver;
    @BeforeTest
    public void before() {
        driver = Driver.getDriver();
    }

    @Test (priority = 1)
    public void loginPage() {
        driver.get("https://supplysync.us/login");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test (priority = 2)
    public void invalidEmail() {
        driver.get("https://supplysync.us/login");
        LoginPage loginPage = new LoginPage();
        loginPage.invalidEmail();
        if (loginPage.errorMessage.isDisplayed()){
            System.out.println("Login or password is incorrect, try again");
        }
        else{
            System.out.println("You have successfully logged in");
        }
    }

    @Test (priority = 3)
    public void testEditCompanyInfo() {
        driver.get("https://supplysync.us/dashboard/companies");
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        CompaniesPage companiesPage = new CompaniesPage();
        companiesPage.companiesSectionButton.click();
        companiesPage.threeDotEditButton.click();
        companiesPage.editButton.click();

        companiesPage.name.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.name.sendKeys(Keys.BACK_SPACE);
        }
        companiesPage.name.sendKeys("Codewise");

        companiesPage.email.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.email.sendKeys(Keys.BACK_SPACE);
        }
        companiesPage.email.sendKeys("codewise@gmail.com");

        companiesPage.address.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.address.sendKeys(Keys.BACK_SPACE);
        }
        companiesPage.address.sendKeys("Chicago City");

        companiesPage.phoneNumber.click();
        for (int i = 0; i < 30; i++) {
            companiesPage.phoneNumber.sendKeys(Keys.BACK_SPACE);
        }
        companiesPage.phoneNumber.sendKeys("555555555");

        companiesPage.saveButton.click();

        String pageSource = driver.getPageSource();

        if (pageSource.contains("Codewise")) {
            System.out.println("Name verified");
        }
        if (pageSource.contains("Chicago city")) {
            System.out.println("Address verified");
        }
        if (pageSource.contains("+996 555 555 555")) {
            System.out.println("Number verified");
        }
        if (pageSource.contains("codewise@gmail.com")) {
            System.out.println("Email verified");
        }
    }


    @Test (priority = 4)
    public void testEditMastersName() throws InterruptedException {

        driver.get("https://supplysync.us/dashboard/masters");
        MastersPage mastersPage = new MastersPage();
        mastersPage.threeDot.click();
        mastersPage.edit.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(mastersPage.firstName).click().keyDown(Keys.COMMAND).sendKeys("a")
                .keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).sendKeys("Giza").build().perform();
        Thread.sleep(1000);
        actions.moveToElement(mastersPage.lastName).click().keyDown(Keys.COMMAND).sendKeys("a")
                .keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).sendKeys("Talant").build().perform();
        mastersPage.passwordInput.sendKeys("k");
        mastersPage.saveButton.click();
        Assert.assertTrue(mastersPage.masterChangedSuccessfully.isDisplayed());
        System.out.println("Master changed successfully");

    }

    @Test (priority = 5)
    public void testMasterNameNumbersAndSymbols() throws InterruptedException {

        driver.get("https://supplysync.us/dashboard/masters");
        MastersPage mastersPage = new MastersPage();

        mastersPage.threeDot.click();
        mastersPage.edit.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(mastersPage.location).click().keyDown(Keys.COMMAND).sendKeys("a")
                .keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).sendKeys("1237*#@%").build().perform();
        Thread.sleep(1000);
        mastersPage.passwordInput.sendKeys("m");
        mastersPage.saveButton.click();
        Assert.assertTrue(mastersPage.masterChangedSuccessfully.isDisplayed());
        System.out.println("Numbers and symbols allowed");
    }

    @Test (priority = 6)
    public void testMastersNameUpperAndLowercase() throws InterruptedException {

        driver.get("https://supplysync.us/dashboard/masters");
        MastersPage mastersPage = new MastersPage();
        mastersPage.threeDot.click();
        mastersPage.edit.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(mastersPage.firstName).click().keyDown(Keys.COMMAND).sendKeys("a")
                .keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).sendKeys("bug".toUpperCase()).build().perform();
        Thread.sleep(1000);
        actions.moveToElement(mastersPage.lastName).click().keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE).sendKeys("HUNTERS".toLowerCase()).build().perform();
        mastersPage.passwordInput.sendKeys("l");
        mastersPage.saveButton.click();
        Assert.assertTrue(mastersPage.masterChangedSuccessfully.isDisplayed());
        System.out.println("The master's name can be changed to uppercase and lowercase");
    }

    @Test (priority = 7)
    public void blockTheMasters(){
        driver.get("https://supplysync.us/dashboard/masters");
        MastersPage mastersPage = new MastersPage();
        mastersPage.blockThreeDot.click();
        mastersPage.block.click();
        if (mastersPage.mastersField.isDisplayed()){
            System.out.println("Master blocked");
        }
        else {
            System.out.println("Error");
        }
    }

    @Test (priority = 8)
    public void unlockTheMasters(){
        driver.get("https://supplysync.us/dashboard/masters");
        MastersPage mastersPage = new MastersPage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        mastersPage.unlockThreeDot.click();
        mastersPage.unlock.click();
        if (mastersPage.mastersField.isDisplayed()){
            System.out.println("Master unlocked");
        }
        else {
            System.out.println("Error");
        }
    }


    @Test (priority = 9)
    public void logout() {

        LogoutPage logoutPage = new LogoutPage();
        logoutPage.administrator.click();
        logoutPage.exit.click();
        logoutPage.exitPopup.click();
        String expectedURL = "https://supplysync.us/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "User successfully logged out");

    }

}






