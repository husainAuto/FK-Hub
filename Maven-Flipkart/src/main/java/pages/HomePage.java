package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	private Actions act;
	
	
	@FindBy (xpath = "//div[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy (xpath = "//div[text()='My Profile']")
	private WebElement myProfile;
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		
	}
	
	public void clickmyProfile() {
		act.moveToElement(myaccount).perform();
		act.moveToElement(myProfile).click().build().perform();
	}
}
