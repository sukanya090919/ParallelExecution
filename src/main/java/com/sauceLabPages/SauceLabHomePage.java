package com.sauceLabPages;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SauceLabHomePage {
    public WebDriver driver;

    public SauceLabHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="shopping_cart_container")
    WebElement cartButton;

    @FindBy(css = ".inventory_item_price")
    WebElement priceInCart;

    @FindBy(id="checkout")
    WebElement checkoutButton;



    public void selectLowestPriceProductAndAddToCart() throws InterruptedException {
        List<WebElement> listOfAllPrice = new ArrayList<WebElement>();
        listOfAllPrice = driver.findElements(By.cssSelector("div.inventory_item_price"));
        List<Double> allAmount = new ArrayList<>();

        for (WebElement webElement : listOfAllPrice) {
            allAmount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }
        Double minPrice = Collections.min(allAmount);

        System.out.println("All Amount After Removing $  =::" + allAmount);
        System.out.println("Lowest Amount=::" + minPrice);

        WebElement itemMinPrice = driver.findElement(By.xpath("//div[@class='pricebar']//div[text()='" + minPrice + "']//following-sibling::button[text()='Add to cart']"));
        Thread.sleep(2000);
        itemMinPrice.click();

        System.out.println("Lowest Price Item Clicked");

            cartButton.click();
            String priceinviewcart = priceInCart.getText();
            System.out.println("Price of Product in Cart::::"+priceinviewcart);
            checkoutButton.click();

            //Assert.assertEquals(priceInCart.equals(itemMinPrice),"");
         }
}



