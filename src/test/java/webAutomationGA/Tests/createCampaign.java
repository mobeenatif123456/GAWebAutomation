package webAutomationGA.Tests;

import webAutomationGA.TestComponents.Retry;
import webAutomationGA.TestComponents.baseTest;
import webAutomationGA.pageObjects.campaignPage;
import webAutomationGA.pageObjects.dashboardPage;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

public class createCampaign extends baseTest {
	
	
    @Test(groups= {"smokeTests"} , retryAnalyzer= Retry.class, description="Verify campaign creation functionality is working")
    public void createCampaignwithoutGroups() throws IOException, InterruptedException {
    	

    	landingpage.login("mobeen.atif@automotive-ai.com", "Kabul@123");
		dashboardPage dashboard= new dashboardPage(driver);
		dashboard.dashboardVerification();
		campaignPage cp= new campaignPage(driver);
		Instant instant = Instant.now();
		System.out.println("Current timestamp: " + instant);	
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String campaignName = formatter.format(localDateTime);
		cp.createCampaign(campaignName);
		Thread.sleep(5000);
		dashboard.campaignVerification(campaignName);
		dashboard.deleteCampaign(campaignName);
		
		
    }
		
}
