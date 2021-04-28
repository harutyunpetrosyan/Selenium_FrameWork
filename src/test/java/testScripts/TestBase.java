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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

/**
 * @author Harut
 */
@Listeners(ExtentListener.class)
public class TestBase {
    public EventFiringWebDriver eventDriver;
    public WebDriverEventListener handler;
    public PropertyReader reader;
    public WaitHelper waitHelper;
    private final Logger log = LoggerHelper.getLogger(TestBase.class);

    @BeforeTest
    public void beforeTest() throws Exception {
        reader = new PropertyReader();
        setUpDriver(reader.getBrowserType());
    }

    @AfterTest
    public void afterTest() throws Exception {
        if (eventDriver != null) {
            eventDriver.quit();
        }
    }

    public WebDriver getBrowserObject(String btype) throws Exception {

        try {
            switch (btype) {
                case "Chrome" -> {
                    // get object of ChromeBrowser class
                    ChromeOptions option = ChromeBrowser.getChromeOptions();
                    return ChromeBrowser.getChromeDriver(option);
                }
                case "Firefox" -> {
                    FirefoxOptions options = FirefoxBrowser.getFirefoxOptions();
                    return FirefoxBrowser.getFirefoxDriver(options);
                }
                case "Iexplorer" -> {
                    InternetExplorerOptions cap = IExploreBrowser.getIExplorerCapabilities();
                    return IExploreBrowser.getIExplorerDriver(cap);
                }
                default -> throw new Exception("Driver not Found: " + btype);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }

    public void setUpDriver(String btype) throws Exception {
        WebDriver driver = getBrowserObject(btype);
        eventDriver = new EventFiringWebDriver(driver);
        handler = new EventHandler();
        eventDriver.register(handler);
        log.info("Initialize Web driver: " + driver.hashCode());
        waitHelper = new WaitHelper(driver);
        waitHelper.setImplicitWait(reader.getImpliciteWait(), TimeUnit.SECONDS);
        waitHelper.pageLoadTime(reader.getPageLoadTime(), TimeUnit.SECONDS);
        log.info("Set ImplicitWait and pageLoadTime: " + driver.hashCode());
    }

    public void getApplicationUrl(String url) {
        eventDriver.get(url);
        log.info("navigating to ..." + url);
    }

    public Object[][] getExcelData(String excelName, String sheetName) {
        String excelLocation = ResourceHelper.getResourcePath("src/main/resources/configfile/") + excelName;
        log.info("excel location " + excelLocation);
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
        return data;
    }
}
