package pages.omer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HubcomflyUrunPage {
    public HubcomflyUrunPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name=\"add-to-cart\"]")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@title='Plus']")
    public WebElement urunArtır;

    @FindBy(xpath = "//*[@title='Minus']")
    public WebElement urunAzalt;

    @FindBy(xpath = "//span[@class=\"cart-label\"]")
    public WebElement cartButton;

    @FindBy(xpath ="(//*[@class='woocommerce-Price-amount amount'])[1]")
    public WebElement ilkFiyat;

    @FindBy(xpath = "//*[.='Checkout']")
    public WebElement checkoutButton;


}
//*[@title='Minus']

//span[@class="cart-label"]
//*[.='Checkout']
