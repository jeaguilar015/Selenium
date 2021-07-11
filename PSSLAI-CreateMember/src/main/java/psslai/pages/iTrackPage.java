package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class iTrackPage {
	
	@FindBy(xpath = "//*[text()='Step ' and text()='5']")
	WebElement stepBubbleTxt;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Mobile Number']//following-sibling::input")
	})
	WebElement iTrackMobileNo;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Security Question 1']//following::div[text()='Choose Security Question'][1]//following-sibling::div/input")
	})
	WebElement secQuestion1;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Security Question 1']//following::div[text()='Choose Security Question'][2]//following-sibling::div/input")
	})
	WebElement secQuestion2;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Security Question 1']//following::div[text()='Choose Security Question'][3]//following-sibling::div/input")
	})
	WebElement secQuestion3;
	
	@FindBy(xpath = "//input[contains(@name, 'securityQuestion1Answer')]")
	WebElement answer1;
	
	@FindBy(xpath = "//input[contains(@name, 'securityQuestion2Answer')]")
	WebElement answer2;
	
	@FindBy(xpath = "//input[contains(@name, 'securityQuestion3Answer')]")
	WebElement answer3;
	
	@FindBy(xpath = "//*[text()='Next']")
	WebElement nextBtn;
	
	/* 
	 * 	boolean methods
	 */
	public boolean stepIsDisplayed() {
		return stepBubbleTxt.isDisplayed();
	}
	
	/*
	 * 	action methods
	 */
	public void enterMobileNum(String setMobile) {
		iTrackMobileNo.sendKeys(setMobile);
	}
	
	public void selectQuestion1(String setQuestion1) {
		secQuestion1.sendKeys(setQuestion1);
	}
	
	public void selectQuestion2(String setQuestion2) {
		secQuestion1.sendKeys(setQuestion2);
	}
	
	public void selectQuestion3(String setQuestion3) {
		secQuestion1.sendKeys(setQuestion3);
	}
	
	// Enter Answer
	public void enterAnswer1(String setAnswer1) {
		answer1.sendKeys(setAnswer1);
	}
	
	public void enterAnswer2(String setAnswer2) {
		answer2.sendKeys(setAnswer2);
	}
	
	public void enterAnswer3(String setAnswer3) {
		answer3.sendKeys(setAnswer3);
	}
	
	public void clickNext() {
		nextBtn.click();
	}
}
