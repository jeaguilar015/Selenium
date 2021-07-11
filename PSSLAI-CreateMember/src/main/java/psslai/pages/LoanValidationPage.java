package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoanValidationPage {
	// USER @Step 2
	@FindBy(xpath = "//*[text(), 'Step ' and text(), '2']")
	WebElement step2;
	
	@FindBy(xpath = "//*[text()='Loan Amount Requested']//following-sibling::input']")
	WebElement loanAmountReq;

	// USER @Step 4
	@FindBy(xpath = "//*[text()='Step ' and text()='4']")
	WebElement step4; 
	
	@FindBy(xpath = "//*[text()='Charges']")
	WebElement charges;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Loan Filing Mode']//following::span[@id='single-value-label'][1]")
	})
	WebElement filingMode;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Loan Release Type']//following::span[@id='single-value-label'][1]")
	})
	WebElement releaseType;
	
	@FindBy(xpath = "//*[text()='DOCUMENTARY STAMPS TAX']")
	WebElement dts;
	
	@FindBy(xpath = "//*[text()='LOAN SERVICE CHARGE - AGENT']")
	WebElement filingServiceCharge;
	
	@FindBy(xpath = "//*[text()='LOAN SERVICE CHARGE - PNB PORTAL CHARGE']")
	WebElement releaseTypeCharge;
	
	/*
	 * - - - - - boolean methods
	 */
	public boolean atStep2() {
		return step2.isDisplayed();
	}
	
	public boolean atStep4() {
		return step4.isDisplayed();
	}
	
	public boolean chargeIsDisplayed() {
		return charges.isDisplayed();
	}
	
	public boolean dtsIsDisplayed() {
		return dts.isDisplayed();
	}
	
	public boolean filingServiceChrg() {
		return filingServiceCharge.isDisplayed();
	}
	
	public boolean releaseTypeCharge() {
		return releaseType.isDisplayed();
	}
	
	/*
	 * - - - - - get element methods
	 */
	public WebElement getAmntRequested() {
		return loanAmountReq;
	}
	
	public WebElement getFilingMode() {
		return filingMode;
	}
	
	public WebElement getReleaseType() {
		return releaseType;
	}
	
	/*
	 * - - - - - action methods
	 */
}
