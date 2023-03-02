package com.sauceLabPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy(css = "#first-name")
        WebElement enterFirstName;

        @FindBy(css = "#last-name")
        WebElement enterLastName;

        @FindBy(css = "#postal-code")
        WebElement enterPostalCode;

        @FindBy(css = "#continue")
        WebElement continueButton;

        public void fillCheckoutDetails(String firstName, String lastName, String postalCode) throws InterruptedException {
            enterFirstName.sendKeys(firstName);
            enterLastName.sendKeys(lastName);
            enterPostalCode.sendKeys(postalCode);
            continueButton.click();
            Thread.sleep(2000);

        }
    }

