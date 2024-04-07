package webAutomationGA.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import webAutomationGA.pageObjects.landingPage;

public class baseTest {
	
	public WebDriver driver;
	public landingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//webAutomationGA//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//invoke chrome browser execution
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			//invoke firefox browser execution
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		else {
			
			//invoke edge browser execution
			
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
				
		}
		
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public landingPage launchApplication() throws IOException {
		
		driver= initializeDriver();
		landingpage= new landingPage(driver);
		landingpage.goTo();
		return landingpage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		
		driver.close();
		
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+ "//reports//"+ testCaseName + ".png";
		
		
		
	}

}
