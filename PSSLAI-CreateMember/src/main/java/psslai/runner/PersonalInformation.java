package psslai.runner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.PersonalInfoPage;

@Test(name = "PSSLAI New member application - Validate Create member (Step 3)")
public class PersonalInformation implements WebTest {
	
	@Parameter(defaultValue = "FEMALE")
	public String gender;
	
	@Parameter(defaultValue = "SINGLE")
	public String civilStatus;
	
	@Parameter(defaultValue = "12/11/1990")
	public String birthDate;
	
	@Parameter(defaultValue = "DAGOHOY")
	public String birthPlace;
	
	@Parameter(defaultValue = "0912345678901")
	public String mobileNum;
	
	@Parameter(defaultValue = "123456789012")
	public String phoneNum;
	
	@Parameter(defaultValue = "ABRA")
	public String province;
	
	@Parameter(defaultValue = "BANGUED")
	public String city;
	
	@Parameter(defaultValue = "AGTANGAO")
	public String barangay;
	
	@Parameter(defaultValue = "DONA STREET")
	public String street;
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		TestReporter report = helper.getReporter();
		
		PersonalInfoPage personalPage = PageFactory.initElements(driver, PersonalInfoPage.class);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		if (personalPage.stepIsDisplayed()) {

			try {
				personalPage.enterPersonalInfo(gender, civilStatus, birthDate, birthPlace);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (personalPage.contanctTxtIsDisplayed()) {
				personalPage.getMobile().clear();
				personalPage.getPhone().clear();
				personalPage.enterContactInfo(mobileNum, phoneNum);
				
				if (personalPage.presentAddIsDisplayed()) {
					
						personalPage.enterProvince(province);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='"+ province +"'])[last()]"))).click();
						
						personalPage.enterCity(city);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='"+ city +"'])[last()]"))).click();
						
						personalPage.enterBrgy(barangay);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='"+ barangay +"'])[last()]"))).click();
						
						personalPage.enterStreet(street);
					
					
					if (personalPage.homeAddIsDisplayed()) {
						
						if (personalPage.cbPresentAddIsDisplayed()) {
							
							//Creating the JavascriptExecutor interface object by Type casting		
					        JavascriptExecutor js = (JavascriptExecutor)driver;
					      //Perform Click on LOGIN button using JavascriptExecutor		
					        js.executeScript("arguments[0].click();", personalPage.cbSameAddress());
//							Actions builder = new Actions(driver);
//							Action move = builder
//								.moveToElement(personalPage.cbSameAddress())
//								.build();
////							
//							move.perform();
////							wait.until(ExpectedConditions.elementToBeClickable(personalPage.cbSameAddress())).click();
////							personalPage.checkSameAddress();
//							wait.until(ExpectedConditions.visibilityOf(personalPage.cbSameAddress())).click();
							personalPage.clickNextBtn();
							report.result("Present Address checkbox was able to locate");
							return ExecutionResult.PASSED;
						} else {
							report.result("Present Address checkbox unable to locate");
							return ExecutionResult.FAILED;
						}
						
					} else {
						return ExecutionResult.FAILED;
					}
					
				} else {
					return ExecutionResult.FAILED;
				}
				
			} else {
				return ExecutionResult.FAILED;
			}
			
		} else {
			return ExecutionResult.FAILED;
		}

	}
	
	public void select() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
	}
	
	public void enter() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

}
