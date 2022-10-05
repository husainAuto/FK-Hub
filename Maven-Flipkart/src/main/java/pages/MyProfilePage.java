package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	private Actions act;
	
	@FindBy (xpath = "//a[@href='/account/pancard']//div ")
	private WebElement PanCardInfo;
	
	@FindBy (xpath = "//div[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy (xpath = "//div[text()='Logout']")
	private WebElement logoutButton;
	
	public MyProfilePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void clickOnPanCardInfo() {
		PanCardInfo.click();
	}
	public void clickLogoutButton() {
		act.moveToElement(myaccount).perform();
		act.moveToElement(logoutButton).click().build().perform();
	}

}
