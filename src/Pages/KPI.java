package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class KPI {
WebDriver driver;
	public String str1;
	public int c=0;
	//@FindBy (id = "menu__Performance")
	@FindBy(linkText="Performance")
	WebElement performance;
	
	//@FindBy (id="menu_performance_Configure")
	@FindBy(xpath="//*[@id='menu_performance_Configure']")
	WebElement configure;
	
	//@FindBy (id="menu_performance_searchKpi")
	@FindBy (linkText="KPIs")
	WebElement foundKpi; 
	
	
	@FindBy (id="btnAdd")
	WebElement addbutton;
	
	@FindBy(id="defineKpi360_jobTitleCode")
	WebElement jobtitledrop;
	
	@FindBy(xpath="//*[@id='defineKpi360_keyPerformanceIndicators']")
	WebElement txtbox1;
	
	@FindBy(xpath="//*[@id='defineKpi360_minRating']")
	WebElement minrate;
	
	@FindBy(xpath="//*[@id='defineKpi360_maxRating']")
	WebElement maxrate;
	
	@FindBy(id="saveBtn")
	WebElement savebuttn;
	
	
	
	//constructor
	public KPI (WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickKPI() throws InterruptedException{
		Actions act =new Actions(driver);
		act.moveToElement(performance).build().perform();
		Thread.sleep(2000);
		act.moveToElement(configure).build().perform();
		Thread.sleep(2000);
		//act.moveToElement(foundKpi).click();
		foundKpi.click();
		Thread.sleep(2000);
	}
	
		
	public void addKPI() throws InterruptedException{
		addbutton.click();
		Thread.sleep(2000);
		Select sel = new Select(jobtitledrop);
		sel.selectByValue("8");
		txtbox1.sendKeys("Attendence");
		minrate.clear();
		minrate.sendKeys("1");
		maxrate.clear();
		maxrate.sendKeys("5");
		savebuttn.click();
		
	}
	public void validateKPI(){
		
		List<WebElement> lst = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		System.out.println(lst.size());
		
		for(WebElement val: lst){
			str1= val.getText();
			System.out.println(str1);
			/*System.out.println(val.getText());
			if(val.getText().equalsIgnoreCase("Attendence IT Manager 1 5"))
				System.out.println("entry found");
			else 
				System.out.println("entry was unsuccessful");*/
			if (str1.equalsIgnoreCase("Attendence IT Manager 1 5")){
				c++;
				System.out.println("entry found");}
				else
					System.out.println("entry was unsuccessful");
		}
		
			System.out.println("entry was found"+ c + "times");
			
			
			
				
	}
	
	
	
	
	
	
	

}
