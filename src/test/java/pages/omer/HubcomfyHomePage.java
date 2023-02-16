package pages.omer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HubcomfyHomePage {
    public HubcomfyHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginEnter;

    @FindBy(xpath = "//*[.='Wrong username or password.']")
    public WebElement wrongUsernameOrPassword;

    @FindBy(xpath = "(//input[@name='s'])[1]")
    public WebElement search;

}
