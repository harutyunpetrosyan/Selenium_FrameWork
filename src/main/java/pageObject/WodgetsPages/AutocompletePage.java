package pageObject.WodgetsPages;


import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import java.util.List;

public class AutocompletePage extends BasePage {
    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Autocomplete']")
    WebElement autocomplete;
    @FindBy(id = "tags")
    WebElement tags;
    @FindBy(css = "li[class='ui-menu-item'] div")
    List<WebElement> menuItems;

    public boolean defaultFunctionalityTest() {
        String searchExample = "c";
        autocomplete.click();
        frameHelper.switchToFrame(0);
        waitHelper.waitThread(1000);
        tags.sendKeys(searchExample);
        boolean contains = false;
        for (WebElement items : menuItems) {
            System.out.println(items.getText());
            if (StringUtils.containsIgnoreCase(items.getText(), searchExample))
                contains = true;
            else {
                contains = false;
                break;
            }
        }
        return contains;
    }

}
