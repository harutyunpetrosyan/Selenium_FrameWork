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
    @FindBy(css = "iframe[class='demo-frame']")
    WebElement ourFrame;

    public void defaultFunctionalityTest() {
        sortable.click();
 //       javaScriptHelper.scrollDownByPixel(150);
        javaScriptHelper.scrollIntoView(ourFrame);
        frameHelper.switchToFrame(0);

//        System.out.println(sortableElements.size()+"THIS IS SIZE");
//        actions.moveToElement(sortableElements.get(6)).perform();
        waitHelper.waitThread(2000);
        //javaScriptHelper.scrollIntoView(sortableElements.get(0));
        int j = 0;;
        for (int i=sortableElements.size()-1;i>sortableElements.size()/2;i--) {
            actions.dragAndDrop(sortableElements.get(i), sortableElements.get(j)).perform();
            waitHelper.waitThread(5000);
            j++;
        }
        waitHelper.waitThread(10000);


    }

}
