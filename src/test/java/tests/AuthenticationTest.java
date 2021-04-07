package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.ThreadLocalRandom;

public class AuthenticationTest {
    private static WebDriver driver;
    private WebDriverWait wait;
    private AuthenticationPage authenticationPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.out.println("start");
        driver = new ChromeDriver();
        // full size window
        driver.manage().window().maximize();
    }

    // negative test
    // unauthenticated user can't enter catalog
    @Test
    public void testRedirectToRegisterPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        authenticationPage = new AuthenticationPage(driver);
        Assert.assertEquals(authenticationPage.getErrorMessageUnauthenticated().getText(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");
    }

    @Test
    public void testAuthentcation() {
        driver.get("https://www.saucedemo.com/");
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginUser("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testAuthentcationLockedOutUser() {
        driver.get("https://www.saucedemo.com/");
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginUser("locked_out_user", "secret_sauce");
        Assert.assertEquals(authenticationPage.getErrorMessageUnauthenticated().getText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
