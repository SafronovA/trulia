package com.epam.trulia.tests;

import com.epam.trulia.user.User;
import com.epam.trulia.steps.SignInStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends BaseTest{
    private User user = new User();
    private SignInStep signInStep = new SignInStep(driver);

    @Test
    public void signInTest(){
       signInStep.signIn(user.getLogin(), user.getPassword());
        Assert.assertTrue(homePage.userIsAutorized(), "signIn test passed");
    }

}
