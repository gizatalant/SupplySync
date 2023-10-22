package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CompaniesPage {


    public CompaniesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public String url = "https://supplysync.us/dashboard/companies";


    @FindBy(xpath = "//span[@class='sc-egiyK GEXAw MuiTypography-root MuiTypography-body1 MuiListItemText-primary'] [contains(text(), 'Companies')]")
    public WebElement companiesSectionButton;

    @FindBy(xpath = "(//button[@class='sc-ikJyIC idrUqC MuiButtonBase-root sc-jJoQJp bFnKEe MuiIconButton-root MuiIconButton-sizeMedium'])[2]")
    public WebElement threeDotEditButton;

    @FindBy(xpath = "(//ul[@class='sc-eJwWfJ elkmAY MuiList-root MuiList-padding sc-gGCDDS eaLCwM MuiMenu-list'])[2]")
    public WebElement editButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement address;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(css = "button[type=submit]")
    public WebElement saveButton;


    public void editCompanyFieldMethod() {

        editButton.click();
        name.sendKeys("Codewise");
        email.sendKeys("Chicago city");
        address.sendKeys("codewise@gmail.com");
        phoneNumber.sendKeys("555555555");
        saveButton.click();
    }
}