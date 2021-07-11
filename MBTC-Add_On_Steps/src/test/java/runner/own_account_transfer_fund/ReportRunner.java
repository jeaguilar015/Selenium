package runner.own_account_transfer_fund;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import io.testproject.java.classes.DriverSettings;
import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.enums.DriverType;
import io.testproject.java.sdk.v2.Runner;

public class ReportRunner {

	private static Runner runner;
	
	@BeforeAll
	public static void setup() throws InstantiationException {
		runner = Runner.createWeb("XSVxixvxhPV-z_LP_u8lN3eFxBEPFhIMldMv_fX3Ln01", AutomatedBrowserType.Chrome);
	}
	
	ChromeOptions options = new ChromeOptions();
	DriverSettings driverSettings = new DriverSettings(DriverType.Chrome);
	options.setAcceptInsecureCerts(true);
	
	try(Runner runner = new Runner(devToken, driverSettings)) {
//		CreateMember createMember = new CreateMember();
		LoginCredential login = new LoginCredential();
		
		WebDriver driver = runner.getDriver(login);
		driver.navigate().to("https://pfs-proxy-psslai-pfs-dev.apps.ocp-dev.psslai.com/bo-login/");
		runner.run(login);
	
	
}
