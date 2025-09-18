package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	By btn_login=By.xpath("//a[normalize-space()='Login']");
	By txt_email=By.xpath("//input[@class='r4vIwl BV+Dqf']");
	By btn_otp=By.xpath("//button[normalize-space()='Request OTP']");
	By txt_phn=By.xpath("//input[@class='r4vIwl BV+Dqf']");
	By btn_continue=By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']");
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void setEmail(String Email) {
		driver.findElement(txt_email).sendKeys(Email);
	}
	
	
	public void clickOtp() {
		driver.findElement(btn_otp).click();
	}
	
	public void txt_Phn(String Phone) {
		driver.findElement(txt_phn).sendKeys(Phone);;
	}
	
	public void clickContinue() {
		driver.findElement(btn_continue).click();
	}
	
	

}
