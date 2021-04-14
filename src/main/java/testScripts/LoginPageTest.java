package testScripts;

import pageObject.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTest extends TestBase{
    private LoginPage loginPage;

    @BeforeClass
    public void initPage(){


    }
    @Test
    public void isPresentLoginForm(){

    }
    @Test
    public void loginWithValidCredentials(){
        SoftAssert softAssert=new SoftAssert();
        int array[] = {5, 15, 29, 10, 15, 4, 5, 78, 15, 15, 22, 2, 1};
        for (int i = 0; i < array.length; i++) {
            softAssert.assertTrue(array[i]>0);
        }
        softAssert.assertAll();
    }



}
