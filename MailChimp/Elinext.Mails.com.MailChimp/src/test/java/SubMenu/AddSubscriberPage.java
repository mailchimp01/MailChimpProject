package SubMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSubscriberPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id="MERGE0")
	WebElement email;
	
	@FindBy(id="MERGE1")
	WebElement firstName;
	
	@FindBy(id="MERGE2")
	WebElement lastName;
	
	
	@FindBy(id="optin-confirm")
	WebElement chkboxPermission;
	
	@FindBy(id="update-existing")
	WebElement chkboxUpdateExisting;
	
	
	@FindBy(xpath=".//input[@value='subscribe']")
	WebElement btnSubscriber;
	
	@FindBy(xpath=".//*[@id='av-flash-success']")
	WebElement txtMessage;
	
	public AddSubscriberPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, 30);
	}
	
	/**
	 * function is used for inputting the email.
	 * @param pemail : email of user
	 */
	private void inputEmail(String pemail){
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(pemail);
	}
	
	/**
	 * function is used for inputting the firstname
	 * @param pfirstName : first name of user
	 */
	private void inputFirstName(String pfirstName){
		wait.until(ExpectedConditions.visibilityOf(email));
		firstName.sendKeys(pfirstName);
	}
	
	
	/**
	 * function is used for inputting the lastname
	 * @param plastName : lastname of user.
	 */
	private void inputLastName(String plastName ){
		wait.until(ExpectedConditions.visibilityOf(email));
		lastName.sendKeys(plastName);
	}
	
	
	/** 
	 * this function is used for selecting the checkbox "Permission to gave to email them"
	 */
	private void checkOnCheckBoxPermission(){
		wait.until(ExpectedConditions.visibilityOf(chkboxPermission));
		chkboxPermission.click();
	}
	
	
	/**
	 * this function is used for selecting the checkbox "Update existing"
	 */
	private void checkOnCheckBoxUpdateExisting(){
		wait.until(ExpectedConditions.visibilityOf(chkboxPermission));
		chkboxUpdateExisting.click();
	}
	
	/**
	 * this function is used for clicking the subscriber button
	 */
	private void clickOnSubscriberButton(){
		wait.until(ExpectedConditions.visibilityOf(btnSubscriber));
		btnSubscriber.click();
	}
	
	/**
	 * this funciton is used for adding a subscriber to a list
	 * @param email : email of subscriber
	 * @param firstname : first name of subscriber
	 * @param lastname : last name of subscriber
	 */
	public void addSubscriberToList(String email, String firstname, String lastname){
		inputEmail(email);
		inputFirstName(firstname);
		inputLastName(lastname);
		checkOnCheckBoxPermission();
		checkOnCheckBoxUpdateExisting();
		clickOnSubscriberButton();
	}
	
	public boolean isAddSubscriberSuccessfully(){
		wait.until(ExpectedConditions.visibilityOf(txtMessage));
		String messageInfo=txtMessage.getText();
		return messageInfo.toLowerCase().contains("was successfully added to your list");
	}
	
	
	
}
