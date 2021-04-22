package testScripts.InteractionsPagesTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.InteractionsPages.ResizablePage;
import testScripts.TestBase;

public class ResizableTest extends TestBase {
    ResizablePage resizablePage;
    @BeforeClass
    public void initPage(){
        getApplicationUrl(reader.getUrl());
        resizablePage=new ResizablePage(eventDriver);
    }
    @Test
    public void defaultFunctionalityTest(){
        resizablePage.defaultFunctionalityTest();
    }
}
