package com.epam.trulia.tests;

import com.epam.trulia.User;
import com.epam.trulia.steps.SignInStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends BaseTest{
    private User user = new User();
    private SignInStep signInStep = new SignInStep(driver);

    @Test
    public void signInTest(){
       signInStep.signIn(user.getLogin(), user.getPassword());
        Assert.assertTrue(userIsAutorized(), "signIn test passed");
    }

    private boolean userIsAutorized(){
        WebElement userIcon = driver.findElement(By.xpath("//span[@class=\'typeTruncate nakedEmail menu-personalized__userEmail___RajK\']"));
        String userName = userIcon.getAttribute("innerHTML");
        return userName == user.getName();
    }
}
