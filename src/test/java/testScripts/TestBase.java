package testScripts;

import helper.browserConfiguration.ChromeBrowser;
import helper.browserConfiguration.FirefoxBrowser;
import helper.browserConfiguration.IExploreBrowser;
import helper.browserConfiguration.config.PropertyReader;
import helper.excel.ExcelHelper;
import helper.listener.EventHandler;
import helper.listener.ExtentListener;
import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;
import helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.ExtentManager;

import java.util.concurrent.TimeUnit;

/**
 * @author Harut
 */
@Listeners({ExtentListener.class})

public class TestBase {
    public static ThreadLocal<WebDriver> webDriverThreadLocal=new ThreadLocal<>();
    private WebDriver driver;
    public EventFiringWebDriver eventDriver;
    public AbstractWebDriverEventListener handler;
    public WaitHelper waitHelper;
    private final Logger log = LoggerHelper.getLogger(TestBase.class);

    //@Parameters({"browserName","OS"})
    @BeforeTest
    public void beforeTest() throws Exception {
        setUpDriver("Chrome");
    }
    @AfterTest
    public void afterTest() throws Exception {
        if (eventDriver != null) {
            eventDriver.quit();
        }
    }

    public  void setUpDriver(String btype) throws Exception {
//        DesiredCapabilities browser = new DesiredCapabilities();
//        if (btype.equals("firefox")) {
//            browser = DesiredCapabilities.firefox();
//        }
//        else if (btype.equals("chrome")) {
//            browser = DesiredCapabilities.chrome();
//        }
//        if (OS.equals("linux")) {
//            browser.setPlatform(Platform.LINUX);
//        }
//        else if (OS.equals("windows")) {
//            browser.setPlatform(Platform.WINDOWS);
//        }
//        browser.setCapability("enableVNC", false);
//        String selenoidHub = "http://localhost:4444/wd/hub/";
//        String seleniumGridHub = "http://10.22.220.177:5555/wd/hub";
//        eventDriver = new RemoteWebDriver(new URL(selenoidHub), browser);
//        eventDriver.manage().window().maximize();
        driver = getBrowserObject(btype);
        eventDriver = new EventFiringWebDriver(driver);
        handler = new EventHandler();
        eventDriver.register(handler);
        log.info("Initialize Web driver: " + driver.hashCode());
        waitHelper = new WaitHelper(driver);
        waitHelper.setImplicitWait(PropertyReader.getImpliciteWait(), TimeUnit.SECONDS);
        waitHelper.pageLoadTime(PropertyReader.getPageLoadTime(), TimeUnit.SECONDS);
        ExtentManager.getInstance();
        log.info("Set ImplicitWait and pageLoadTime: " + driver.hashCode());

    }

    public WebDriver getBrowserObject(String btype) throws Exception {
        try {
            switch (btype) {
                case "Chrome" -> {
                    // get object of ChromeBrowser class
                    ChromeOptions option = ChromeBrowser.getChromeOptions();
                    webDriverThreadLocal.set(ChromeBrowser.getChromeDriver(option));
                    return webDriverThreadLocal.get();
                }
                case "Firefox" -> {
                    FirefoxOptions options = FirefoxBrowser.getFirefoxOptions();
                    webDriverThreadLocal.set(FirefoxBrowser.getFirefoxDriver(options));
                    return webDriverThreadLocal.get();
                }
                case "Iexplorer" -> {
                    InternetExplorerOptions cap = IExploreBrowser.getIExplorerCapabilities();
                    webDriverThreadLocal.set(IExploreBrowser.getIExplorerDriver(cap));
                    return webDriverThreadLocal.get();
                }
                default -> throw new Exception("Driver not Found: " + btype);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }

    public void getApplicationUrl(String url) {
        eventDriver.get(url);
        log.info("navigating to ..." + url);
    }
    public void deleteCookiesAndCaches(){
        eventDriver.manage().deleteAllCookies();
        eventDriver.get("chrome://settings/clearBrowserData");
        eventDriver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }

    public Object[][] getExcelData(String excelName, String sheetName) {
        String excelLocation = ResourceHelper.getResourcePath("src/main/resources/configfile/") + excelName;
        log.info("excel location " + excelLocation);
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
        return data;
    }
}
