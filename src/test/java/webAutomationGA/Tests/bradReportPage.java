package webAutomationGA.Tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import webAutomationGA.TestComponents.baseTest;
import webAutomationGA.pageObjects.bradReport;

public class bradReportPage extends baseTest {

    private bradReport test; // Declare bradReport instance

    @BeforeClass(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        // Perform login only once
        landingpage.login("mobeen.atif@effem.com", "Kabul@12345678");
        test = new bradReport(driver);
    }

    @Test(priority = 0, groups = {"smokeTests"}, description = "Verify brad report year/channel filter is working")
    public void channelFilter() throws InterruptedException {
        
        test.channelFilter();
        List<String> missingYears = test.verifyYearOptions();
        Assert.assertTrue(missingYears.isEmpty(), "Missing years in the dropdown: " + missingYears);
        String selectedYear = "2024";
        String ascYear= test.selectingYearandValidatingResults(selectedYear);
        Assert.assertEquals(selectedYear, ascYear, "The strings are not equal!");
        String desYear= test.selectingYearandValidatingResults(selectedYear);
        Assert.assertEquals(selectedYear, desYear, "The strings are not equal!");
        
        
    }
    
    @Test(priority = 0, groups = {"smokeTests"}, description = "Verify brad report filters are working")
    public void filters() throws InterruptedException {
        
    	
    	test.filtersFunction();
    	
        String text= "STANDARD ORDER";
        String orderTypeAsc= test.filtersVerification();
        Assert.assertEquals(text, orderTypeAsc, "The strings are not equal!");
        String orderTypeDesc= test.filtersVerification();
        Assert.assertEquals(text, orderTypeDesc, "The strings are not equal!");
        
        
    }
    
    
    
    
}
