package webAutomationGA.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webAutomationGA.abstractComponents.abstractComponent;

public class landingPage extends abstractComponent {
	
	
	WebDriver driver;
	
	public landingPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@type='email']")
	WebElement userEmail;
	
	By emailVisible= By.xpath("//input[@type='email']");
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement nextButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement userPassword;
	
	By passwordVisible= By.xpath("//input[@type='password']");
	
	public void login(String email,String password) throws InterruptedException {
		
		
		waitforElementDisplayed(emailVisible);
		userEmail.sendKeys(email);
		Thread.sleep(1000);
		nextButton.click();
		waitforElementDisplayed(passwordVisible);
		userPassword.sendKeys(password);
		Thread.sleep(1000);
		nextButton.click();
		waitforElementDisplayed(By.xpath("//input[@type='submit']"));
		Thread.sleep(1000);
		nextButton.click();
		
		
	}
	
	public void goTo() {
		driver.get("https://preprod.ga.adp.cariad.digital/");
	}
	

}
