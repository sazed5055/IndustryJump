package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url) {
		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\smonsur\\Documents\\workplace2\\industryjump_signup\\lib\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
		
		
		if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("IE")) 
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		//driver.get("https://dev.industryjump.com/signup");
		
		return driver;
	}
	


}
