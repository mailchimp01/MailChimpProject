package SubMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateListPage {
	WebDriver driver;
	WebDriverWait wait;
	
	// list name
	@FindBy(name="name")
	WebElement txtListName;
	
	//Default from email
	@FindBy(id="default-fromemail")
	WebElement txtDefaulFromEmail;
	
	//Default from name
	@FindBy(id="from_name")
	WebElement txtFromName;
	
	
	//Description
	@FindBy(id="description")
	WebElement txtDescription;
	
	// Daily summary
	@FindBy (id="email_daily")
	WebElement chkboxDailySummary;
	
	//One-by-One Subscribe
	@FindBy (id="email_subs")
	WebElement chkboxSubcriber;
	
	//One-by-One Unsubscribe
	@FindBy (id="email_unsubs")
	WebElement chkboxUnsubscriber;
	
	
	// Save button
	@FindBy(id="new-list-save")
	WebElement btnSave;
	
	// Banner message
	@FindBy(xpath=".//*[@id='av-flash-success']")
	WebElement txtMessageInfo;
	
	
	public CreateListPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, 30);
	}
	
	
	
	/**
	 * this function is used for inputting the list Name on the page create list
	 * @param listName : name of new list.
	 */
	private void inputListName(String listName){
		wait.until(ExpectedConditions.visibilityOf(txtListName));
		txtListName.sendKeys(listName);
	}
	
	
	/**
	 * this function is used for inputting default email from
	 * @param defaultFromEmail
	 */
	private void inputDefaultFromEmail(String defaultFromEmail){
		wait.until(ExpectedConditions.visibilityOf(txtDefaulFromEmail));
		txtDefaulFromEmail.sendKeys(defaultFromEmail);
	}
	
	/**
	 * this function is used for inputting from name text box
	 * @param fromName 
	 */
	private void inputFromName(String fromName){
		wait.until(ExpectedConditions.visibilityOf(txtFromName));
		txtFromName.sendKeys(fromName);
	}
	
	/**
	 * this function is used for inputting description 
	 * @param description : description about the new list
	 */
	private void inputDescription(String description){
		wait.until(ExpectedConditions.visibilityOf(txtDescription));
		txtDescription.sendKeys(description);
	}
	
	/**
	 * this function is used for select checkbox Daily summary
	 */
	private void checkOnCheckBoxDailySummary(){
		wait.until(ExpectedConditions.visibilityOf(chkboxDailySummary));
		chkboxDailySummary.click();
	}
	
	/**
	 * this function is used for selecting the checkbox One by One subscriber
	 */
	private void checkOnCheckBoxOneByOneSubscriber(){
		wait.until(ExpectedConditions.visibilityOf(chkboxSubcriber));
		chkboxSubcriber.click();
		
	}
	
	/**
	 * this function is used for selecting the checkbox One by One unsubscriber
	 */
	private void checkOnCheckBoxOneByOneUnSubscriber(){
		wait.until(ExpectedConditions.visibilityOf(chkboxUnsubscriber));
		chkboxUnsubscriber.click();
	}
	
	/**
	 * this function is used for clicking button Save to save list.
	 */
	private void SaveList(){
		wait.until(ExpectedConditions.visibilityOf(btnSave));
		btnSave.click();
	}
	
	
	/**
	 * this function is used for creating a new list 
	 * @param listName : the name of new list
	 * @param defaultFromEmail : email which is used for sending email (From)
	 * @param fromName : name will be displayed in the email
	 * @param description : description about new list.
	 */
	public void CreateList(String listName, String defaultFromEmail, String fromName, String description){
		inputListName(listName);
		inputDefaultFromEmail(defaultFromEmail);
		inputFromName(fromName);
		inputDescription(description);
		checkOnCheckBoxDailySummary();
		checkOnCheckBoxOneByOneSubscriber();
		checkOnCheckBoxOneByOneUnSubscriber();
		SaveList();
		
	}
	
	public boolean isListCreatedSuccessfully(){
		wait.until(ExpectedConditions.visibilityOf(txtMessageInfo));
		String message=txtMessageInfo.getText();
		return message.equals("Excellent! You have a brand new list.");
		
	}
	

}
