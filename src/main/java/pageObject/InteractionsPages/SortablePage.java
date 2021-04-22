package pageObject.InteractionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import java.util.List;

public class SortablePage extends BasePage {

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Sortable']")
    WebElement sortable;
    @FindBy(css = "[id*='sortable'] li")
    List<WebElement> sortableElements;

    public void defaultFunctionalityTest(){
        sortable.click();
        frameHelper.switchToFrame(0);
        actions.dragAndDrop(sortableElements.get(0),sortableElements.get(1));
        waitHelper.waitThread(5000);

    }

}
