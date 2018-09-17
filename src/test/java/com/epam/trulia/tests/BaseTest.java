package com.epam.trulia.tests;

import com.epam.trulia.driverManager.DriverManager;
import com.epam.trulia.driverManager.DriverType;
import com.epam.trulia.pages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.epam.trulia.driverManager.DriverManager.getDriverInstance;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    private final String TESTED_RESOURCE = "https://www.trulia.com/";
    private final long WAITING_TIME = 10;
    private final int WIDTH = 1650;
    private final int HEIGHT = 700;

    /**
     * Causes startBrowser method.
     * Enters the tested resource.
     * Initializes HomePage elements.
     */
    @BeforeClass(alwaysRun = true)
    protected void setUp() {
        startBrowser();
        driver.get(TESTED_RESOURCE);
        homePage = new HomePage(driver);
    }

    /**
     * Gets the required WebDriver type.
     * Sets required implicitlyWait.
     * Sets the required size of the browser window.
     */
    private void startBrowser() {
        getDriverInstance();
        driver = DriverManager.getDriver(DriverType.FIREFOX);
        driver.manage().timeouts().implicitlyWait(WAITING_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WAITING_TIME, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(WIDTH, HEIGHT));
    }

    /**
     * Returns to the HomePage.
     */
    @AfterClass(enabled = false)
    protected void backOnHomePage() {
        driver.navigate().to(TESTED_RESOURCE);
    }

    /**
     * Destroys the WebDriver
     */
    @AfterTest(enabled = false)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
