package webAutomationGA.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	@FindBy(xpath="//h1[text()='Welcome, Lisa!']")
	WebElement welcomeNote;
	
	@FindBy(xpath="//a[@aria-label='Reports']")
	WebElement reports;
	
	@FindBy(xpath="//p[text()='Customers']")
	WebElement customers;
	
	@FindBy(xpath="//p[text()='Queue abandonment']")
	WebElement queueAbandonment;
	
	@FindBy(xpath="(//div[text()='Queue abandonment'])[1]")
	WebElement queueAbandonmentHeading;
	
	@FindBy(xpath="//strong[text()='Date']")
	WebElement date;
	
	@FindBy(xpath="//span[text()='Today']")
	WebElement today;
	
	@FindBy(xpath="//div[@class='css-z3s52w']")
	WebElement downArrow;
	
	public void dashboardVerification() {
		
		waitforElementDisplayed(By.xpath("//h1[contains(text(),'Lisa!')]"));
	}
	
    
    public List<String> getChats() throws InterruptedException {
        
  
        // Locate the chats in the queue
        List<WebElement> allChats = driver.findElements(By.xpath("//div[@class='css-cssveg']/div")); // Update the XPath to match your chat elements
        
        // Initialize an empty list to store chats that waited at least 4 minutes
        List<String> filteredChats = new ArrayList<>();
        
        // Traverse each chat and filter based on the time waited
     // Skip the first element (header) by starting from index 1
        for (int i = 2; i < allChats.size(); i++) {
            WebElement chat = allChats.get(i);
            
            System.out.println("Total chats that waited at least 4 minutes: " + chat.getText());
            
            Thread.sleep(5000);
            chat.click();
            Thread.sleep(5000);
            // Locate the wait time element in each chat (update XPath)
            WebElement waitTimeElement = chat.findElement(By.xpath("//div/span[text()='Waited for:']/..")); // Ensure XPath matches your structure
            
            // Extract the full wait time text (e.g., "3m 16s")
            String text= waitTimeElement.getText();
            
            Pattern pattern = Pattern.compile("(\\d+)min");
            Matcher matcher = pattern.matcher(text);

            int minutes = 0; // Default to 0 if no minutes found
            if (matcher.find()) {
                String minutesStr = matcher.group(1); // Get the string representation of minutes
                minutes = Integer.parseInt(minutesStr); // Convert string to integer
            }

            System.out.println("Minutes waited: " + minutes);
            
            // Check if the wait time is at least 4 minutes
            if (minutes >= 4) {
            	
            	String userName = chat.findElement(By.xpath(".//span[@class='user-name']")).getText().trim(); // Update to match the XPath for user name
            	System.out.println(userName);
                filteredChats.add(userName);
                
                
            }
            
            Thread.sleep(1000);
            downArrow.click();
            Thread.sleep(1000);
            
            
        }
        
        // Return the list of filtered chats that waited at least 4 minutes
        return filteredChats;
    }
    
    
    public void goTo() throws InterruptedException {
		driver.get("https://my.livechatinc.com/reports/queue-abandonment");
		Thread.sleep(1000);
		waitforElementDisplayed(By.xpath("(//div[text()='Queue abandonment'])[1]"));
		date.click();
		waitforElementDisplayed(By.xpath("//span[text()='Today']"));
		today.click();
		Thread.sleep(5000);
		
		
		
	}
   

}
