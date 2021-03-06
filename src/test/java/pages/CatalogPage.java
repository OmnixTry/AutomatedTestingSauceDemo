package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class CatalogPage {

    private WebDriver driver;

    //@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
    ////*[@id="add-to-cart-sauce-labs-backpack"]
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement catalogProduct;
    ////*[@id="inventory_container"]/div/div[1]/div[2]/div[2]/div
    //@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/div")
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement kartButton;

    @FindBy(linkText = "Sauce Labs Backpack")
    private WebElement backpack;

    @FindBy()
    private WebElement kart;
    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void AddFirstProduct(){
        catalogProduct.click();
    }

    public void NavigateToCart() {
        kartButton.click();
    }

    public void NavigateToProduct(){
        backpack.click();
    }
}
