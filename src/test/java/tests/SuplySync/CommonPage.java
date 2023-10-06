package tests.SuplySync;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage {
    //testing


    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
