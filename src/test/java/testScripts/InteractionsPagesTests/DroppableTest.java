package testScripts.InteractionsPagesTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.InteractionsPages.DroppablePage;
import testScripts.TestBase;

import static org.assertj.core.api.Assertions.*;


public class DroppableTest extends TestBase {
    DroppablePage droppablePage;
    @BeforeClass
    public void initPage(){
        getApplicationUrl(reader.getUrl());
        droppablePage=new DroppablePage(eventDriver);
    }
    @Test
    public void defaultFunctionalityTest(){
        String color=droppablePage.defaultFunctionality();
        assertThat(color).withFailMessage("color has not changed correct").isEqualTo("#fffa90");
    }
}
