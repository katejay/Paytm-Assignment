package paytm.assignment.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\paytm\\assignment\\resources\\data.properties");
		prop.load(fis);
		//String BrowserName = System.getProperty("browser");
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			if(BrowserName.contains("headless"))
			{
				option.addArguments("--headless");
			}
			driver = new ChromeDriver(option);
		}
		
		else if(BrowserName.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\paytm\\assignment\\resources\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		return driver;
	}
	
	
}