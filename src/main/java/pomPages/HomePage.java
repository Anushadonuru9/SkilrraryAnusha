package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[text()=' Home']")
	private WebElement pageHeader;
	@FindBy(xpath="//span[text()='Users']")
	private WebElement usersTab;
	@FindBy(xpath="//a[text()=' Course List']")
	private WebElement courseListLink;
	@FindBy(xpath="//a[text()=' Category']")
	private WebElement categoryLink;
	@FindBy(xpath="//span[text()='SkillRary Admin']")
	private WebElement skillraryAdminIcon;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutLink;
	
	//initialization
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickUsersTab() {
		usersTab.click();
	}
	public void clickCourseListLink() {
		courseListLink.click();
	}
	public void singOutofApp() {
		skillraryAdminIcon.click();
		signoutLink.click();
	}

}
