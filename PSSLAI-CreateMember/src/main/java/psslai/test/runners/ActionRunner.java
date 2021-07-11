package psslai.test.runners;

import org.openqa.selenium.chrome.ChromeOptions;

import io.testproject.java.classes.DriverSettings;
import io.testproject.java.enums.DriverType;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import psslai.runner.LoginCredential;

public class ActionRunner {
	private final static String devToken = "XSVxixvxhPV-z_LP_u8lN3eFxBEPFhIMldMv_fX3Ln01";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		ChromeOptions options = new ChromeOptions();
//		DriverSettings driverSettings = new DriverSettings(DriverType.Chrome);
//		options.setAcceptInsecureCerts(true);
//		
//		try(Runner runner = new Runner(devToken, driverSettings)) {
////			CreateMember createMember = new CreateMember();
//			LoginCredential login = new LoginCredential();
//			
//			WebDriver driver = runner.getDriver(login);
//			driver.navigate().to("https://pfs-proxy-psslai-pfs-dev.apps.ocp-dev.psslai.com/bo-login/");
//			runner.run(login);
//		}
	}

}
