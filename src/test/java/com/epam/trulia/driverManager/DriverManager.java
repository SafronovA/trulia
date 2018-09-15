package com.epam.trulia.driverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static DriverManager driverInstance;
    private static WebDriver driver;

    private DriverManager(){}

    public static DriverManager getDriverInstance(){
        if (driverInstance == null){
            driverInstance = new DriverManager();
        } return driverInstance;
    }

    public static WebDriver getDriver(DriverType driverType){
        if (driver == null){
            setDriver(driverType);
        } return driver;
    }

    private static void setDriver(DriverType driverType){
        switch (driverType){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\chromedriver.exe");
                driver = new ChromeDriver();

            case Firefox:
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
        }

    }

}
