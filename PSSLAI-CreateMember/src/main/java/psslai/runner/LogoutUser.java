package psslai.runner;

import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.DashboardPage;

@Test(name = "PSSLAI Loan - Logout")
public class LogoutUser implements WebTest {

	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		
		DashboardPage dbPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dbPage.logout();
		return null;
	}
	
}
