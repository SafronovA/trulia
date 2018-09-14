package com.epam.trulia.driverManager;

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

    public static WebDriver getDriver(DriverType driverType){
        if (driver == null){
            setDriver(driverType);
        } return driver;
    }

    private static void setDriver(DriverType driverType){
        switch (driverType){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
                DesiredCapabilities capabilitiesChrome = DesiredCapabilities.chrome();
                capabilitiesChrome.setPlatform(Platform.WINDOWS);
                try {
                    driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilitiesChrome);
                } catch (MalformedURLException e) {e.printStackTrace();}

            case Firefox:
                System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
                DesiredCapabilities capabilitiesFirefox = DesiredCapabilities.firefox();
                capabilitiesFirefox.setPlatform(Platform.WINDOWS);
                try {
                    driver = new RemoteWebDriver(new URL(REMOTE_URL), capabilitiesFirefox);
                } catch (MalformedURLException e) {e.printStackTrace();}
        }

    }

}
