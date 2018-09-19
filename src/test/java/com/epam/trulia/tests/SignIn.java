package com.epam.trulia.tests;

import com.epam.trulia.steps.HomePageStep;
import com.epam.trulia.user.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends BaseTest{
    private HomePageStep homePageStep;
    private User user = new User();

    /**
     * Performs authorization on the tested resource
     * and checks whether the operation was successful.
     */
    @Test
    public void signInTest(){
        homePageStep = new HomePageStep(driver);
        homePageStep.signIn(user.getLogin(), user.getPassword());

        Assert.assertEquals(homePageStep.getUserNameFromUserIcon(), user.getName(), "signIn test passed");
    }

}
