package tests.SuplySync;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MastersPage {
    public MastersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[contains(text(), 'Masters')]")
    public WebElement master;

    @FindBy(xpath = "(//img[@alt='MenuIcon'])[1]")
    public WebElement threeDot;

    @FindBy(xpath = "(//img[@alt='MenuIcon'])[3]")
    public WebElement blockThreeDot;

    @FindBy(xpath = "(//li[@tabindex='-1' and text()='Block'])[3]")
    public WebElement block;

    @FindBy(xpath = "//div[@class='sc-hLVXRe kYjWz']")
    public WebElement mastersField;

    @FindBy(xpath = "(//img[@alt='MenuIcon'])[8]")
    public WebElement unlockThreeDot;
    @FindBy (xpath = "(//li[contains(text(), 'Unlock')])[3]")
    public WebElement unlock;

    @FindBy(xpath = "//li[contains(text(), 'Edit')]")
    public WebElement edit;

    @FindBy(id = "mui-2")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    public WebElement saveButton;


    @FindBy(xpath = "//*[contains(text(), 'Master changed successfully')]")
    public WebElement masterChangedSuccessfully;

    @FindBy(xpath = "//input[@name='location']")
    public WebElement location;
}
