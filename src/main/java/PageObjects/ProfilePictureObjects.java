package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePictureObjects {
	
	WebDriver driver2;
	public ProfilePictureObjects(WebDriver driver2)
	{
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(id="wt-cli-accept-all-btn")
	public WebElement acceptCookies;
	
	@FindBy(xpath="//header/nav[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	public 	WebElement companyMenu;

	@FindBy(className="cm-content")
	public 	WebElement leadershipContent;

	@FindBy(xpath="//h2[contains(text(),'Leadership')]")
	public 	WebElement leadershipTitle;
	
	@FindBy(className="company-container")
	public 	WebElement companyprofileContainer;
	
	@FindBy(className="musala-icon-facebook")
	public 	WebElement facebookIcon;

	@FindBy(css="Body")
	public 	WebElement pageBody;
	
	@FindBy(css="svg.pzggbiyp g > image")
	public 	WebElement musalaFacebookImage;
	
}
