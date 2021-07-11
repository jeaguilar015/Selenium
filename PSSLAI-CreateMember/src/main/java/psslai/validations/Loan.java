package psslai.validations;

import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.LoanValidationPage;

@Test(name = "Loan Validation Charges for SERVICE CHARGE - AGENT")
public class Loan implements WebTest {
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		
		WebDriver driver = helper.getDriver();
		
		LoanValidationPage lvp = PageFactory.initElements(driver, LoanValidationPage.class);
		TestReporter report = helper.getReporter();
		
//		int requestedAmnt = 0;
//		boolean reqAmnt;
//		
//		if (lvp.atStep2()) {
//			requestedAmnt = Integer.parseInt(lvp.getAmntRequested().getText());
//			if () {
//				
//			}
//			reqAmnt = true;
//		}
//		
		if (lvp.atStep4()) {
			
			if (lvp.chargeIsDisplayed()) {
				
//				// Validated the DTS value
//				if (requestedAmnt > 250000) {
//					
//					// Verify if DTS is display
//					if (lvp.dtsIsDisplayed()) {
//						
//						report.result("User Loan Amount Requested is > than 250,000");
//						return ExecutionResult.PASSED;
//						
//					} else {
//						
//						report.result("Documentary Stamp Tax was missing");
//						return ExecutionResult.FAILED;
//						
//					}
//				}
//				
				if (lvp.getFilingMode().getText().contains("Agent") || lvp.getFilingMode().getText().contains("Referror")) {
					if (lvp.filingServiceChrg()) {
						report.result("User selected with Agent/Referror");
						return ExecutionResult.PASSED;
					} else {
						report.result("Missing LOAN SERVICE CHARGE");
						return ExecutionResult.FAILED;
					}
				} else {
					report.result("User is walkin");
					return ExecutionResult.PASSED;
				}
				
			} else {
				report.result("Missing CHARGES");
				return ExecutionResult.FAILED;
			}
		}
		return null;
	}
}
