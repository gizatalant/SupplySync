package tests.SuplySync;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogoutPage {
    public LogoutPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[contains(text(),'Administrator')]")
    public WebElement administrator;

    @FindBy(xpath = "//li/img[@alt='Logout']")
    public WebElement exit;

    @FindBy(xpath = "//div/button[contains(text(),'Exit')]")
    public WebElement exitPopup;



    }


