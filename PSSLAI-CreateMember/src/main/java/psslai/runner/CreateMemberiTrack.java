package psslai.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.iTrackPage;

@Test(name = "PSSLAI - Create member (Step 5)")
public class CreateMemberiTrack implements WebTest {

	@Parameter(defaultValue = "0631234567890")
	public String trckMobileNum;
	
	@Parameter(defaultValue = "CITY")
	public String question1;
	
	@Parameter(defaultValue = "FATHER BORN")
	public String question2;
	
	@Parameter(defaultValue = "MAIDEN NAME")
	public String question3;
	
	@Parameter(defaultValue = "CAVITE")
	public String answer1;
	
	@Parameter(defaultValue = "IMUS")
	public String answer2;
	
	@Parameter(defaultValue = "FERNANDO")
	public String answer3;
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		iTrackPage itp = PageFactory.initElements(driver, iTrackPage.class);
		
		if (itp.stepIsDisplayed()) {
			
			itp.enterMobileNum(trckMobileNum);
			//*[contains(text(), 'CITY')]
			// Select question & click the selected question
			itp.selectQuestion1(question1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ question1 + "')])[last()]"))).click();
			itp.enterAnswer1(answer1);
			
//			// Select question & click the selected question
			itp.selectQuestion2(question2);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ question2 + "')])[last()]"))).click();
			itp.enterAnswer2(answer2);
			
//			// Select question & click the selected question
			itp.selectQuestion3(question3);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ question3+ "')])[last()]"))).click();
			itp.enterAnswer3(answer3);
			itp.clickNext();
			return ExecutionResult.PASSED;
		} else {

			return ExecutionResult.FAILED;
		}
		
	}

}
