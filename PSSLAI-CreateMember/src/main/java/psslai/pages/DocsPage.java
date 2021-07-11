package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DocsPage {

	@FindAll({
		@FindBy(xpath = "//*[text()='Step ' and text()='6']")
	})
	WebElement stepBubbleTxt;
	
	@FindBy(xpath = "//*[text()='File Extension']//following::img[contains(@src, 'UploadAlt')][1]")
	WebElement uploadId;
	
	/*
	 * 		boolean methods
	 */
	
	public boolean stepsIsDisplayed() {
		return stepBubbleTxt.isDisplayed();
	}
	
	/*
	 * 		action methods
	 */
	public void clickUploadLink() {
		uploadId.click();
	}
}
