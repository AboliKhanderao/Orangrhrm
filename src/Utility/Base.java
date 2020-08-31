package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger; 
    public static WebDriver driver;

   
@BeforeTest
public void startReport(){
	 Date d = new Date();
     System.out.println(d.toString());
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

	
htmlReporter = new ExtentHtmlReporter("D:\\Report"+sdf.format(d) +".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        /*extent.setSystemInfo("OS", "Mac ");
        extent.setSystemInfo("Host Name", "test");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Krishna Sakinala");*/
}
@AfterMethod
public void getResult(ITestResult result){

if(result.getStatus() == ITestResult.SUCCESS) {

logger.log(Status.PASS, "Test Case Passed " + result.getName());
}

  if(result.getStatus() == ITestResult.FAILURE){
 logger.log(Status.FAIL, "Test Case Failed is"+result.getName() + result.getThrowable());
     //logger.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());
}
   if(result.getStatus() == ITestResult.SKIP){logger.log(Status.SKIP, "Test Case Skipped is"+result.getName());
}

//extent.endTest(logger);
}  
	
	@Parameters({"browser","url"})
	@BeforeMethod
	//public void LaunchBrowser(@Optional("chrome")String browser,@Optional("xyz") String url)
	public void LaunchBrowser(String browser,String url){
		
		if (browser.equals("chrome")){
		System.out.println("Chrome launching");

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aboli\\Downloads\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
//			List<String> lst = new ArrayList<>();
//			lst.add("--lang= en");
//			lst.add("disable-infobars");
//			lst.add("start-maximized");
//			lst.add("-incognito");
//			lst.add("disable-popup-blocking");
//			op.addArguments(lst);
			op.setExperimentalOption("useAutomationExtension", false);
			op.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			
			op.addArguments("--lang= en","start-maximized","--ignore-certificate-errors","-incognito","disable-popup-blocking");
			//op.addArguments("disable-infoobars");
			//op.addArguments("start-maximized");
			driver = new ChromeDriver(op);
			driver.get(url);	
		}
		else if(browser.equals("Ie")){
			System.out.println("Ie launched");
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Lenovo\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();		
				ieCapabilities.setCapability("unexpectedAlertBehaviour" , "ignore");
				ieCapabilities.setCapability("enablePersistentHover", false);
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("requireWindowFocus", true);
				ieCapabilities.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);// Add this desiredcapabilities when the security
								// level of IE not set to same.
				//ieCapabilities.setBrowserName("SELENIUM");
				//ieCapabilities.setJavascriptEnabled(true);
				ieCapabilities.setCapability("acceptSslCerts", true);
			//	ieCapabilities.setCapability("browserstack.ie.enablePopups", "true");
				ieCapabilities.setCapability("disable-popup-blocking", true);
				//ieCapabilities.setCapability("acceptSslCerts", "true");
 
			driver = new InternetExplorerDriver();
			driver.get(url);
		}
	}
	@AfterMethod
	public void Closebrowser(){
		driver.quit();
		System.out.println("Browser closed");
	}
	@AfterSuite
	  public void endReport(){

	                 extent.flush();
	                 //extent.close();
	    }
	public  void takescrnshot(String filename) throws IOException{
		Date d = new Date();
	     System.out.println(d.toString());
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\Aboli\\workspace\\Pagesobjectmodel\\src\\screenshots\\"+ filename + sdf.format(d)+ ".jpg"));
	}
	
}
