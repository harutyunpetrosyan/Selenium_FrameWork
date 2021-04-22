package testScripts.InteractionsPagesTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.InteractionsPages.DraggablePage;
import testScripts.TestBase;

public class DraggableTest extends TestBase {
    private DraggablePage draggablePage;

    @BeforeClass
    public void initPage() {
        getApplicationUrl(reader.getUrl());
        draggablePage = new DraggablePage(eventDriver);
    }

    @Test
    public void defaultFunctionalityTest() {
        draggablePage.defaultFunctionality();

    }


}
