package paytm.assignment.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	private By banner = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	private By searchbar = By.xpath("//form[contains(@class,'header-form-search')]/div/div/input");
	private By searchbutton = By.xpath("//form[contains(@class,'header-form-search')]/div/button");
	private By lowtohigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
	private By hightolow = By.xpath("//div[contains(text(),'Price -- High to Low')]");
	private By price = By.xpath("//div[@class='_30jeq3 _1_WHN1']");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getBanner() {
		return driver.findElement(banner);
	}

	public WebElement getSearchBar() {
		return driver.findElement(searchbar);
	}
	
	
	public WebElement getSearchButton() {
		return driver.findElement(searchbutton);
	}
	
	public WebElement lowtohigh() {
		return driver.findElement(lowtohigh);
	}
	
	
	public WebElement hightolow() {
		return driver.findElement(hightolow);
	}
	
	public List<WebElement> getPrice() {
		return driver.findElements(price);
	}
	
	
}
