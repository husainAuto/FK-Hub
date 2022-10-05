package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginButton {
	
	@FindBy (xpath = "//a[text()='Login']")
	private WebElement login;
	
	public LoginButton (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() {
		login.click();
	}

}
