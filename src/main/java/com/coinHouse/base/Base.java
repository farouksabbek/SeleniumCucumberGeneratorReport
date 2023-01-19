package com.coinHouse.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties prop = new Properties();

    public  Base() {
        PageFactory.initElements(driver,this);
        try {
            File file = new File("src/main/java/com/coinHouse/properties/config.properities");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lunchBrowser(){

        if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver =new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
        driver.get("https://app.comptoirdubitcoin.fr/v2/login/new");
    }

    public static void closeBrowser() {
        driver.quit();
    }

}
