package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//ul[@id=\"main-nav\"]//a[contains(text(), 'Shop')]")
    WebElement shopButton;
    @FindBy(css = "div[data-slide-duration=\"0\"] img")
    List<WebElement> slideImages;
    @FindBy(css = "ul[class=\"products\"]")
    List<WebElement> arrivals;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnShopButton() {
        shopButton.click();
    }

    public int getSlideLength() {
        return slideImages.size();
    }

    public int getArrivalsLength() {
        return arrivals.size();
    }

    public void clickOnArrival() {
        int sizeArrivals=arrivals.size();
        arrivals.get((int) (Math.random() * (sizeArrivals))).click();
    }


}
