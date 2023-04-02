package paytm.assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import paytm.assignment.pageobject.HomePage;
import paytm.assignment.resources.Browser;

public class DescListTest extends Browser {

	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
	}
	
	@Test
	public void getAscData() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		HomePage hp = new HomePage(driver);
		
		try {
			hp.getBanner().click();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			hp.getSearchBar().sendKeys(prop.getProperty("search"));
			hp.getSearchButton().click();
			
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_30jeq3 _1_WHN1']")));
			Thread.sleep(2000);
			
			
			//DESC
			hp.hightolow().click();
			Thread.sleep(2000);
			List<WebElement> list = hp.getPrice(); 
			
			ArrayList<String> originalList = new ArrayList<String>();
			
			for(int i=0; i<list.size(); i++) {
				originalList.add(list.get(i).getText());
			}
			
			System.out.println("---Original List---");
			for (String o:originalList) {
				System.out.println(o);
			}

			
			ArrayList<String> copiedList = new ArrayList<String>();
			
			for(int j=0; j<originalList.size(); j++) {
				copiedList.add(originalList.get(j));
			}
			
			Collections.sort(copiedList, Collections.reverseOrder());
			
			System.out.println("---DESC Sorted List---");
			for(String s:copiedList) {
				System.out.println(s);
			}
			
			Assert.assertTrue(copiedList.equals(originalList));
	}
	
	@AfterTest
	public void shutdown()
	{
		driver.close();
	}
	
}
