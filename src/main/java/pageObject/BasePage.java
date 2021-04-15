package pageObject;

import helper.alert.AlertHelper;
import helper.frame.FrameHelper;
import helper.javaScript.JavaScriptHelper;
import helper.wait.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WaitHelper waitHelper;
    protected AlertHelper alertHelper;
    protected FrameHelper frameHelper;
    protected JavaScriptHelper javaScriptHelper;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        waitHelper=new WaitHelper(this.driver);
        alertHelper=new AlertHelper(this.driver);
        frameHelper=new FrameHelper(this.driver);
        javaScriptHelper=new JavaScriptHelper(this.driver);
        actions=new Actions(this.driver);

    }
}
