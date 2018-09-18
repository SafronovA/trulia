package com.epam.trulia.steps;

import com.epam.trulia.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageStep {
    private HomePage homePage;

    public HomePageStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    /**
     * Performs sign in. Enters (@code String login), (@code String password) and press submit.
     *
     * @param  login user's login
     * @param  password user's password
     * @return    this HomePage with authorized user
     */
    public void signIn(String login, String password){
        homePage.clickSignInButton();
        homePage.setLogin(login);
        homePage.clickSubmitButton();
        homePage.setPassword(password);
        homePage.clickSubmitButton();
    }

    /**
     * @return innerHTML from user icon
     */
    public String getUserNameFromIcon(){
       return homePage.getUserIcon().getAttribute("innerHTML");
    }

}
