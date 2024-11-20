package webAutomationGA.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import webAutomationGA.abstractComponents.abstractComponent;

public class bradReport extends abstractComponent {
	
	
	WebDriver driver;
	
	public bradReport(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//h3[text()='Year / Period']")
	WebElement yearChannel;
	
	@FindBy(xpath="//h3[text()='Year / Period']/../../../..//div[text()='All'] | //h3[text()='Year / Period']/../../../..//div[text()='2024'] |  //h3[text()='Year / Period']/../../../..//div[text()='Multiple selections']")
	WebElement allDropdown;
	
	@FindBy(xpath="//span[@class='slicerText']")
    List<WebElement> dropdownOptions;
	
	@FindBy(xpath="//div[@role='columnheader']/..")
	WebElement columnHeaders;
	
	
	@FindBy(xpath="//span[text()='2019']")
	WebElement selectedYearChannel;
	
	@FindBy(xpath="//div[text()='Year']")
	WebElement yearHeader;
	
	@FindBy(xpath="(//div[text()='Year']/../../../../..//div[@role='gridcell'])[2]")
	WebElement firstRowYear;
	
	@FindBy(xpath="(//div[text()='Order Type Desc']/../../../../..//div[@role='gridcell'])[5]")
	WebElement firstRowOrderTypeDesc;
	
	@FindBy(xpath="//button[text()='Reset']")
	WebElement resetButton;
	
	@FindBy(xpath="//span[text()='Brad Report']")
	WebElement bradReportHeading;
	
	@FindBy(xpath="//div[@class='imageBackground']")
    WebElement filterButton;
	
	@FindBy(xpath="//*[name()='svg']/..//h3[text()='Order Type']")
    WebElement orderType;
	
	@FindBy(xpath="//*[name()='svg']/..//h3[text()='Order Type']/../../../..//div[text()='All']")
    WebElement orderTypeDropdown;
	
	
	@FindBy(xpath="(//div[@class='searchHeader show']/input)[1]")
    WebElement orderTypeSearch;
	
	@FindBy(xpath="//span[text()='STANDARD ORDER']")
    WebElement standardOrder;
	
	@FindBy(xpath="//div[@class='imageBackground']")
    WebElement crossButton;
	
	@FindBy(xpath="//h3[text()='Available Columns']/../../../..//div[text()='All']")
    WebElement availableColumnsDropdown;
	
	@FindBy(xpath="//span[text()='Year']")
    WebElement availableColumnsYear;
	
	@FindBy(xpath="//span[text()='Period']")
    WebElement availableColumnsPeriod;
	
	@FindBy(xpath="//span[text()='Date']")
    WebElement availableColumnsDate;
	
	@FindBy(xpath="//span[text()='Order Type Desc']")
    WebElement orderTypeDesc;
	
	
	@FindBy(xpath="//div[text()='Order Type Desc']")
    WebElement orderTypeDescColumnHeader;
	

	
	public void channelFilter() throws InterruptedException {
		
		
		commonActions();
		waitforElementDisplayed(By.xpath("//h3[text()='Year / Period']/../../../..//div[text()='All'] | //h3[text()='Year / Period']/../../../..//div[text()='2024'] |  //h3[text()='Year / Period']/../../../..//div[text()='Multiple selections']"));
		allDropdown.click();
		Thread.sleep(5000);
		
		
	}
	
	
	
	
	public List<String> verifyYearOptions() {
	    
	    String[] expectedYears = {"Select all","2019", "2020", "2021", "2022", "2023", "2024"};
	    List<String> missingYears = new ArrayList<>();

	    for (String year : expectedYears) {
	        boolean yearFound = dropdownOptions.stream()
	                .anyMatch(option -> option.getText().trim().equals(year));
	        if (!yearFound) {
	            missingYears.add(year); // Add missing years to the list
	        }
	    }
	    return missingYears;
	}
	
	
	
	public String selectingYearandValidatingResults(String selectedYear) throws InterruptedException {
		
		bradReportHeading.click();
		Thread.sleep(1000);
		waitforElementDisplayed(By.xpath("//div[text()='Year']"));
		Thread.sleep(1000);
		yearHeader.click();
		Thread.sleep(15000);
		String year = firstRowYear.getText();
		return year;
		
	}
	
	
	public void waitForSpinnerToDisappear() {
		WebElement revealed = driver.findElement(By.xpath("//div[@class='powerbi-spinner xsmall']"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    wait.until(d -> revealed.isDisplayed());
	}

	public void filtersFunction() throws InterruptedException {
		
		
		commonActions();
		filterButton.click();
		Thread.sleep(5000);
		waitforElementDisplayed(By.xpath("//*[name()='svg']/..//h3[text()='Order Type']"));
		Thread.sleep(1000);
		orderTypeDropdown.click();
		Thread.sleep(5000);
		orderTypeSearch.sendKeys("STANDARD ORDER");
		standardOrder.click();
		Thread.sleep(5000);
		crossButton.click();
		Thread.sleep(2000);
		availableColumnsDropdown.click();
		Thread.sleep(1000);
		availableColumnsYear.click();
		availableColumnsPeriod.click();
		availableColumnsDate.click();
		orderTypeSearch.sendKeys("Order Type Desc");
		Thread.sleep(1000);
		orderTypeDesc.click();
		Thread.sleep(5000);
		bradReportHeading.click();
		
	}
	
public String filtersVerification() throws InterruptedException {
		
		
		waitforElementDisplayed(By.xpath("//div[text()='Order Type Desc']"));
		Thread.sleep(1000);
		orderTypeDescColumnHeader.click();
		Thread.sleep(15000);
		String ordertypeDesc = firstRowOrderTypeDesc.getText();
		
		return ordertypeDesc;
	
		
	}
	
	
	public void commonActions() throws InterruptedException {
		
		waitforElementDisplayed(By.xpath("//div[@role='columnheader']/.."));
		Thread.sleep(1000);
		
		try {
	        WebElement element = driver.findElement(By.xpath("//button[@class='resetBtn rightActionBarBtn ng-star-inserted']"));

	        // Check if the element is visible (displayed)
	        if (element.isDisplayed()) {
	            element.click();
	            System.out.println("Element clicked successfully.");
	            resetButton.click();
	            Thread.sleep(1000);
	            waitforElementDisplayed(By.xpath("//div[@role='columnheader']/.."));
	            
	        } else {
	            System.out.println("Element is not visible, skipping click.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found, skipping click.");
	    }
		
	}

}
