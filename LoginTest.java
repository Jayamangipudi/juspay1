package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	/*@Test()
	void testLogin() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		lp.setEmail("jayamangipudi99@gmail.com");
		lp.clickOtp();
		lp.txt_Phn("9493931482");
		lp.clickContinue();
		Thread.sleep(2000);	//explicit wait
		
	}*/
	
	@Test()
		void testProduct() throws InterruptedException {
			ProductPage pp=new ProductPage(driver);
			pp.closeLoginPopup();
			pp.searchShoes();
			pp.clickFirstShoe();
			Thread.sleep(2000);
			
		}
	
	
	
	@AfterClass()
	void teardown() {
		driver.quit();
	}

}
