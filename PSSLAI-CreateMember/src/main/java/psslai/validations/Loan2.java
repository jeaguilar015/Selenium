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

@Test(name = "Loan Validation Charges for SERVICE CHARGE - PNB CHARGE")
public class Loan2 implements WebTest {

	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
WebDriver driver = helper.getDriver();
		
		LoanValidationPage lvp = PageFactory.initElements(driver, LoanValidationPage.class);
		TestReporter report = helper.getReporter();
		
		if (lvp.atStep4()) {
			if (lvp.chargeIsDisplayed()) {
				if (lvp.getReleaseType().getText().contains("PNB ATM") || lvp.getReleaseType().getText().contains("PNB-OTC")) {
					
					if (lvp.releaseTypeCharge()) {
						report.result("User selected thru PNB ATM/PNB-OTC");
						return ExecutionResult.PASSED;
					} else {
						report.result("Missing Release type charges");
						return ExecutionResult.FAILED;
					}
				} else {
					report.result("User didn't select thru PNB");
					return ExecutionResult.PASSED;
				}
			} else {
				report.result("Missing CHARGES");
				return ExecutionResult.FAILED;
			}
		} else {
			report.result("User was not in step 4");
			return ExecutionResult.FAILED;
		}
	}

}
