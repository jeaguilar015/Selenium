package actions.aca;

import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import pages.aca.Create;

@Test(name = "ACA - Create (CODED)")
public class CreateActions implements WebTest {

	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		TestReporter report = helper.getReporter();
		
		Create createACA = PageFactory.initElements(driver, Create.class);
		
		if (createACA.ACAheader_isDisplay()) {
			
			createACA.clickNext();
			
			if (createACA.ACAheader_isDisplay()) {
				report.result("[CREATE] Test Amount - field required validation is passed.");
				return ExecutionResult.PASSED;
			}
		}
		return ExecutionResult.FAILED;
	}

}
