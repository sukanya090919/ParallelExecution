package com.sauceLabBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.time.Duration;

public class BasePage {
   public WebDriver driver;
    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
@Parameters("browserName")
    @BeforeTest
    public void Openbrowser(String browserName)  {
        switch(browserName.toLowerCase()) {
            case "chrome":
                 driver = new ChromeDriver();
//                desiredCapabilities = new DesiredCapabilities();
//                chromeOptions = new ChromeOptions();
//                desiredCapabilities.setCapability("browser","chrome");
                break;
            case "edge":
                driver = new EdgeDriver();
//                desiredCapabilities = new DesiredCapabilities();
//                edgeOptions = new EdgeOptions();
//                desiredCapabilities.setCapability("browser","edge");
                break;
            default	:
                System.out.println("Browser name is invalid");
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @BeforeSuite
        public void initalizeReportAndWebDriver()
        {
            System.out.println("Report is Initalized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    @BeforeMethod
    public void launchUrl()
    {
        driver.get("https://www.saucedemo.com/");

    }
   @AfterTest
      public void killSession()
       {
            driver.quit();
        }
    }

