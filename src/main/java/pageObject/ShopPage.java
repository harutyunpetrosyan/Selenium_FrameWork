package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "nav a[href=\"http://practice.automationtesting.in\"]")
    private WebElement homeButton;

    public void clickOnHomeButton(){
        homeButton.click();
    }



}
