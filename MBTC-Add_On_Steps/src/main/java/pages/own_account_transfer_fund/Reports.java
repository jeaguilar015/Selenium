package pages.own_account_transfer_fund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.testproject.java.sdk.v2.drivers.WebDriver;

public class Reports {

	WebDriver driver;
	
	public Reports(WebDriver driver) {
		this.driver = driver;
	}
	
	// Settings Report table headers
	@FindBy(xpath = "//*[.='Reference Number']")
	WebElement theadRefNum;
	
	@FindBy(xpath = "//*[.='Amount']")
	WebElement theadAmount;
	
	@FindBy(xpath = "//*[.='Transfer From']")
	WebElement theadTransferFrom;
	
	@FindBy(xpath = "//*[.='Transfer To']")
	WebElement theadTransferTo;
	
	@FindBy(xpath = "//*[.='Status']")
	WebElement theadStatus;
	
	public boolean isRefNumDisplay() {
		
		if(theadRefNum.isDisplayed()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean isAmountDisplay() {
		
		if(theadAmount.isDisplayed()) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
