package pageObject.InteractionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

public class ResizablePage extends BasePage {
    public ResizablePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Resizable']")
    WebElement resizable;
    @FindBy(css="div[class*='ui-resizable-handle ui-resizable-se']")
    WebElement resizableWidget;

    public void defaultFunctionalityTest(){
        resizable.click();
        frameHelper.switchToFrame(0);
        actions.clickAndHold(resizableWidget).moveByOffset(400,30).release().perform();
        waitHelper.waitThread(5000);
    }


}
