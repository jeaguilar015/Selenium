package psslai.runner;

import org.openqa.selenium.By;
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
import psslai.pages.PaymentPage;

@Test(name = "PSSLAI - Create member (Step 4)")
public class CreateMemberPayment implements WebTest {
	@Parameter(defaultValue = "OVER THE COUNTER")
	public String paymentType;
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		PaymentPage pg = PageFactory.initElements(driver, PaymentPage.class);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		TestReporter report = helper.getReporter();
		
		pg.enterPayment(paymentType);
//		
		if (pg.stepIsDisplayed()) {
			// Default value on the required fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='"+ paymentType+ "'])[last()]"))).click();
			pg.clickNext();
			
			report.result("User is at Step 4");
			return ExecutionResult.PASSED;
		} else {
			
			report.result("User was not on Step 4");
			return ExecutionResult.FAILED;
		}
		
		
		
	}

}
