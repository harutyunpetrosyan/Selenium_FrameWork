package testScripts.WodgetsPagesTest;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.WodgetsPages.AutocompletePage;
import testScripts.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTest extends TestBase {
    AutocompletePage autocompletePage;
    @BeforeClass
    public void initPage(){
        getApplicationUrl(reader.getUrl());
        autocompletePage=new AutocompletePage(eventDriver);
    }
    @Test
    public void defaultFunctionalityTest(){
        boolean searchFunctionality=autocompletePage.defaultFunctionalityTest();
        assertThat(searchFunctionality).withFailMessage("search functionality not work").isTrue();
    }

}

