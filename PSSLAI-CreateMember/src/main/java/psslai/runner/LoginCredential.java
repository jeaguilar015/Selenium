package psslai.runner;

import java.util.concurrent.TimeUnit;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.support.PageFactory;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.pages.LoginPage;

@Test(name = "PSSLAI Loan - Validate Login page")
public class LoginCredential implements WebTest{
	
	@Parameter(defaultValue = "JA1")
	private String username;
	
	@Parameter(defaultValue = "Passw0rd*")
	private String password;	
	
	@Override
	public ExecutionResult execute(WebTestHelper helper) throws FailureException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emmanuel\\Desktop\\Selenium\\artifacts\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--ignore-certificate-error");
//		ChromeDriver driver = new ChromeDriver(options);
		WebDriver driver = helper.getDriver();
		
		TestReporter report = helper.getReporter();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://pfs-proxy-psslai-pfs-dev.apps.ocp-dev.psslai.com/bo-login/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		if (loginPage.isDisplayed()) {
			
			loginPage.login(username, password);
			
			report.result("PSSLAI Loan- LOGIN: PASS");
			return ExecutionResult.PASSED;
			
		} else {
			report.result("PSSLAI Loan - LOGIN: FAIL");
			return ExecutionResult.FAILED;
		}
	}
}
