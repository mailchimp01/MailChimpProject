package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	// text box username
	@FindBy(id="username")
	WebElement txtUserName;
	
	// text box password
	@FindBy(id="password")
	WebElement txtPassword;
	
	// button login
	@FindBy(xpath="*//button[@value='log in']")
	WebElement btnLogin;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, 30);
	}
	
	
	/**
	 * this function is used for inputting the username
	 * @param userName : username to login mailchimp
	 */
	private void InputUserName(String userName){
		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(userName);
	}
	
	/**
	 * this function is used for inputting the password
	 * @param password : password to login mailchimp
	 */
	private void InputPassword(String password){
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(password);
	}
	
	
	/**
	 * this function is used for clicking the log in button on the Login page.
	 */
	private void clickLoginButton(){
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}
	
	/**
	 * this function is used for login 
	 * @param userName : username to login
	 * @param password : password to login
	 */
	public void Login(String userName, String password){
		InputUserName(userName);
		InputPassword(password);
		clickLoginButton();
	}
	
	

}
