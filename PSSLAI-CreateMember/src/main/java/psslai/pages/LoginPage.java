package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindAll({
		@FindBy(xpath = "//*[@src='/bo-login/css/psslai/images/psslai-logo-v4.png']")
	})
	WebElement psslaiLogo;
	
	@FindAll({
		@FindBy(xpath = "//*[@type='text']"),
		@FindBy(xpath = "//*[text()='User ID']/preceding::input")
	})
	WebElement userNameField;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Password']/preceding::input[1]")
	})
	WebElement passwordField;
	
	@FindAll({
		@FindBy(xpath = "//button[contains(@class,f4ButtonSave)]")
	})
	WebElement loginButton;
	
	public boolean isDisplayed() {
		return psslaiLogo.isDisplayed();
	}
	
	public void enterUsername(String name) {
		userNameField.sendKeys(name);
	}
	
	public void enterPassword(String name) {
		passwordField.sendKeys(name);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void login(String usernameParam, String passwordParam) {
		enterUsername(usernameParam);
		enterPassword(passwordParam);
		clickLogin();
//		clickLogin();
	}
}
