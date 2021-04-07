package pages;

import org.openqa.selenium.WebElement;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class AuthenticationPage {
    private WebDriver driver;

    @FindBy(id = "login-button")
    private WebElement submit;

    @FindBy(name = "user-name")
    private WebElement username;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"page_wrapper\"]/footer/div/text()[3]")
    private WebElement productLabel;
    //*[@id="login_button_container"]/div/form/div[3]/h3/button
    //@FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/h3")
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement errorMessageUnauthenticated;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement firstProductPrice;

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void loginUser(String userName, String passwd) {
        username.sendKeys(userName);
        password.sendKeys(passwd);
        submit.click();
    }
}
