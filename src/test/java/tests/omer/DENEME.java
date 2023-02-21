package tests.omer;

import org.testng.annotations.Test;
import pages.omer.HubcomflyCheckoutPage;
import pages.omer.HubcomflyCompleteOrderPage;
import pages.omer.HubcomflyUrunPage;
import pages.omer.HubcomfyHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DENEME {
    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        HubcomfyHomePage hubcomfyHomePage = new HubcomfyHomePage();
        HubcomflyUrunPage hubcomflyUrunPage = new HubcomflyUrunPage();
        HubcomflyCheckoutPage hubcomflyCheckoutPage = new HubcomflyCheckoutPage();
        HubcomflyCompleteOrderPage hubcomflyCompleteOrderPage= new HubcomflyCompleteOrderPage();


        hubcomfyHomePage.signInButton.click();
        hubcomfyHomePage.username.sendKeys(ConfigReader.getProperty("username"));
        hubcomfyHomePage.password.sendKeys(ConfigReader.getProperty("yenisifre"));
        hubcomfyHomePage.loginEnter.click();
        ReusableMethods.waitFor(3);
    }
}
