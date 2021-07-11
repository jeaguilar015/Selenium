package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CreatePage {
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Create New Membership Application']"),
		@FindBy(xpath = "//*[contains(@class, 'psslai_primarybtn psslai_addcust__btn')]")
	})
	WebElement newMemberBtn;
	
	@FindAll({
		@FindBy(xpath = "//*[contains(@id, 'react-select-2')]/div[2]/input"),
		@FindBy(xpath = "//*[text()='ACCOUNTING DEPARTMENT']//following::input[1]")
	})
	WebElement sourcePlaceCode;
	
	@FindBy(xpath = "//*[text()='Basic Information']")
	WebElement basicInfoTxt;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose Membership Type']//following::input[1]")
	})
	WebElement memberType;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose Membership Sub-Type']//following::input[1]")
	})
	WebElement subType;
	
	@FindBy(xpath = "//*[@placeholder='Enter PIN']")
	WebElement pinFld;
	
	@FindBy(xpath = "//*[@placeholder='Enter PAN']")
	WebElement panFld;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='APPLICATION-IN-PROGRESS']")
	})
	WebElement memberStatus;
	
	@FindAll({
		@FindBy(xpath = "//*[@placeholder='Enter Last Name']")
	})
	WebElement lastName;
	
	@FindAll({
		@FindBy(xpath = "//*[@placeholder='Enter First Name']")
	})
	WebElement firstName;
	
	@FindAll({
		@FindBy(xpath = "//*[@placeholder='Enter Middle Name']")
	})
	WebElement middleName;
	
	@FindBy(xpath = "//*[text()='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Employee Number already exists.')]")
	WebElement alreadyExists;
	
	/*
	 *  Boolean method
	 */
	
	public boolean checkStatus() {
		return memberStatus.isDisplayed();
	}
	
	public boolean basicInfoIsDisplayed() {
		return basicInfoTxt.isDisplayed();
	}
	
	public void newMemberApplication() {
		newMemberBtn.click();
	}
	
	public void clickMemberType() {
		memberType.click();
	}
	
	public void enterPlaceCode(String placeCode) {
		sourcePlaceCode.sendKeys(placeCode);
	}
		
	public void enterMemberType(String type) {
		memberType.sendKeys(type);
	}
	
	public WebElement getMemberType() {
		return memberType;
	}
	
	public void enterSubType(String subtype) {
		subType.sendKeys(subtype);
	}
	public void enterUniqueVal(double pin) {
		
		pinFld.sendKeys(Double.toString(pin).replace(".", ""));
//		panFld.sendKeys(Double.toString(pan).replace(".", ""));
	}
	
	public void personalInfo(String lname, String fname, String mname) {
		lastName.sendKeys(lname);
		firstName.sendKeys(fname);
		middleName.sendKeys(mname);
		
		clickNext();
	}
	
	public void clickNext() {
		nextBtn.click();
	}
}
