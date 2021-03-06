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
        homePage.clickSignInButton()
                .setLogin(login)
                .clickSubmitButton()
                .setPassword(password)
                .clickSubmitButton();
    }

    /**
     * @return return the result of (@code homePage.getUserNameFromUserIcon()) method
     */
    public String getUserNameFromUserIcon(){
        String userName = homePage.getUserNameFromUserIcon();
        return userName;
    }

}
