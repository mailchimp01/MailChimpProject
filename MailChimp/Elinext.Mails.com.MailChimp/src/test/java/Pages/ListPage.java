package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(linkText="Create List")
	WebElement btnCreateList;
	
	@FindBy(xpath="*//a[@class='new-list-button button p0']")
	WebElement btnCreateListConfirm;
	
	@FindBy(xpath=".//*[@id='dijit__FocusMixin_0']/li[3]/span")
	WebElement addSubscriber;
	
	@FindBy(linkText="Add a subscriber")
	WebElement addASubscriber;
	
	public ListPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, 30);
	}
	
	private void clickOnCreateList(){
		wait.until(ExpectedConditions.visibilityOf(btnCreateList));
		btnCreateList.click();
	}
	
	private void clickOnCreateListConfirm(){
		wait.until(ExpectedConditions.visibilityOf(btnCreateListConfirm));
		btnCreateListConfirm.click();
	}
	
	
	/**
	 * this function is used for clicking on button Create New List and click confirm to create new list.
	 */
	public void CreateNewList(){
		clickOnCreateList();
		clickOnCreateListConfirm();
	}
	
	/**
	 * this function is used for clicking on a list 
	 * @param ListName : name of list which will be selected.
	 */
	public void selectList(String ListName)
	{
		WebElement list = driver.findElement(By.linkText(ListName));
		list.click();
	}
	
	
	public void clickOnAddSubscriber(){
		addSubscriber.click();
	}
	
	public void clickOnAddASubScriber(){
		addASubscriber.click();
	}
	
	
	

}
