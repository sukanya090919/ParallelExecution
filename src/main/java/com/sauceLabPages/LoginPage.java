package com.sauceLabPages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement titleOfPage;

    public void loginAndVerifyTitle(String uname, String pass) throws InterruptedException {
        username.sendKeys(uname);
        password.sendKeys(pass);
        loginButton.click();
        Thread.sleep(2000);
        System.out.println(" ID===Problem-User & Password==secret_sauce login successfully");
    }
        public void verifyTitleOfThePage(){
        Assert.isTrue(titleOfPage.isDisplayed(),"Title Of The Page Is Not Displayed");
        }



    }

