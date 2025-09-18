package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	WebDriver driver;
	WebDriverWait wait;
	//JavaScriptExecutor js;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//this.js=(JavaScriptExecutor) driver;
	}
	
	By btn_closePopup=By.xpath("//button[contains(text(),'X')]");
	By searchBox =By.name("q");
	By productList = By.xpath("//a[contains(@href,'/p/')]");
	
	By btn_BuyNow= By.xpath("//button[normalize-space()='Buy Now']");//normalize space
	By paymentPageHdr= By.xpath("//span[normalize-space()='Payment Options']");
	
	public void closeLoginPopup()
	{
		try {
			WebElement popup=wait.until(ExpectedConditions.elementToBeClickable(btn_closePopup));
			popup.click();
			System.out.println("Closed login popup");
		}
		//use find elements instead of try catch
		catch(Exception e) {
			System.out.println("No login popup found");
		}
	}
	public void searchShoes() {
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		search.clear();
		search.sendKeys("shoes",Keys.ENTER);//no 2 inputs as strings is taken
		System.out.println("Searched for shoes");
	}
	
	public void clickFirstShoe() {
		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		if(!products.isEmpty()) {
			String Parent =driver.getWindowHandle();
			products.get(0).click();
			System.out.println("clicked first shoe product");
			
			Set<String> handles=driver.getWindowHandles();
			for(String handle : handles) {
				if(!handle.equals(Parent)) {
					driver.switchTo().window(handle);
					System.out.println("Switched to Product details tab");
				}
			}
		}else {
			System.out.println("No shoe product is found");
		}
	}

}

//validation and try catch block
