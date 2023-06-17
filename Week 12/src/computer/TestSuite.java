package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class TestSuite extends Utility {

    String url = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(url);
    }

    @Test
    public void name() throws InterruptedException {
        //1.1 Click on Computer Menu.
        //1.2 Click on Desktop

        By mouseHoverDesktops = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
        By mouseHoverDesktopsClick = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']");
        mouseHoverAndClick(mouseHoverDesktops,mouseHoverDesktopsClick);

        //1.3 Select Sort By position "Name: Z to A"
        //1.4 Verify the Product will arrange in Descending order.
        By selectFromDropDown = By.xpath("//select[@id='products-orderby']");
        String selectValue = "Name: Z to A";
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);
        Thread.sleep(5000);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        //2.2 Click on Desktop

        By mouseHoverDesktops = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
        By mouseHoverDesktopsClick = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']");
        mouseHoverAndClick(mouseHoverDesktops,mouseHoverDesktopsClick);

        //2.3 Select Sort By position "Name: A to Z"
        By selectFromDropDown = By.xpath("//select[@id='products-orderby']");
        String selectValue = "Name: A to Z";
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);

        //2.4 Click on "Add To Cart"
        By select_add_to_cart = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]");
        clickOnElement(select_add_to_cart);
        Thread.sleep(5000);

        //2.5 Verify the Text "Build your own computer"

        By Checkout_xpath = By.xpath("//h1[normalize-space()='Build your own computer']");
        String expectedMessage_checkout = "Build your own computer";
        verifyText(expectedMessage_checkout, Checkout_xpath);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        By selectFromDropDownDual = By.xpath("//select[@id='product_attribute_1']");
        String selectValueDual = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        selectByVisibleTextFromDropDown(selectFromDropDownDual, selectValueDual);


        //2.7.Select "8GB [+$60.00]" using Select class.
        By selectFromDropDownRam = By.xpath("//select[@id='product_attribute_2']");
        String selectRam = "8GB [+$60.00]";
        selectByVisibleTextFromDropDown(selectFromDropDownRam, selectRam);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//label[@for='product_attribute_3_7']")).click();

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        driver.findElement(By.xpath("//label[@for='product_attribute_5_10']"));
        driver.findElement(By.xpath("//label[@for='product_attribute_5_12']"));

        //2.11 Verify the price "$1,475.00"
        By Checkout_price_xpath = By.xpath("//h1[normalize-space()='Build your own computer']");
        String expectedMessage_price = "$1,475.00";
        verifyText(expectedMessage_price, Checkout_price_xpath);

        //2.12 Click on "ADD TO CARD" Button.
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        By check_message_xpath = By.xpath("//p[@class='content']");
        String expectedMessage_checkout1 = "The product has been added to your shopping cart";
        verifyText(expectedMessage_checkout1, check_message_xpath);

        //After that close the bar clicking on the cross button.
        driver.findElement(By.xpath("//span[@title='Close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        By mouseHoverShipping = By.xpath("//a[normalize-space()='shopping cart']");
        By mouseHoverShippingClick = By.xpath("//a[normalize-space()='shopping cart']");
        mouseHoverAndClick(mouseHoverShipping,mouseHoverShippingClick);

        //2.15 Verify the message "Shopping cart"
        By check_message_xpath1 = By.xpath("//h1[normalize-space()='Shopping cart']");
        String expectedMessage_checkout2 = "Shopping cart";
        verifyText(expectedMessage_checkout2, check_message_xpath1);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        By qty_xpath = By.xpath("//input[@id='itemquantity11219']");
        clearTextFromField(qty_xpath);
        sendKeysToElement(qty_xpath,"2");

        driver.findElement(By.xpath("//button[@id='updatecart']")).click();

        //2.17 Verify the Total"$2,950.00"
        By by = By.xpath("//span[@class='product-subtotal']");
        String message = "$2,950.00";
        verifyText(message,by);

        //2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        //2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        //2.20 Verify the Text “Welcome, Please Sign In!”
        By by1 = By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']");
        String message1 = "Welcome, Please Sign In!";
        verifyText(message1,by1);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        driver.findElement(By.xpath("//button[normalize-space()='Checkout as Guest']")).click();

        //2.22 Fill the all mandatory field
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("Hemi");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Patel");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("hpatel07@gmail.com");


        By select_county = By.xpath("//select[@id='BillingNewAddress_CountryId']");
        String select_county_value = "India"; ////select[@id='BillingNewAddress_CountryId']//option[101]
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);

        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Anand");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("centerl London");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("DES2 EW11");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("0832282282");

        //2.23 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        driver.findElement(By.xpath("//label[@for='shippingoption_1']")).click();

        //2.25 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();

        //2.27 Select “Master card” From Select credit card dropdown
        By selectMasterCard = By.xpath("//select[@id='CreditCardType']");
        String selectCardValue = "Master card";
        selectByVisibleTextFromDropDown(selectMasterCard, selectCardValue);

        //2.28 Fill all the details
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("John Smith");
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("1234567890123456");

        By selectDate = By.xpath("//select[@id='ExpireMonth']");
        String selectdateValue = "08";
        selectByVisibleTextFromDropDown(selectDate, selectdateValue);

        By selectyearXPath = By.xpath("//select[@id='ExpireYear']");
        String selectYearValue = "2027";
        selectByVisibleTextFromDropDown(selectyearXPath, selectYearValue);

        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("123");

        //2.29 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();

        //2.30 Verify “Payment Method” is “Credit Card”
        By PaymentMethod_xpath = By.xpath("//li[@class=\"payment-method\"]//span[@class=\"value\"]");
        String expectedMessage_payment = "Credit Card";
        verifyText(expectedMessage_payment, PaymentMethod_xpath);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        By shippingMethod_xpath = By.xpath("//li[@class=\"shipping-method\"]//span[@class=\"value\"]");
        String expectedMessage_shipping = "Credit Card";
        verifyText(expectedMessage_shipping, shippingMethod_xpath);

        //2.33 Verify Total is “$2,950.00”
        By total_xpath = By.xpath("//tr[@class=\"order-total\"]//td[2]//span//strong");
        String expectedMessage_total = "Credit Card";
        verifyText(expectedMessage_total, total_xpath);

        //2.34 Click on “CONFIRM”
        driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();

        //2.35 Verify the Text “Thank You”
        By thankyou_xpath = By.xpath("//h1[normalize-space()='Thank you']");
        String expectedMessage_thankyou = "Thank You";
        verifyText(expectedMessage_thankyou, thankyou_xpath);

        //2.36 Verify the message “Your order has been successfully processed!”
        By order_xpath = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
        String expectedMessage_order = "Your order has been successfully processed!";
        verifyText(expectedMessage_order, order_xpath);

        //2.37 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        By welcome_xpath = By.xpath("//h2[normalize-space()='Welcome to our store']");
        String expectedMessage_welcome = "Your order has been successfully processed!";
        verifyText(expectedMessage_welcome, welcome_xpath);
    }

    @After
    public void close(){
        closeBrowser();
    }
}