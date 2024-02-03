package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.UserPages;

public class BaseClass {
	protected WebDriver driver;
	protected PropertiesUtility property;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected ExcelUtility excel;
	protected LoginPage login;
	protected HomePage home;
	protected UserPages users;
	protected CourseListPage courseList;
	protected CategoryPage category;
	protected AddNewUserPage addUsers;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetUp() {
		web = new WebDriverUtility();
		jutil=new JavaUtility();
		property =new PropertiesUtility();
		excel=new ExcelUtility();
		property.propertiesInit(IconstantPath.PROPERTIES_FILE_PATH);
		driver = web.lauchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver=driver;
		sjutil=jutil;
		
	}
	@BeforeMethod
	public void methodSetUp() {
		login=new LoginPage(driver);
		home=new HomePage(driver);
		users=new UserPages(driver);
		courseList=new CourseListPage(driver);
		category=new CategoryPage(driver);
		addUsers=new AddNewUserPage(driver);
		addCourse=new AddNewCoursePage(driver);
		addCategory=new AddNewCategoryPage(driver);
		excel.excelInit(IconstantPath.EXCEL_PATH, "Sheet");
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "Login");
		login.loginToApp(property.readFromProperties("username"), 
				property.readFromProperties("password"));
		Assert.assertEquals(home. getPageHeader(),"Home");
	}
	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
	    home.singOutofApp();
	}
	@AfterClass
	public void classTearDown() {
		web.quitAllWindow();
	}
	
	
	

}
