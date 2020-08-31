package FuntionalTestcases;

import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.KPI;
import Pages.Login;
import Utility.Base;
import Utility.Commomactions;

public class Sprint1 extends Base {
	
	
	/*@Test
	public void Doinglogin() throws InterruptedException, IOException{
	Login obj = new Login(driver);
	logger = extent.createTest("Doinglogin");
	
	Commomactions act=new Commomactions();
	Properties pro= act.ReadConfiguration();
	
	logger.log(Status.INFO, "Entering credentials");
	//obj.dologin("Admin", "admin123");
	obj.dologin(pro.getProperty("username"),pro.getProperty("pwd"));
	
	logger.log(Status.INFO, "chceking if login was succesful");
	Boolean result= obj.isSuccessfullLogin();
	Assert.assertTrue(result);
	
	logger.log(Status.INFO, "Login is successfull");
	

	}*/
	@Test
	public void KPItest() throws InterruptedException, IOException{
		Login obj = new Login(driver);
		logger = extent.createTest("KPItest");
		Commomactions act=new Commomactions();
		Properties pro= act.ReadConfiguration();
		logger.log(Status.INFO, "Entering credentials and click on login");
		obj.dologin(pro.getProperty("username"),pro.getProperty("pwd"));
		
		logger.log(Status.INFO, "chceking if login was succesful");
		Assert.assertTrue(obj.isSuccessfullLogin());
		logger.log(Status.INFO, "Login is successfull");
		
		KPI obj1 = new KPI(driver);
		//logger = extent.createTest("KPItest");
		logger.log(Status.INFO, "Clicking KPI");
		obj1.ClickKPI();
		
		
		Base obj3 = new Base();
		logger.log(Status.INFO, "Taking screenshoot");
		obj3.takescrnshot("KPI");
		logger.log(Status.INFO, "Screenshot taken and stored");
		

		logger.log(Status.INFO, "adding KPI entires");
		obj1.addKPI();
		logger.log(Status.INFO, "validating the added entry");
		 obj1.validateKPI();
		
		//Assert.assertTrue(result);
	}

}
