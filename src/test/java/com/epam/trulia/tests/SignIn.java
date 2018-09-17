package com.epam.trulia.tests;

import com.epam.trulia.user.User;
import com.epam.trulia.steps.SignInStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends BaseTest{
    private User user;
    private SignInStep signInStep;

    /**
     * Performs authorization on the tested resource
     * and checks whether the operation was successful.
     */
    @Test
    public void signInTest(){
        user = new User();
        signInStep = new SignInStep(driver);
        signInStep.signIn(user.getLogin(), user.getPassword());

        Assert.assertEquals(signInStep.getUserIconInnerText(), user.getName(), "signIn test passed");
    }

}
