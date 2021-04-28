package testScripts.InteractionsPagesTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.InteractionsPages.SortablePage;
import testScripts.TestBase;

public class SortablePageTest extends TestBase {
    SortablePage sortablePage;

    @BeforeClass
    public void initPage() {
        getApplicationUrl(reader.getUrl());
        sortablePage = new SortablePage(eventDriver);
    }

    @Test
    public void defaultFunctionalityTest() {
        sortablePage.defaultFunctionalityTest();
    }
}
