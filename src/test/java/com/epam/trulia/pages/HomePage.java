package com.epam.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class='baz btn btnSml btnDefault signinButton menu-personalized__signinButton___1CxD']")
    private WebElement signInButton;
    @FindBy(xpath = "//button[@data-action='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@data-role='login_email_input']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@data-role='login_password_field']")
    private WebElement passwordInput;

    public HomePage clickSignInButton(){
        signInButton.click();
        return this;
    }
    public HomePage setLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }
    public HomePage setPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    public HomePage clickSubmitButton(){
        submitButton.click();
        return this;
    }
}
