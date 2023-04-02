package paytm.assignment;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ListTest {
	
	
	public static void main(String args[]) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.get("https://www.flipkart.com/"); 
		
		try {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		driver.findElement(By.xpath("//form[contains(@class,'header-form-search')]/div/div/input")).sendKeys("iphone");
		driver.findElement(By.xpath("//form[contains(@class,'header-form-search')]/div/button")).click();
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_30jeq3 _1_WHN1']")));
		Thread.sleep(2000);
		
		
		//ASC
		driver.findElement(By.xpath("//div[contains(text(),'Price -- Low to High')]")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']")); 
		
		ArrayList<String> originalList = new ArrayList<String>();			//Create new ArrayList for original list
		
		for(int i=0; i<list.size(); i++) {
			originalList.add(list.get(i).getText());						//Get all phone price and add it in original list
		}
		
		System.out.println("---Original List---");
		for (String o:originalList) {
			System.out.println(o);											//Print original list
		}

		
		ArrayList<String> copiedList = new ArrayList<String>();				//Create another ArrayList for copied list (clone of original list)
		
		for(int j=0; j<originalList.size(); j++) {
			copiedList.add(originalList.get(j));							//Add original list items in copied list
		}
		
		Collections.sort(copiedList);										//Perform sort method on copied list by Collection framework
		
		System.out.println("---ASE Sorted List---");
		for(String s:copiedList) {
			System.out.println(s);											//Print sorted list
		}
		
		Assert.assertTrue(copiedList.equals(originalList));					//Validate sorted list is equal to original list
		
		
		
		//Desc
		driver.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]")).click();
		Thread.sleep(3000);
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']")); 
		
		ArrayList<String> originalList2 = new ArrayList<String>();			//Create new ArrayList for original list
		
		for(int i=0; i<list2.size(); i++) {
			originalList2.add(list2.get(i).getText());						//Get all phone price and add it in original list
		}
		
		System.out.println("---Original List---");
		for (String o:originalList2) {
			System.out.println(o);											//Print original list
		}

		
		ArrayList<String> copiedList2 = new ArrayList<String>();				//Create another ArrayList for copied list (clone of original list)
		
		for(int j=0; j<originalList2.size(); j++) {
			copiedList2.add(originalList2.get(j));							//Add original list items in copied list
		}
		
		Collections.sort(copiedList2, Collections.reverseOrder());			//Perform sort method on copied list by Collection framework
		
		System.out.println("---DESC Sorted List---");
		for(String s:copiedList2) {
			System.out.println(s);											//Print sorted list
		}
		
		Assert.assertTrue(copiedList2.equals(originalList2));					//Validate sorted list is equal to original list
		
		driver.close();
		
	}

}
