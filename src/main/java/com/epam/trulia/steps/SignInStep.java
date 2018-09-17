package com.epam.trulia.steps;

import com.epam.trulia.pages.HomePage;
import com.epam.trulia.user.User;
import org.openqa.selenium.WebDriver;

public class SignInStep {
    private User user;
    private HomePage homePage;

    public SignInStep(WebDriver driver) {
        user = new User();
        homePage = new HomePage(driver);
    }

    /**
     * Performs sign in. Enters (@code this.user) login, (@code this.user) password and press submit.
     *
     * @return    this HomePage with authorized user
     */
    public void signIn(){
        homePage.clickSignInButton();
        homePage.setLogin(user.getLogin());
        homePage.clickSubmitButton();
        homePage.setPassword(user.getPassword());
        homePage.clickSubmitButton();
    }

    public String getUserIconInnerText(){
       return homePage.getUserIcon().getAttribute("innerHTML");
    }

    public String getUserName(){
       return user.getName();
    }

}
