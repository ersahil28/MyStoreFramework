package com.mystore.base;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    //public static WebDriver driver;

    //Declare ThreadLocal Driver
    public static ThreadLocal<RemoteWebDriver> driver =  new ThreadLocal<>();

    @BeforeSuite(groups = {"Smoke","Sanity","Regression"})
    public void loadConfig() throws IOException {
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        //get driver from ThreadLocalMap
        return driver.get();
    }


    public static void launchApp(String browserName) {
       // String browserName = prop.getProperty("browser");
        if (browserName.contains("Chrome")){
            //driver = new ChromeDriver();
            driver.set(new ChromeDriver());
        } else if (browserName.contains("Firefox")) {
            //driver = new FirefoxDriver();
            driver.set(new FirefoxDriver());
        } else if (browserName.contains("IE")){
            //driver = new InternetExplorerDriver();
            driver.set(new InternetExplorerDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("url"));

    }







    public void readConfig() throws IOException {
        prop=new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"Configuration/Config.properties");
        prop.load(fs);
    }

    @AfterSuite
    public void afterSuite() {
        ExtentManager.endReport();
    }
}
