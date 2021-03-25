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

import java.lang.constant.Constable;
import java.util.concurrent.ThreadLocalRandom;

public class CatalogTest {
    private static WebDriver driver;
    private WebDriverWait wait;
    private CatalogPage catalogPage;
    private AuthenticationPage authenticationPage;
    private CartPage cartPage;
    private ProductPage productPage;

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
    public void testProductAdd() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginUser("standard_user", "secret_sauce");
        catalogPage = new CatalogPage(driver);
        String originalPrice = catalogPage.getProductPrice().getText();
        catalogPage.AddFirstProduct();
        catalogPage.NavigateToCart();
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.CheckProductPrice(originalPrice));
    }

    @Test
    public void testProductLink(){
        driver.get("https://www.saucedemo.com/");
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginUser("problem_user", "secret_sauce");
        catalogPage = new CatalogPage(driver);
        String productName = catalogPage.getBackpack().getText();
        catalogPage.NavigateToProduct();
        productPage = new ProductPage(driver);
        Assert.assertEquals(productName, productPage.getProductName().getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
