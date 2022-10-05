package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Variable declaration --WebElement declaration
	
	@FindBy (xpath = "(//input[@autocomplete='off'])[2]")
	private WebElement username;
	
	@FindBy (xpath = "//input[contains(@type,'password')]")
	private WebElement password;
	
	@FindBy (xpath = "(//button[contains(@type,'submit')])[2]")
	private WebElement loginbutton;
	
		
	//Constructor -WebElement Initialization
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//Method - Use of WebElement
	
	public void sendUserName() {
	
		 username.sendKeys("9637483567");
	}
	
	public void sendPassword() {
		
		 password.sendKeys("9975105307860");
	}
	
	public void clickLogin() {
		
		 loginbutton.click();
	}
	
}
	
	
	

