package com.epam.trulia.steps;

import com.epam.trulia.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInStep {
    private HomePage homePage;
    public SignInStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public void signIn(String login, String password){
        homePage.clickSignInButton();
        homePage.setLogin(login);
        homePage.clickSubmitButton();
        homePage.setPassword(password);
        homePage.clickSubmitButton();
    }
}
