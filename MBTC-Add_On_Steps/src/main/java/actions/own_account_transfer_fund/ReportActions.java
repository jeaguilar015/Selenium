package actions.own_account_transfer_fund;

import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import pages.own_account_transfer_fund.Reports;

@Test(name = "MBTC - Own Account Transfer Fund (Reports)")
public class ReportActions implements WebTest {

	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		TestReporter report = helper.getReporter();
		
		// PageFactory
		Reports settingsReport = PageFactory.initElements(driver, Reports.class);
		
		// Check if visible
		if(!settingsReport.isRefNumDisplay()) {
			
			report.result("Reference Number column header is NOT display");
			return ExecutionResult.FAILED;
			
		} else {
			
			report.result("Reference Number column header is display");
			return ExecutionResult.PASSED;
			
		}
	
	}}
