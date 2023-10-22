package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div/input[@name='email']")
    public WebElement emailBox;


    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


    @FindBy(xpath = "//p[contains(text(),'Incorrect login and/or password.')]")
    public WebElement errorMessage;


    public void login() {
        emailBox.sendKeys("admin@codewise.com");
        passwordBox.sendKeys("codewise123");
        submitButton.click();
    }

    public void invalidEmail() {
        emailBox.sendKeys("admincodewise.com");
        passwordBox.sendKeys("codewise123");
        submitButton.click();

    }
}
