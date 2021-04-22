package testScripts.InteractionsPagesTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.InteractionsPages.SelectablePage;
import testScripts.TestBase;

public class SelectableTest extends TestBase {
    SelectablePage selectablePage;
    @BeforeClass
    public void initPage(){
        getApplicationUrl(reader.getUrl());
        selectablePage=new SelectablePage(eventDriver);
    }
    @Test
    public void defaultFunctionalityTest(){
      selectablePage.defaultFunctionalityTest();
    }
}
