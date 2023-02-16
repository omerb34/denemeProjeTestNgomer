package pages.omer;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrnekPage {
    public OrnekPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


}
