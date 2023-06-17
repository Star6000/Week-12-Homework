package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class TopMenuTest extends Utility {
    String url = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(url);
    }
    public void selectMenu(String menu){
        System.out.println("Current Menu : " + menu);

        if (menu.equalsIgnoreCase("Show AllDesktops")) {
            String actualDesktop = "Desktops"; //
            String exceptedDesktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']")).getText();
            Assert.assertEquals(actualDesktop, exceptedDesktop);
        }
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        chooseMenu("Apparel");
    }

    public void chooseMenu(String manu){
        if(manu.equalsIgnoreCase("Computers")){
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[1]//a[@href=\"/computers\"]"));
            System.out.println("I am in Computer Tab");
        } else if (manu.equalsIgnoreCase("Electronics")) {
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[2]//a[@href=\"/electronics\"]"));
            System.out.println("I am in Electronics Tab");
        } else if(manu.equalsIgnoreCase("Apparel")){
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[3]//a[@href=\"/apparel\"]"));
            System.out.println("I am in Apparel Tab");
        } else if (manu.equalsIgnoreCase("Digital downloads")) {
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[4]//a[@href=\"/digital-downloads\"]"));
            System.out.println("I am in Digital Downloads Tab");
        } else if (manu.equalsIgnoreCase("Books")) {
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[5]//a[@href=\"/books\"]"));
            System.out.println("I am in Books Tab");
        } else if(manu.equalsIgnoreCase("Jewelry")) {
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[6]//a[@href=\"/jewelry\"]"));
            System.out.println("I am in Jewelry Tab");
        } else if(manu.equalsIgnoreCase("Gift Cards")) {
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li[7]//a[@href=\"/gift-cards\"]"));
            System.out.println("I am in Gift Cards Tab");
        }
    }

    @After
    public void close(){
        closeBrowser();
    }
}