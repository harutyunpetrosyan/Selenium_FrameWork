
package helper.browserConfiguration;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ChromeBrowser {

	public static ChromeOptions getChromeOptions() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		option.addArguments("--start-maximized");

		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		option.setCapability(ChromeOptions.CAPABILITY, chrome);	
		//Linux
		if(System.getProperty("os.name").contains("Linux")){
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return option;
	}

	public static WebDriver getChromeDriver(ChromeOptions cap) {

		if (System.getProperty("os.name").contains("Mac")){
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Window")){
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Linux")){
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(cap);
		}
		return null;
	}

}
