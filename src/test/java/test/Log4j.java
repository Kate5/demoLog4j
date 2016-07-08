package test;

/**
 * Created by kate on 7/7/16.
*/

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Log4j {

    private static WebDriver driver;

    private static Logger Log = Logger.getLogger(Log4j.class.getName());

    public static void main(String[] args) {

        DOMConfigurator.configure("log4j.xml");

        // Create a new instance of the Firefox driver

        driver = new FirefoxDriver();

        Log.info("New driver instantiated");

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Log.info("Implicit wait applied on the driver for 10 seconds");

        //Launch the Magento Website

        driver.get("http://magento.brainacad.com/english/customer/account/login/");

        Log.info("Web application launched");

        // Enter Username on the element found by above desc.

        driver.findElement(By.id("email")).sendKeys("kateryna.maksimenko@gmail.com");

        driver.findElement(By.id("pass")).sendKeys("1234567");

        Log.info("Username and password entered");

        driver.findElement(By.id("send2")).click();

        String text = driver.findElement(By.className("hello")).getText();

        Log.info("Verify elements present on page: " + "hello value is " + "\"" + text + "\"");

        // Close the driver

        driver.quit();

        Log.info("Browser closed");

    }

}