package com.epam.trulia.tests;

import com.epam.trulia.User;
import com.epam.trulia.steps.SignInStep;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{
    private User user = new User();
    private SignInStep signInStep = new SignInStep(driver);

    @Test
    public void login(){
       signInStep.signIn(user.getLogin(), user.getPassword());
    }
}
