package PageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerSubmitObjects {
	
	WebDriver driver3;
	public CareerSubmitObjects(WebDriver driver3)
	{
		PageFactory.initElements(driver3, this);
	}
	
	@FindBy(id="wt-cli-accept-all-btn")
	public WebElement acceptCookies;
	
	@FindBy(xpath="//header/nav[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")
	public 	WebElement careerMenu;

	@FindBy(xpath="//span[contains(text(),'Check our open positions')]")
	public 	WebElement checkPositionsButton;
	
	@FindBy(id="get_location")
	public 	WebElement jobLocation;
	
	@FindBy(xpath="//option[contains(text(),'Anywhere')]")
	public 	WebElement anywhereLocationOption;
	
	@FindBy(xpath="//h2[contains(text(),'Automation QA Engineer')]")
	public 	WebElement automationQAJob;
	
	
	@FindBy(className="entry-content")
	public 	WebElement jobEntryContent;
	
	@FindBy(className="joinus-content")
	public 	List <WebElement> joinUsContent;
	
	@FindBy(xpath="//h2[contains(text(),'General description')]")
	public 	WebElement jobGeneralDescription;
	
	@FindBy(xpath="//h2[contains(text(),'Requirements')]")
	public 	WebElement jobRequirements;
	
	@FindBy(xpath="//h2[contains(text(),'Responsibilities')]")
	public 	WebElement jobResponsibilities;
	
	@FindBy(xpath="//h2[contains(text(),'What we offer')]")
	public 	WebElement jobOffer;
	
	@FindBy(className="btn-apply")
	public 	WebElement applyButton;
		
	@FindBy(name="your-name")
	public 	WebElement yourNameInput;
	
	@FindBy(name="mobile-number")
	public 	WebElement mobileNumberInput;
	
	@FindBy(name="your-email")
	public 	WebElement yourEmailInput;
	
	@FindBy(name="uploadtextfield")
	public 	WebElement uploadIinput;
	
	@FindBy(name="linkedin")
	public 	WebElement linkedinInput;
	
	@FindBy(name="your-message")
	public 	WebElement yourMessageInput;
	
	@FindBy(id="adConsentChx")
	public WebElement agreementCheckbox;
	
	@FindBy(css="input[class='wpcf7-form-control has-spinner wpcf7-submit btn-cf-submit']")
	public 	WebElement submitButton;
	
	@FindBy(xpath="//div[contains(text(),'One or more fields have an error. Please check and')]")
	public 	WebElement errorsExistTitle;	
	
	@FindBy(className="close-form")
	public 	WebElement closeErrorForm;
	
	@FindBy(className="wpcf7-not-valid-tip")
	public 	List <WebElement> errorsList;	
	
	@FindBy(id="fancybox-close")
	public WebElement popupCloseButton;
}
