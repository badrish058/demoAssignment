package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetUp {
    public static WebDriver driver;
    public static Properties properties;
    public static WebDriver initiateDriver() throws IOException
    {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\Data.properties");
        properties.load(fis);
        String browser = properties.getProperty("browser");


        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;

    }
    public static void holdExcution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isDisplayed1(String xpath)
    {
        boolean flag = false;
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            if (element.isDisplayed()) {
                flag = true;
            }
        }

        catch(NoSuchElementException e)
        {
            flag=false;

        }
        return flag;
    }
}




