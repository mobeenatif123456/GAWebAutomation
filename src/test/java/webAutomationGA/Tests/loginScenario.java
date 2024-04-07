package webAutomationGA.Tests;

import webAutomationGA.TestComponents.baseTest;
import webAutomationGA.pageObjects.dashboardPage;
import java.io.IOException;
import org.testng.annotations.Test;
import webAutomationGA.TestComponents.Retry;


public class loginScenario extends baseTest {

    @Test(priority=0,groups= {"smokeTests"},retryAnalyzer= Retry.class, description="Verify login with correct credentials is working")
    public void loginSuccess() throws IOException, InterruptedException {
    	
    	landingpage.login("mobeen.atif@automotive-ai.com", "Kabul@123");
		dashboardPage dashboard= new dashboardPage(driver);
		dashboard.dashboardVerification();
		
    }
    
    @Test(priority=1, retryAnalyzer= Retry.class, description= "Verify login with incorrect credentials is not working")
    public void loginFailure() throws IOException, InterruptedException {
    	
    	landingpage.login("mobeen.atif@automotive-ai.com", "Kabul@12345");
		dashboardPage dashboard= new dashboardPage(driver);
		dashboard.dashboardVerification();
		
    }
    
		
}
