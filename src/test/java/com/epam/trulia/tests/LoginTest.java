package com.epam.trulia.tests;

import com.epam.trulia.User;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private User user = new User();

    @Test
    public void login(){
        homePage.signIn(user.getLogin(), user.getPassword());
    }
}
