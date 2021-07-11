package psslai.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class FamMemberPage {
	public WebDriver driver;
	
	public FamMemberPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[contains(text(), ' was successfully created.')]")
	WebElement successMessage;
	
	@FindBy(xpath = "//*[text()='Family Member Information']")
	WebElement familyInfoPage;
	
	@FindBy(xpath = "//*[contains(@placeholder, 'Maiden Name')]")
	WebElement motherMaidens;
	
	@FindBy(xpath = "//*[text()='Choose Family Group Identifier']//following-sibling::div/input")
	WebElement familyIdentifier;
	
	/*
	 * 		SALARY INFORMATION --------------- START
	 */
	@FindAll({
		@FindBy(xpath = "//*[text()='Base Pay']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter Base Pay']")
	})
	WebElement basicPay;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Gross Deduction']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter Gross Deduction']")
	})
	WebElement grossDeduction;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Gross Pay']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter Gross Pay']")
	})
	WebElement grossPay;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Net Pay']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter Net Pay']")
	})
	WebElement netPay;
	/*
	 * 		SALARY INFORMATION ------------ END
	 */
	
	// Service Record
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose Rank']/div/input"),
		@FindBy(xpath = "//*[contains(@aria-activedescendant, 'react-select-8--')]"),
		@FindBy()
	})
	WebElement rank;
	
	/*
	 * 		EMPLOYEE RECORD ----- START
	 */
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose One (Type to Search)']//following-sibling::div/input")
	})
	WebElement idType;

	@FindAll({
		@FindBy(xpath = "//*[text()='ID Number']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter ID Number']")
	})
	WebElement idNum;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='TIN']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter TIN']")
	})
	WebElement tinNum;
	
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Next']")
	})
	WebElement nextBtn;
	
	/*	|
	 * 	| Boolean methods
	 * 	|	
	 */
	public boolean iDisplayedsuccessMsg() {
		return successMessage.isDisplayed();
	}
	
	public boolean isDisplayedFamilyInfo() {
		return familyInfoPage.isDisplayed();
	}
	
	/*	|
	 * 	| Get UI methods
	 * 	|	
	 */
	public WebElement successMessage() {
		return successMessage;
	}
	
	/*	|
	 * 	| Perform actions UI methods
	 * 	|	
	 */
	public void entermaidenName(String setMaidenName) {
		motherMaidens.sendKeys(setMaidenName);
	}
	
	public void enterFamilyId(String setFamilyId) {
		familyIdentifier.sendKeys(setFamilyId);
	}
	
	public void enterBasicPay(String setBasicPay) {
		basicPay.sendKeys(setBasicPay);
	}
	
	public void enterGrossDeduction(String setGrossDeduc) {
		grossDeduction.sendKeys(setGrossDeduc);
	}
	
	public void enterGrossPay(String setGrossPay) {
		grossPay.sendKeys(setGrossPay);
	}
	
	public void enterNetPay(String setNetPay) {
		netPay.sendKeys(setNetPay);
	}
	
	public void selectRank(String setRank) {
		rank.sendKeys(setRank);
	}
	
	public void selectIdType(String setIdType) {
		idType.sendKeys(setIdType);
	}
	
	public void enterIdNum(String setIdNum) {
		idNum.sendKeys(setIdNum);
	}
	
	public void enterTinNum(String setTinNum) {
		tinNum.sendKeys(setTinNum);
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	// Enter Family Member 
	public void familyMemInformation(String getMaiden, String getFamilyId) throws AWTException {
		entermaidenName(getMaiden);
		Robot rb = new Robot();
		
//		rb.keyPress(KeyEvent.VK_ENTER);
		enterFamilyId(getFamilyId);
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	// Enter Salary Information 
	public void salaryInformation(String getBP, String getGD, String getGP, String getNP) {
		enterBasicPay(getBP);
		enterGrossDeduction(getGD);
		enterGrossPay(getGP);
		enterNetPay(getNP);
	}
	
	// Enter Employee Record
	public void employeeRecord(String getIdNum, String getTinNum) {
//		selectIdType(getIdType);
		enterIdNum(getIdNum);
		enterTinNum(getTinNum);
	}
}
