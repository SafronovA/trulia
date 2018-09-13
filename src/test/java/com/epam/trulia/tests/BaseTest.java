package com.epam.trulia.tests;

import com.epam.trulia.DriverManager;
import com.epam.trulia.pages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.epam.trulia.DriverManager.getDriverInstance;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    private final String TESTED_RESOURCE = "https://www.trulia.com/";

    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        startBrowser();
        driver.get(TESTED_RESOURCE);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass(enabled = false)
    protected void backOnMainPage() {
        driver.navigate().to(TESTED_RESOURCE);
    }

    @AfterTest(enabled = false)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void startBrowser() {
        getDriverInstance();
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 700));
    }

//    private enum Driver{
//        Firefox, Chrome, IE
//    }
//    private static Driver driverType;

//    @BeforeClass(alwaysRun = true)
//    protected void setUp() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\chromedriver.exe");
////        driver = new ChromeDriver();
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setPlatform(Platform.WINDOWS);
//        driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1650, 700));
////        driver.manage().window().fullscreen();
//        driver.get(TESTED_RESOURCE);
//        mainPage = PageFactory.initElements(driver, MainPage.class);
//    }


//    public void setDriver(Driver driverType){BaseTestClass.driverType = driverType;}
//
//    public WebDriver getDriver() throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        if(driver == null){
//            switch (driverType){
//                case Chrome:
//                    caps.setBrowserName("chrome");
//                    break;
//                case Firefox:
//                    caps.setBrowserName("firefox");
//                    break;
//                case IE:
//                    caps.setBrowserName("chrome");
//                    break;
//                default:
//                    caps.setBrowserName("chrome");
//                    break;
//            }
//            caps.setPlatform(Platform.WINDOWS);
//            driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().window().setSize(new Dimension(1650, 700));
//        }
//        return driver;
//    }

//    @BeforeClass(alwaysRun = true)
//    protected void setUp() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksei_Safronau\\SeleniumDrivers\\chromedriver.exe");
////        driver = new ChromeDriver();
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setPlatform(Platform.WINDOWS);
//        driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(1650, 700));
////        driver.manage().window().fullscreen();
//        driver.get(TESTED_RESOURCE);
//        mainPage = PageFactory.initElements(driver, MainPage.class);
//    }
}
