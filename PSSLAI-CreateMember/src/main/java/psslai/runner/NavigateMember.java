package psslai.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.CreatePage;
import psslai.pages.DashboardPage;

@Test(name = "PSSLAI Loan - Navigate Member")
public class NavigateMember implements WebTest {

	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		
//		driver.manage().timeouts().setScriptTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TestReporter report = helper.getReporter();
		
		DashboardPage dbPage = PageFactory.initElements(driver, DashboardPage.class);
		CreatePage createPage = PageFactory.initElements(driver, CreatePage.class);
		
		if (driver.getCurrentUrl().contains("/bo-dashboard/")) {
			dbPage.navigateMenu();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbPage.navigateMembership();
			
			dbPage.navigateMemberManagment();
			
//			wait.until(ExpectedConditions.visibilityOfAllElements(createPage.getAddMember()));
			createPage.newMemberApplication();
			return ExecutionResult.PASSED;
			
		} else {
			report.result("PSSLAI Loan - Validation of Create Member: Not in URL");
			report.step("PSSLAI Loan - Validation of Create Member: Not in URL");
			return ExecutionResult.FAILED;
		}
		
	}

}
