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
	
	@FindBy(xpath="//input[@name='password']")
	WebElement userPassword;
	
	@FindBy(xpath="//div[text()='Log in']")
	WebElement loginButton;
	
	By passwordVisible= By.xpath("//input[@name='password']");
	
	@FindBy(xpath="(//p[text()='Go to your product']/..//p)[2]")
	WebElement goToLiveChat;
	
	public void login(String email,String password) throws InterruptedException {
		
		
		waitforElementDisplayed(emailVisible);
		userEmail.sendKeys(email);
		Thread.sleep(1000);
		userPassword.sendKeys(password);
		Thread.sleep(1000);
		waitforElementDisplayed(By.xpath("//div[text()='Log in']"));
		Thread.sleep(1000);
		loginButton.click();
		waitforElementDisplayed(By.xpath("(//p[text()='Go to your product']/..//p)[2]"));
		goToLiveChat.click();
		Thread.sleep(1000);
		
		
	}
	
	public void goTo() {
		driver.get("https://accounts.livechat.com/");
	}
	

}
