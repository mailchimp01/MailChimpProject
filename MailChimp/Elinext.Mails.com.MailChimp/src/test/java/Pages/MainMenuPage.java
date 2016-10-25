package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuPage {
	WebDriver driver;
	WebDriverWait wait;
	
	//menu Lists
	@FindBy(linkText="Lists")
	WebElement menuList;
	
	public MainMenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, 30);
	}
	
	private void clickOnListMenu(){
		wait.until(ExpectedConditions.visibilityOf(menuList));
		menuList.click();
	}
	
	/**
	 * this function is used for selecting Lists menu at the Home Menu of User.
	 */
	public void selectListMenu(){
		clickOnListMenu();
	}
	
	
}
