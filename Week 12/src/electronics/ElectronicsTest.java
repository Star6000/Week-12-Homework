package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class ElectronicsTest extends Utility {

    String url = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(url);
    }

    @Test
    public void verified() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        By mouseHoverDesktops = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
        By mouseHoverDesktopsClick = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");
        mouseHoverAndClick(mouseHoverDesktops,mouseHoverDesktopsClick);

        //1.3 Verify the text “Cell phones”
        By Cellphone_xpath = By.xpath("//h1[normalize-space()='Cell phones']");
        String expectedMessage_Cellphone = "Cell phones";
        verifyText(expectedMessage_Cellphone, Cellphone_xpath);

    }

    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 to 2.3
        verified();

        //2.4 Click on List View Tab
        driver.findElement(By.xpath("//a[@title='List']")).click();

        //2.5 Click on product name “Nokia Lumia 1020” link
        driver.findElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']")).click();

        //2.6 Verify the text “Nokia Lumia 1020”
        By nokia_xpath = By.xpath("//h1[normalize-space()='Nokia Lumia 1020']");
        String expectedMessage_nokia = "Nokia Lumia 1020";
        verifyText(expectedMessage_nokia, nokia_xpath);

        //2.7 Verify the price “$349.00”
        By price_xpath = By.xpath("//span[@id='price-value-20']");
        String expectedMessage_price = "$349.00";
        verifyText(expectedMessage_nokia, nokia_xpath);

        //2.8 Change quantity to 2
        By qty_xpath = By.xpath("//input[@id='product_enteredQuantity_20']");
        clearTextFromField(qty_xpath);
        sendKeysToElement(qty_xpath,"2");

        //2.9 Click on “ADD TO CART” tab
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        By product_xpath = By.xpath("//p[@class='content']");
        String expectedMessage_product = "The product has been added to your shopping cart";
        verifyText(expectedMessage_product, product_xpath);

        // close icon click
        driver.findElement(By.xpath("//span[@title='Close']")).click();

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        By mouseHoverDesktops = By.xpath("//a[normalize-space()='shopping cart']");
        By mouseHoverDesktopsClick = By.xpath("//a[normalize-space()='shopping cart']");
        mouseHoverAndClick(mouseHoverDesktops,mouseHoverDesktopsClick);

        //2.12 Verify the message "Shopping cart"
        By cart_xpath = By.xpath("//h1[normalize-space()='Shopping cart']");
        String expectedMessage_cart = "Shopping cart";
        verifyText(expectedMessage_product, product_xpath);

        //2.13 Verify the quantity is 2
        By update_qty_xpath = By.xpath("//input[@id='itemquantity11219']");
        clearTextFromField(update_qty_xpath);
        sendKeysToElement(update_qty_xpath,"2");

        //Update Shopping cart
        driver.findElement(By.xpath("//button[@id='updatecart']")).click();

        //2.14 Verify the Total $698.00
        By total_xpath = By.xpath("//span[@class='product-subtotal']");
        String total_message = "$698.00";
        verifyText(total_message,total_xpath);

        //2.15 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        //2.16 Click on checkout
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        //2.17 Verify the Text “Welcome, Please Sign In!”
        By welcome_xpath = By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");
        String welcome_message = "Welcome, Please Sign In!";
        verifyText(welcome_message,welcome_xpath);

        //2.18 Click on “REGISTER” tab
        driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();

        //2.19 Verify the text “Register”
        By registe_xpath = By.xpath("//h1[normalize-space()='Register']");
        String register_message = "Register";
        verifyText(register_message,registe_xpath);

        //2.20 Fill the mandatory fields
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("John");
        driver.findElement(By.cssSelector("##LastName")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#Email")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("test123");
        driver.findElement(By.cssSelector("##ConfirmPassword")).sendKeys("test123");

        //2.21 Click on “REGISTER” Button
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        //2.22 Verify the message “Your registration completed”
        By register_xpath = By.cssSelector(".result");
        String register1_message = "Your registration completed";
        verifyText(register1_message,register_xpath);

        //2.23 Click on “CONTINUE” tab
        driver.findElement(By.cssSelector(".button-1.register-continue-button")).click();
    }
    @After
    public void close(){
        closeBrowser();
    }
}