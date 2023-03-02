package com.SauceLabTest;

import com.sauceLabBase.BasePage;
import com.sauceLabPages.CheckoutPage;
import com.sauceLabPages.CheckoutReviewPage;
import com.sauceLabPages.LoginPage;
import com.sauceLabPages.SauceLabHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LamdaTest extends BasePage {
    WebDriver driver;
    public LoginPage loginwithproblemuser;
    public SauceLabHomePage saucelabhomepage;
    public CheckoutPage checkoutpage;
    public CheckoutReviewPage checkoutreviewpage;

    @BeforeTest
    public void setUpLamdaTest() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browserName", "chrome");
        desiredCapabilities.setCapability("platform", "win10");
        desiredCapabilities.setCapability("browserVersion", "108");
        desiredCapabilities.setCapability("build", "QA");
        desiredCapabilities.setCapability("project", "SauceLabs");
        desiredCapabilities.setCapability("test", "SauceLabTestNGFramework");

        try {
            driver = new RemoteWebDriver(new URL("https://sukanyakumari2085:QY39Dp2lRZ5lSJJMnvSKiCyL6JqyCLUPqS0qmZGxcJXSZoIdaB@hub.lambdatest.com/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.saucedemo.com/");
    }

    @BeforeClass
    public void intializingPages() {
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

    }
}



