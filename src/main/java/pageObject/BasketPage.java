package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    @FindBy(css = "[class=\"checkout-button button alt wc-forward\"]")
    private WebElement proceedToCheckout;
    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public boolean  isNavigateCheckOutPage(){
        proceedToCheckout.click();
        return driver.getCurrentUrl().equals("http://practice.automationtesting.in/checkout/") ;
    }

}
