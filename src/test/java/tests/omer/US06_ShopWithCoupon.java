package tests.omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.omer.HubcomflyCheckoutPage;
import pages.omer.HubcomflyCompleteOrderPage;
import pages.omer.HubcomflyUrunPage;
import pages.omer.HubcomfyHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US06_ShopWithCoupon {

    @Test
    public void signInAndSearch() throws IOException {

        //Kullanıcı sayfaya gider,sign in olur ve "blue tie" adlı ürünü aratır...
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
        hubcomfyHomePage.search.sendKeys("blue tie", Keys.ENTER);

        //Kullanacı aradığı ürünün sitede  olduğunu doğrulamaktadır.
        Assert.assertTrue(hubcomflyUrunPage.addToCart.isEnabled());

        //Kullanıcı ürün sayısını artırabilir,azaltabilir..
        ReusableMethods.waitFor(3);
        hubcomflyUrunPage.urunArtır.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot(hubcomflyUrunPage.urunArtır.getText());
        ReusableMethods.waitFor(2);
        hubcomflyUrunPage.urunAzalt.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot(hubcomflyUrunPage.urunArtır.getText());

        //kullanıcı ürünü sepete ekler.
        hubcomflyUrunPage.addToCart.click();

        //Kuulanıcı sepete(charta) tıklar.
        hubcomflyUrunPage.cartButton.click();

        //Kullanıcı ürün fiyatını ilk oalarak $15 dolar görmelidir.
        Assert.assertEquals(hubcomflyUrunPage.ilkFiyat.getText(), "$15.00");

        //Kullanıcı Checkout'a tıklar siapaişi tamamlamaya gider.
        hubcomflyUrunPage.checkoutButton.click();

        //Kullanıcı  ENTER YOUR CODE tusuna basar..
        hubcomflyCheckoutPage.couponButton.click();

        //Kullanıcı coupon kodunu girer ve Apply Coupon tusuna tıklar.
        hubcomflyCheckoutPage.couponCode.sendKeys(ConfigReader.getProperty("coupon"));
        hubcomflyCheckoutPage.applyCoupon.click();

        //Kullanıcı kuponu basarılı bicimde kullanır ve  yeni ürün fiyatını indirimli olarak $12.00 görür.
        Assert.assertEquals(hubcomflyCheckoutPage.sonFiyat.getText(), "$12.00");

        //Kullanıcı pay at door seçeneğini seçer ve place order tusuna basarak siparısı tamamlar.
        ReusableMethods.jsclick(hubcomflyCheckoutPage.payAtDoor);
        ReusableMethods.jsclick(hubcomflyCheckoutPage.placeOrder);
        ReusableMethods.waitFor(5);

        //Kullanıcı "Thank you. Your order has been received" mesjını görerek siparişinin tamamlandığını doğrular.
        Assert.assertTrue(hubcomflyCompleteOrderPage.completeMessage.getText().contains("Thank you. Your order has been received."));

        //Kullanıcı Sayfayı Kapatır.
        Driver.closeDriver();

    }

}
