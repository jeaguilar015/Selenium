package pages.aca;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import io.testproject.java.sdk.v2.drivers.WebDriver;

public class Create {
	
	WebDriver driver;
	
	public Create(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[contains(., 'To Another Metrobank Account Details')]")
	WebElement ACAheader;
	
	@FindBy(xpath = "(//*[.='Amount']//following::span[contains(., 'This field is required')])[last()]")
	WebElement ACA_amountFldErr;
	
	@FindAll({
		@FindBy(xpath = "(//*[.='Amount']//following::input)[1]")
	})
	WebElement ACA_amountFld;
	
	@FindBy(xpath = "//*[@type='submit' and @value='Next Step']")
	WebElement ACA_nextBtn;
	
	// Type text
	public void typeAmount() {
		ACA_amountFld.sendKeys();
	}
	
	// Click actions
	public void clickNext() {
		ACA_nextBtn.click();
	}
	
	// Boolean
	public boolean ACAheader_isDisplay() {
		if (!ACAheader.isDisplayed()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean ACA_amountFldErr_isDisplay() {
		if (!ACA_amountFldErr.isDisplayed()) {
			return false;
		} else {
			return true;
		}
	}
}
