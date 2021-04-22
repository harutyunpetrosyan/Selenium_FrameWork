package pageObject.InteractionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

public class DraggablePage extends BasePage {


    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="draggable")
    WebElement draggableWidget;
    @FindBy(xpath = "//a[text()='Draggable']")
    WebElement draggable;

    public void defaultFunctionality(){
        draggable.click();
        javaScriptHelper.scrollDownByPixel(260);
        frameHelper.switchToFrame(0);
        actions.dragAndDropBy(draggableWidget,320,320).build().perform();
        waitHelper.waitThread(5000);

    }
}
