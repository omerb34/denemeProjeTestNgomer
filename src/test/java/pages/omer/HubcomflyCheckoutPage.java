package pages.omer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HubcomflyCheckoutPage {
    public HubcomflyCheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Enter your code']")
    public WebElement couponButton;

    @FindBy(id = "coupon_code")
    public WebElement couponCode;

    @FindBy(xpath = "//*[.='Apply coupon']")
    public WebElement applyCoupon;

    @FindBy(xpath = "(//*[@class=\"woocommerce-Price-amount amount\"])[6]")
    public WebElement sonFiyat;

    @FindBy(xpath = "//label[@for='payment_method_cod']")
    public WebElement payAtDoor;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrder;


}
