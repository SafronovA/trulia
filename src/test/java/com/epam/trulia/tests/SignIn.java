package com.epam.trulia.tests;

import com.epam.trulia.user.User;
import com.epam.trulia.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends BaseTest{
    private SignInStep signInStep = new SignInStep(driver);

    /**
     * Performs authorization on the tested resource
     * and checks whether the operation was successful.
     */
    @Test
    public void signInTest(){
       signInStep.signIn(User.getLogin(), User.getPassword());
        Assert.assertTrue(homePage.userIsAutorized(), "signIn test passed");
    }

}
