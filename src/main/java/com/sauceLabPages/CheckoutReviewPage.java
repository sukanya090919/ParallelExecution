package com.sauceLabPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutReviewPage {
    public WebDriver driver;

    public CheckoutReviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="inventory_item_price")
    WebElement priceAfterCheckoutReview;

    @FindBy(css = "#finish")
    WebElement finishButton;


    @FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
    WebElement thankMessage;

    public void verifyPriceInCartAndCheckoutReview() throws InterruptedException {
        finishButton.click();
        Thread.sleep(3000);
    }
}