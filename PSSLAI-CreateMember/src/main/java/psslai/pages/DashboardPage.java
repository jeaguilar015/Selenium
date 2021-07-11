package psslai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	@FindAll({
		@FindBy(xpath = "//*[@id='react-burger-menu-btn']")
	})
	WebElement openMenu;

	//	UI for Member Management
	@FindAll({
		@FindBy(xpath = "//*[text()='Membership']/parent::div[@class='newmenu_listitem']"),
		@FindBy(xpath = "//*[text()='Membership']")
	})
	WebElement membership;
	
	@FindAll({
		@FindBy(xpath = "//*[text()='Member Management']/parent::div[@class='newmenu_listitem']"),
		@FindBy(xpath = "//*[text()='Member Management']")
	})
	WebElement memberMngmnt;
	//	- - EO Member Management
	
	//	CTA
	@FindBy(xpath = "//*[contains(@class, 'psslai_navbar__logout')]")
	WebElement logoutBtn;
	
	public void navigateMenu() {
		openMenu.click();
	}
	
	public void navigateMembership() {
		membership.click();
	}
	
	public void navigateMemberManagment() {
		memberMngmnt.click();
	}
	
	public WebElement getMembership() {
		return membership;
	}
	
	public WebElement getMemberMngmnt() {
		return memberMngmnt;
	}
	
	public void logout() {
		logoutBtn.click();
	}
}
