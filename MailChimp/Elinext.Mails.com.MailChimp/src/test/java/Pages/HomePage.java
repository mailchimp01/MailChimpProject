package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	// link log in 
	@FindBy(linkText="Log In")
	WebElement btnLogin;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, 30);
	}
	
	
	
	
	/**
	 * this function is used for clicking on the log in hyperlink at the home page
	 */
	public void clickLoginButton(){
		WaitUntilLoginReady();
		btnLogin.click();
	}
	
	/**
	 * this function is used for go to the mailchimp home page.
	 * @param url : is the address of mailchimp 
	 */
	public void goToMailChimpHomePage(String url){
		driver.get(url);
	}

	
	/**
	 * this function is used for waiting until the login is ready for clicking 
	 */
	private void WaitUntilLoginReady(){
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
	}
	
	
	
	
}
