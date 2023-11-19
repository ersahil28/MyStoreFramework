package com.mystore.base;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;

    public static void launchApp() {
        String browserName = prop.getProperty("browser");
        if (browserName.contains("Chrome")){
            driver = new ChromeDriver();
        } else if (browserName.contains("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.contains("IE")){
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

    }







    public void readConfig() throws IOException {
        prop=new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"Configuration/Config.properties");
        prop.load(fs);
    }
}
