package com.epam.trulia.steps;

import com.epam.trulia.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class SignInStep {
    private HomePage homePage;

    public SignInStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    /**
     * Performs sign in. Enters login, password and press submit.
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

    public String getUserIconInnerText(){
       return homePage.getUserIcon().getAttribute("innerHTML");
    }
}
