package psslai.runner;

import org.openqa.selenium.WebElement;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.DocsPage;

@Test(name = "PSSLAI - Validate Create Member (Step 6)")
public class CreateMemberDocs implements WebTest {
	
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\Emmanuel\\Downloads\\EmmanuelA_Laptop.pdf";
		
		WebDriver driver = helper.getDriver();
		DocsPage docsPage = PageFactory.initElements(driver, DocsPage.class);
		
		if (docsPage.stepsIsDisplayed()) {
			docsPage.clickUploadLink();
			
		}
		
		return null;
	}

}
