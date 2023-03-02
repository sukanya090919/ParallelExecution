package com.SauceLabTest;

import com.sauceLabBase.BasePage;
import com.sauceLabPages.CheckoutPage;
import com.sauceLabPages.CheckoutReviewPage;
import com.sauceLabPages.LoginPage;
import com.sauceLabPages.SauceLabHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceLabTestPage extends BasePage {

    public LoginPage loginwithproblemuser;
    public SauceLabHomePage saucelabhomepage;
    public CheckoutPage checkoutpage;
    public CheckoutReviewPage checkoutreviewpage;

    @BeforeClass
    public void initializePage() {
        loginwithproblemuser = new LoginPage(driver);
        saucelabhomepage = new SauceLabHomePage(driver);
        checkoutpage = new CheckoutPage(driver);
        checkoutreviewpage = new CheckoutReviewPage(driver);
    }

    @Test
    public void loginIntoApplicationUsingProblemUser() throws InterruptedException {
        loginwithproblemuser.loginAndVerifyTitle("problem_user", "secret_sauce");
    }

    @Test
    public void loginIntoApplicationUsingStandardUser() throws InterruptedException {
        loginwithproblemuser.loginAndVerifyTitle("standard_user", "secret_sauce");
        saucelabhomepage.selectLowestPriceProductAndAddToCart();
        checkoutpage.fillCheckoutDetails("Sukanya", "Sharma", "834001");
        checkoutreviewpage.verifyPriceInCartAndCheckoutReview();
        //Assert.assertEquals(priceincart,minprice);
    }

}
