package pageObject.InteractionsPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectablePage extends BasePage {


    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Selectable']")
    WebElement selectable;
    @FindBy(css = "ol[id=\"selectable\"] li")
    List<WebElement> selectableItems;

    public void defaultFunctionalityTest() {
        selectable.click();
        frameHelper.switchToFrame(0);
        actions.keyDown(Keys.CONTROL).perform();
        selectableItems.forEach(WebElement::click);
        waitHelper.waitThread(3000);
        selectableItems.stream().collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(WebElement::click);
        waitHelper.waitThread(3000);

    }
}
