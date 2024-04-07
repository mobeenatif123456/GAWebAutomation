package webAutomationGA.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webAutomationGA.abstractComponents.abstractComponent;

public class campaignPage extends abstractComponent {
	
    WebDriver driver;
	
	public campaignPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	WebElement createCampaignButton;
	
	@FindBy(xpath="//label[text()='Campaign name']/../input")
	WebElement campaignNameField;
	
	@FindBy(xpath="(//select)[1]")
	WebElement moduleDefinitionDropdown;
	
	@FindBy(xpath="((//select)[1]/option)[2]")
	WebElement selectModule;
	
	@FindBy(xpath="//button[text()='Create']")
	WebElement createCampaign;
	
	
	
    public void createCampaign(String campaignName) throws InterruptedException {
		
		
		waitforElementDisplayed(By.xpath("//button[text()='Create Campaign']"));
		Thread.sleep(1000);
		createCampaignButton.click();
		waitforElementDisplayed(By.xpath("//label[text()='Campaign name']/../input"));
		campaignNameField.sendKeys(campaignName);
		moduleDefinitionDropdown.click();
		selectModule.click();
		Thread.sleep(1000);
		createCampaign.click();
		
	}
	
}
