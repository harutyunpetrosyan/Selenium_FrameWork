package helper.DataProviders;

import org.testng.annotations.DataProvider;

public class DProvider {
    @DataProvider(name = "data_provider")
    public Object[][] dpMethod(){
        return new Object[][] {{}, {}};
    }



}
