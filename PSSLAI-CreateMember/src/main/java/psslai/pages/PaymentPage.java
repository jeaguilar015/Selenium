package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {

	@FindBy(xpath = "//*[text()='Step ' and text()='4']")
	WebElement stepBubbleTxt;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Choose Payment Type']//following-sibling::div/input")
	})
	WebElement paymentType;
	
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
	public void enterPayment(String setPT) {
		paymentType.sendKeys(setPT);
	}
	
	public void clickNext() {
		nextBtn.click();
	}
}
