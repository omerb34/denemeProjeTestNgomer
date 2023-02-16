package pages.omer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HubcomfyMyAccountPage {
    public HubcomfyMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//*[text()='Log out']")
    public WebElement loghoutButton;

    @FindBy(xpath = "//*[text()='Account details']")
    public WebElement accountDetails;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='account_last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='account_display_name']")
    public WebElement displayName;

    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emailName;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement iframe1;

    @FindBy(xpath = "//*[.='Biography']")
    public WebElement bosluk;

    @FindBy(xpath = "//input[@id='password_current']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@id='password_1']")
    public WebElement changePassword;

    @FindBy(xpath = "//input[@id='password_2']")
    public WebElement confirmchangePassword;

    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement saveChange;


}
//*[@id='user_description_ifr']

//*[text()='Biography']

//input[@id='password_1']

