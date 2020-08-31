package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	 WebDriver driver;
	 
	//object repository
	 @FindBy(id = "txtUsername")
	 WebElement usrname;
	 
	 @FindBy(id = "txtPassword")
	 WebElement passwd;
	 
	 @FindBy(xpath = "//*[@id='btnLogin']")
	 WebElement loginbtn;
	 
	 @FindBy(xpath = "//*[@id='content']/div/div[1]/h1")
	WebElement txt1;
	 
	//construstor
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void dologin(String a, String b) throws InterruptedException{
		usrname.sendKeys(a);
		Thread.sleep(10000);
		passwd.sendKeys(b);
		Thread.sleep(5000);
		loginbtn.click();
	
		}
	
	public Boolean isSuccessfullLogin(){
		if (txt1.getText().equalsIgnoreCase("dashboard")){
			return true;
		}
		else{
			return false;
		}
		
		
	}

}
