package psslai.utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import psslai.utility.*;

public class CommonMethod {

	
	public static void clickElements(By locator, WebTestHelper helper) throws Exception {
		List <WebElement> genericElement;
		int counter = 0;
		
		do {
			genericElement = helper.getDriver().findElements(locator);
			try {
				genericElement.get(0).click();
			} catch(Exception e) {
				
			}
			counter++;
			TimeUnit.SECONDS.sleep(1);
		} while (genericElement.size() < 1 && counter <= ConstantsVariable.maxWait);
		
		if (genericElement.size() < 1) {
			throw new Exception("Element not found: " + locator.toString());
		}
	}
}
