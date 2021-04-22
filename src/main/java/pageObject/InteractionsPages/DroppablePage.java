package pageObject.InteractionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

public class DroppablePage extends BasePage {
    @FindBy(xpath = "//a[text()='Droppable']")
    WebElement droppable;
    @FindBy(id="draggable")
    WebElement draggableElement;
    @FindBy(id="droppable")
    WebElement droppableElement;

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public String defaultFunctionality(){
        droppable.click();
        frameHelper.switchToFrame(0);
        actions.dragAndDrop(draggableElement,droppableElement).build().perform();
        String hex = Color.fromString(droppableElement.getCssValue("background-color")).asHex();
        System.out.println(hex);
        return hex;
    }

}
