package broswertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    public void openBrowser(String url){
        ChromeOptions options = new ChromeOptions();  // Setting webdriver
        driver = new ChromeDriver();
        driver.get(url); // lanuch URL
        driver.manage().window().maximize();  // maximize screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    }

    public void closeBrowser(){
        driver.close();
        // close() closes only the current window on which Selenium is running automated tests.
        // quit() method closes all browser windows and ends the WebDriver session.
    }
}