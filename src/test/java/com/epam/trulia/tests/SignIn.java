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
    private SignInStep signInStep = new SignInStep(homePage);

    /**
     * Performs authorization on the tested resource
     * and checks whether the operation was successful.
     */
    @Test
    public void signInTest(){

        signInStep.signIn(User.getLogin(), User.getPassword());

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(homePage.getUserIcon()));
        Assert.assertEquals(homePage.getUserIconInnerText(), User.getName(), "signIn test passed");
    }

}
