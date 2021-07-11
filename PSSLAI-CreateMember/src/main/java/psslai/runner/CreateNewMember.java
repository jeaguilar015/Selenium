package psslai.runner;

import java.util.concurrent.TimeUnit;

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
import psslai.pages.CreatePage;

@Test(name = "PSSLAI New member application - Validate Createm Member (Step 1)")
public class CreateNewMember implements WebTest {
	
	@Parameter(defaultValue = "HEAD OFFICE BRANCH")
	public String placeCode;
	
	@Parameter(defaultValue = "REGULAR")
	public String memberType;
	
	@Parameter(defaultValue = "PNPAC")
	public String subType;
	
	@Parameter(defaultValue = "GRANT")
	public String lastname;
	
	@Parameter(defaultValue = "SAMANTHA")
	public String firstname;
	
	@Parameter(defaultValue = "CRUZ")
	public String middlename;
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		CreatePage createPage = PageFactory.initElements(driver, CreatePage.class);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TestReporter report = helper.getReporter();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		if (driver.getCurrentUrl().contains("bo-general/addMember")) {
			
			// Select Place Code
			createPage.enterPlaceCode(placeCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '" + placeCode + "')])[last()]"))).click();

			// Enter Member Type
			createPage.enterMemberType(memberType);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ memberType + "')])[last()]"))).click();
			
			// Enter SubType
			createPage.enterSubType(subType);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ subType + "')])[last()]"))).click();
			
			if (createPage.basicInfoIsDisplayed()) {
				createPage.enterUniqueVal(Math.random());
				
				createPage.personalInfo(lastname, firstname, middlename);
				
				report.step("Step 1: PASSED, user may now proceed to Step 2");
				return ExecutionResult.PASSED;
			} else {
				report.result("MISSING BASIC INFORMATION FIELDS");
				return ExecutionResult.FAILED;
			}
			
			
		} else {
			report.result("USER WAS NOT ON CREATE MEMBER");
			return ExecutionResult.FAILED;
		}
		
	}
}
