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
import SubMenu.CreateListPage;

public class TestCreateList {
	
	WebDriver driver;
	HomePage homeObject;
	LoginPage loginObjec;
	MainMenuPage mainMenuObject;
	ListPage listObject;
	CreateListPage createListObject;
	public static String mailChimpUrl="http://www.mailchimp.com";
	
	@BeforeTest
	public void setUp(){
		driver= new FirefoxDriver();
		homeObject= new HomePage(driver);
		loginObjec= new LoginPage(driver);
		mainMenuObject= new MainMenuPage(driver);
		listObject= new ListPage(driver);
		createListObject = new CreateListPage(driver);
		homeObject.goToMailChimpHomePage(mailChimpUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void LoginToMailChimp(){
		homeObject.clickLoginButton();
		loginObjec.Login("dinhNguyen89", "Amdocs@263");
	}
	
	@Test
	public void Testloginsuccesfully(){
		mainMenuObject.selectListMenu();
		listObject.CreateNewList();
		createListObject.CreateList("testing demo 7", "dinh.nguyenminh@elinext.com", "DinhN", "Testing demo");
		Assert.assertTrue(createListObject.isListCreatedSuccessfully());
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
	
	
}
