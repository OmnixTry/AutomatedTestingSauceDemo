package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement firstProductPrice;



    @FindBy(linkText = "Sauce Labs Backpack")
    private WebElement backpack;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean CheckProductPrice(String original) {

        return firstProductPrice.getText().equals(original.substring(1));
    }

}
