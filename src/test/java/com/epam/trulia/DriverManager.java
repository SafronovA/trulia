package com.epam.trulia;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static DriverManager driverInstance;
    private static WebDriver driver;
    private static final String REMOTE_URL = "http://localhost:4444/wd/hub";

    private DriverManager(){}

    public static DriverManager getDriverInstance(){
        if (driverInstance == null){
            driverInstance = new DriverManager();
        } return driverInstance;
    }

    public static WebDriver getDriver(){
        if (driver == null){
            setDriver();
        } return driver;
    }

    private static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
        DesiredCapabilities capabilitiesChrome = DesiredCapabilities.chrome();
        DesiredCapabilities capabilitiesFirefox = DesiredCapabilities.firefox();
        capabilitiesChrome.setPlatform(Platform.WINDOWS);
        capabilitiesFirefox.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilitiesFirefox);
        } catch (MalformedURLException e) {e.printStackTrace();}
    }

//    private enum Driver{
//        Firefox, Chrome, IE
//    }
//
//    private static Driver driverType;
}
