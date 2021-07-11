package psslai.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import psslai.runner.PersonalInformation;

public class PersonalInfoPage {
	WebDriver driver;

	PersonalInformation pInfo = new PersonalInformation();
	
	@FindBy(xpath = "//*[text()='Step ' and text()='3']")
	WebElement stepbubblText;
	
	@FindBy(xpath = "//*[text()='Contact Details']")
	WebElement contactInfoText;
	
	@FindBy(xpath = "//*[text()='Present Address']")
	WebElement presendAddText;
	
	@FindBy(xpath = "//*[text()='Home Address']")
	WebElement homeAddText;
	
	@FindBy(xpath = "//*[text()='Same as Present Address']")
	WebElement cbPresentAddTxt;;
	
	// Enter MALE
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose Gender']//following-sibling::div/input"),
//		@FindBy(xpath = "//*[text()='Choose Gender']")
	})
	WebElement gender;
	
	@FindBy(xpath = "//*[text()='Choose Gender']//following-sibling::div/input")
	WebElement genderValue;
	
	// Enter SINGLE
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose Civil Status']//following-sibling::div/input")
	})
	WebElement civilStatus;
	
	// Enter 12/14/1994
	@FindAll({
		@FindBy(xpath = "//*[contains(@class, 'react-datepicker__')]/input")
	})
	WebElement birthDate;
	
	// Enter DAGOHOY
	@FindAll({
		@FindBy(xpath = "//*[text()='Place of Birth']//following-sibling::div/div/input")
	})
	WebElement birthPlace;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Mobile Number']//following-sibling::input"),
		@FindBy(xpath = "//*[@placeholder='Enter Mobile Number']")
	})
	WebElement mobileNum;
	
	@FindBy(xpath = "//*[@placeholder='Enter Phone Number']")
	WebElement phoneNum;
	
	@FindAll({
		@FindBy(xpath = "//*[@placeholder='Choose Province']")
	})
	WebElement province;
	
	@FindBy(xpath = "//*[@placeholder='Choose City']")
	WebElement city;
	
	@FindBy(xpath = "//*[@placeholder='Choose Barangay']")
	WebElement barangay;
	
	@FindBy(xpath = "//*[@placeholder='Enter Street']")
	WebElement street;
	
	@FindBy(xpath = "//*[text()='Same as Present Address']//preceding-sibling::div[contains(@class, 'modal-check-checkbox')]")
	WebElement cbSameAddress;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Next']")
	})
	WebElement nextBtn;
	
	/*	|
	 * 	| boolean actions UI methods
	 * 	|	
	 */
	public boolean stepIsDisplayed() {
		return stepbubblText.isDisplayed();
	}
	
	public boolean contanctTxtIsDisplayed() {
		return contactInfoText.isDisplayed();
	}
	
	public boolean presentAddIsDisplayed() {
		return presendAddText.isDisplayed();
	}
	
	public boolean homeAddIsDisplayed() {
		return homeAddText.isDisplayed();
	}
	
	public boolean cbPresentAddIsDisplayed() {
		return cbPresentAddTxt.isDisplayed();
	}
	
	/*
	 *  Get Webelement methods
	 */
	
	public WebElement cbSameAddress() {
		return cbSameAddress;
	}
	
	/*	|
	 * 	| Perform actions UI methods
	 * 	|	
	 */
	public void selectGender(String setGender) {
		gender.sendKeys(setGender);
	}
	
	public WebElement getGender() {
		return gender;
	}
	
	public void selectCivil(String setCivilStatus) {
		civilStatus.sendKeys(setCivilStatus);
	}
	
	public void enterBirthDate(String setBirthDate) {
		birthDate.sendKeys(setBirthDate);
	}
	
	public void enterBirthPlace(String setBirthPlace) {
		birthPlace.sendKeys(setBirthPlace);
	}
	
	public void enterMobileNum(String setMobileNum) {
		mobileNum.sendKeys(setMobileNum);
	}
	
	public void enterPhoneNum(String setPhoneNum) {
		phoneNum.sendKeys(setPhoneNum);
	}
	
	public void enterProvince(String setProvince) {
		province.sendKeys(setProvince);
	}
	
	public void enterCity(String setCity) {
		city.sendKeys(setCity);
	}
	
	public void enterBrgy(String setBrgy) {
		barangay.sendKeys(setBrgy);
	}
	
	public void enterStreet(String setStreet) {
		street.sendKeys(setStreet);
	}
	
	public void checkSameAddress() {
		cbSameAddress.click();
	}
	
	public WebElement getMobile() {
		return mobileNum;
	}
	
	public WebElement getPhone() {
		return phoneNum;
	}
	
	public void clickNextBtn() {
		nextBtn.click();
	}
	
	// Personal Information
	public void enterPersonalInfo (String getGender, String getCivilStatus, String getBirthDate, String getPlaceBirth) throws AWTException  {
		Robot rb = new Robot();
		
		selectGender(getGender);
		rb.keyPress(KeyEvent.VK_ENTER);

		selectCivil(getCivilStatus);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		enterBirthDate(getBirthDate);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		enterBirthPlace(getPlaceBirth);
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	// Contact Info
	public void enterContactInfo(String getMN, String getPN) {
		enterMobileNum(getMN);
		enterPhoneNum(getPN);
	}
	
	// Present Address
	public void enterPresentAdd(String getCity, String getBarangay, String getStreet) throws AWTException {
		Robot rb = new Robot();
		
//		enterProvince(getProvince);
//		driver.findElement(By.xpath("//*[text()='"+ pInfo.province +"'][last()]")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+ pInfo.province +"']"))).click();
//		rb.keyPress(KeyEvent.VK_ENTER);
		
		enterCity(getCity);
		 
		rb.keyPress(KeyEvent.VK_ENTER);
		
		enterBrgy(getBarangay);
//		driver.findElement(By.xpath("//*[text()='"+ pInfo.barangay +"'][last()]")).click();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		enterStreet(getStreet);
	}
	
}
