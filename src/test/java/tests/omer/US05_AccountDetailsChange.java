package tests.omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.omer.HubcomfyHomePage;
import pages.omer.HobycomflyLoginPage;
import pages.omer.HubcomfyMyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US05_AccountDetailsChange {

    @Test
    public  void myAccountLoginTest() {

        //Kullanıcı sayfaya gider  ve  sign in olur...
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        HubcomfyHomePage hobcomfyHomePage = new HubcomfyHomePage();
        hobcomfyHomePage.signInButton.click();
        hobcomfyHomePage.username.sendKeys(ConfigReader.getProperty("username"));
        hobcomfyHomePage.password.sendKeys(ConfigReader.getProperty("customeromer_sifre"));
        hobcomfyHomePage.loginEnter.click();

        //Myaccounta tıkla...
        HobycomflyLoginPage hobycomflyLoginPage = new HobycomflyLoginPage();
        ReusableMethods.jsclick(hobycomflyLoginPage.myAccountButton);
        Driver.closeDriver();

    }

    @Test
    public void changeAccountDetails() throws InterruptedException {
        myAccountLoginTest();

        //MyAccount bölümüne geldik. loghout butonunu görerek bu sayfada olduğumuzu anladık.
        HubcomfyMyAccountPage hubcomfyMyAccountPage = new HubcomfyMyAccountPage();
        Assert.assertTrue(hubcomfyMyAccountPage.loghoutButton.isDisplayed());

        //Account Detail sekemsine tıklıyoruz...
        ReusableMethods.jsclick(hubcomfyMyAccountPage.accountDetails);

        // firstname değişir
        hubcomfyMyAccountPage.firstName.clear();
        hubcomfyMyAccountPage.firstName.sendKeys(ConfigReader.getProperty("yeniname"));

        //lastname değiştir
        hubcomfyMyAccountPage.lastName.clear();
        hubcomfyMyAccountPage.lastName.sendKeys(ConfigReader.getProperty("yenilastname"));

        //displayname değiştir
        hubcomfyMyAccountPage.displayName.clear();
        hubcomfyMyAccountPage.displayName.sendKeys(ConfigReader.getProperty("yenidisplayname"));

        //emaili değiştir
        hubcomfyMyAccountPage.emailName.clear();
        hubcomfyMyAccountPage.emailName.sendKeys(ConfigReader.getProperty("yeniemail"));
        ReusableMethods.waitFor(5);

        //biyografi bölümüne data gönder..
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().switchTo().frame(0);
        hubcomfyMyAccountPage.iframe1.clear();
        hubcomfyMyAccountPage.iframe1.sendKeys(ConfigReader.getProperty("biography"));
        Driver.getDriver().switchTo().parentFrame();

    //    //sifre değiştirme ve yapilan tüm değişiklikleri kaydetme...
    //    ReusableMethods.jsclick(hubcomfyMyAccountPage.currentPassword);
    //    hubcomfyMyAccountPage.currentPassword.sendKeys(ConfigReader.getProperty("customeromer_sifre"));
    //    hubcomfyMyAccountPage.changePassword.sendKeys(ConfigReader.getProperty("yenisifre"));
    //    hubcomfyMyAccountPage.confirmchangePassword.sendKeys(ConfigReader.getProperty("yenisifre"));
    //    ReusableMethods.jsclick(hubcomfyMyAccountPage.saveChange);
    //    Driver.closeDriver();

    }

    @Test
    public void verifyChanges() throws InterruptedException {
        HubcomfyMyAccountPage hubcomfyMyAccountPage = new HubcomfyMyAccountPage();
        HobycomflyLoginPage hobycomflyLoginPage = new HobycomflyLoginPage();
        HubcomfyHomePage hobcomfyHomePage = new HubcomfyHomePage();

        //Kullanıcı yaptıpğı değişiklikleri doğrulamaktadır....
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        hobcomfyHomePage.signInButton.click();
        hobcomfyHomePage.username.sendKeys(ConfigReader.getProperty("username"));
        hobcomfyHomePage.password.sendKeys(ConfigReader.getProperty("yenisifre"));
        hobcomfyHomePage.loginEnter.click();

        ReusableMethods.jsclick(hobycomflyLoginPage.myAccountButton);
        ReusableMethods.jsclick(hubcomfyMyAccountPage.accountDetails);
        Assert.assertEquals(ReusableMethods.getValueByJS("account_first_name"), "omer1");
        ReusableMethods.waitFor(2);
        Assert.assertEquals(ReusableMethods.getValueByJS("account_last_name"), "B1");
        ReusableMethods.waitFor(2);
        Assert.assertEquals(ReusableMethods.getValueByJS("account_display_name"), "Omerb1");
        ReusableMethods.waitFor(2);
        Assert.assertEquals(ReusableMethods.getValueByJS("account_email"), "buyukergene@hotmail.com");
        Driver.closeDriver();
    }



    @Test
    public void tryByOldPassword() throws IOException {

        //Kullanıcı eski şifresi ile artık giriş yapamadığını doğrulamaktadır..
        HubcomfyHomePage hobcomfyHomePage = new HubcomfyHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        hobcomfyHomePage.signInButton.click();
        hobcomfyHomePage.username.sendKeys(ConfigReader.getProperty("username"));
        hobcomfyHomePage.password.sendKeys(ConfigReader.getProperty("customeromer_sifre"));
        hobcomfyHomePage.loginEnter.click();
        Assert.assertEquals(hobcomfyHomePage.wrongUsernameOrPassword.getText(), "Wrong username or password.");
        ReusableMethods.getScreenshot(hobcomfyHomePage.wrongUsernameOrPassword.getText());
        Driver.closeDriver();
    }


}
