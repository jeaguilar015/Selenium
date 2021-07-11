package psslai.runner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

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
import psslai.pages.FamMemberPage;

@Test(name = "PSSLAI Loan - Validate Create member (Step 2)")
public class CreateMemberFamily implements WebTest {

	@Parameter(defaultValue = "GRANT")
	public String maidensName;
	
	@Parameter(defaultValue = "PRIMARY")
	public String familyId;
	
	@Parameter(defaultValue = "100000")
	public String basicPay;
	
	@Parameter(defaultValue = "5000")
	public String grossDeduc;	
	
	
	@Parameter(defaultValue = "100000")
	public String grossPay;
	
	@Parameter(defaultValue = "95000")
	public String netPay;
	
	@Parameter(defaultValue = "PGEN")
	public String rank;
	
	@Parameter(defaultValue = "ANY OTHER ID TYPE")
	public String idType;
	
	@Parameter(defaultValue = "1234567890")
	public String idNum;
	
	@Parameter(defaultValue = "111111111")
	public String tinNum;
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
		WebDriver driver = helper.getDriver();
		FamMemberPage familyPage = PageFactory.initElements(driver, FamMemberPage.class);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
			if (familyPage.isDisplayedFamilyInfo()) {
				familyPage.entermaidenName(maidensName);
				familyPage.enterFamilyId(familyId);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ familyId + "')])[last()]"))).click();
				
				familyPage.salaryInformation(basicPay, grossDeduc, grossPay, netPay);
				familyPage.selectRank(rank);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '"+ rank + "')])[last()]"))).click();
				
				familyPage.selectIdType(idType);
				try {
					Robot rb = new Robot();
					
					rb.keyPress(KeyEvent.VK_ENTER);
				} catch (AWTException ex) {
					ex.getMessage();
				}
				familyPage.employeeRecord(idNum, tinNum);
				
				familyPage.clickNext();
				
				return ExecutionResult.PASSED;
				} else {
					return ExecutionResult.FAILED;
				}
				
		}
		
}
		
		
