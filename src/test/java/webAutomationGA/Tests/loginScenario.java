package webAutomationGA.Tests;

import org.testng.annotations.Test;
import webAutomationGA.TestComponents.baseTest;
import webAutomationGA.pageObjects.dashboardPage;
import java.io.IOException;
import java.util.List;


import webAutomationGA.TestComponents.Retry;


public class loginScenario extends baseTest {

    @Test(priority=0,groups= {"smokeTests"},retryAnalyzer= Retry.class, description="Verify login with correct credentials is working")
    public void loginSuccess() throws IOException, InterruptedException {
    	
    	landingpage.login("team@thehelpdeskteam.com", "KK>?78h,--bVPoe");
		dashboardPage dashboard= new dashboardPage(driver);
		dashboard.dashboardVerification();
		dashboard.goTo();
		
		List<String> chats = dashboard.getChats();
	    // Verify the chats count or any other assertions you want
	    System.out.println("Total chats that waited at least 4 minutes: " + chats.size());
		
    }
    	
}
