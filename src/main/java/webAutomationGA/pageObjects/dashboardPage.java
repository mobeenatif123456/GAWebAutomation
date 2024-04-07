package webAutomationGA.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import webAutomationGA.abstractComponents.abstractComponent;

public class dashboardPage extends abstractComponent {
	
	WebDriver driver;
	
	public dashboardPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//h1[text()='Campaigns']")
	WebElement campaignHeading;
	
	@FindBy(xpath="//button[text()='Delete Campaign']")
	WebElement deleteCampaign;
	
	@FindBy(xpath="//button[text()='Delete']")
	WebElement deleteButton;
	
	
	public void dashboardVerification() {
		
		waitforElementDisplayed(By.xpath("//h1[text()='Campaigns']"));
	}
	
    public void campaignVerification(String campaignName) {
    	
    	
    	WebElement element= driver.findElement(By.xpath("//div[text()="+ campaignName +"]"));
    	elementDisplayed(element);
		
	}
    
   public void deleteCampaign(String campaignName) throws InterruptedException {
    	
	    WebElement element= driver.findElement(By.xpath("//div[text()="+ campaignName +"]"));
   	    elementDisplayed(element);
    	WebElement checkBoxOfCampaign= driver.findElement(By.xpath("//div[text()="+ campaignName +"]/../../..//span[@class='Checkbox_Style-checkbox']"));
    	checkBoxOfCampaign.click();
    	Thread.sleep(1000);
    	deleteCampaign.click();
    	Thread.sleep(1000);
    	deleteButton.click();
    	Thread.sleep(1000);
    	elementNotDisplayed(element);
    	
		
	}

}
