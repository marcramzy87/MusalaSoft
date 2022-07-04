package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsObjects {
	
	WebDriver driver1;
	public ContactUsObjects(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy(id="wt-cli-accept-all-btn")
	public WebElement acceptCookies;
	
	@FindBy(className="contact-label")
	public 	WebElement contactButton;

	@FindBy(name="your-name")
	public 	WebElement yourNameInput;

	@FindBy(name="mobile-number")
	public 	WebElement mobileNumberInput;
	
	@FindBy(name="your-email")
	public 	WebElement yourEmailInput;
	
	@FindBy(name="your-subject")
	public 	WebElement yourSubjectInput;
	
	@FindBy(name="your-message")
	public 	WebElement yourMessageInput;
	
	@FindBy(css="input[class='wpcf7-form-control has-spinner wpcf7-submit btn-cf-submit']")
	public 	WebElement sendButton;
	
	@FindBy(xpath="//span[contains(text(),'The e-mail address entered is invalid.')]")
	public 	WebElement emailError;	
}
