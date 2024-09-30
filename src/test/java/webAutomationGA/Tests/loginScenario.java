package webAutomationGA.Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import webAutomationGA.TestComponents.baseTest;
import webAutomationGA.pageObjects.chatInfo;
import webAutomationGA.pageObjects.dashboardPage;
import webAutomationGA.pageObjects.slackLogin;

import java.io.IOException;
import java.util.List;


import webAutomationGA.TestComponents.Retry;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import webAutomationGA.abstractComponents.abstractComponent;


public class loginScenario extends baseTest {

    @Test(priority=0,groups= {"smokeTests"},retryAnalyzer= Retry.class, description="Verify login with correct credentials is working")
    public void loginSuccess() throws IOException, InterruptedException {
    	
    	landingpage.login("team@thehelpdeskteam.com", "KK>?78h,--bVPoe");
    	
    	
		dashboardPage dashboard= new dashboardPage(driver);
		dashboard.dashboardVerification();
		dashboard.goTo();
		
		List<chatInfo> userEmails = dashboard.getChats();
	    // Verify the chats count or any other assertions you want
	    System.out.println("Total chats that waited at least 4 minutes: " + userEmails.size());
	    
	    
	    driver.switchTo().newWindow(WindowType.WINDOW); // Use appropriate window type if required
	    slackLogin sl= new slackLogin(driver);
	    sl.goTo();
	   
	    sl.createMessageInSlacks(userEmails);
	    
	    
		
       
        
    }
    	
}
