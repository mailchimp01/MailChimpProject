package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ListPage;
import Pages.LoginPage;
import Pages.MainMenuPage;
import SubMenu.AddSubscriberPage;
import SubMenu.CreateListPage;

public class TestAddSubscriberToList {
	WebDriver driver;
	HomePage homeObj;
	LoginPage loginObj;
	MainMenuPage mainmenuObj;
	ListPage listObj;
	AddSubscriberPage addsubscriberOjb;
	public static String mailChimpUrl="http://www.mailchimp.com";
	
	@BeforeTest
	public void setUp(){
		driver= new FirefoxDriver();
		homeObj= new HomePage(driver);
		loginObj= new LoginPage(driver);
		mainmenuObj= new MainMenuPage(driver);
		listObj= new ListPage(driver);
		addsubscriberOjb = new AddSubscriberPage(driver);
		homeObj.goToMailChimpHomePage(mailChimpUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void loginToMailChimp(){
		homeObj.clickLoginButton();
		loginObj.Login("dinhNguyen89", "Amdocs@263");
		mainmenuObj.selectListMenu();
		listObj.selectList("testing demo 4");
		listObj.clickOnAddSubscriber();
		listObj.clickOnAddASubScriber();
	}
	
	@Test
	public void Testing(){
		addsubscriberOjb.addSubscriberToList("dinh02@gmail.com", "Dinh", "Nguyen");
		Assert.assertTrue(addsubscriberOjb.isAddSubscriberSuccessfully());
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}

}
