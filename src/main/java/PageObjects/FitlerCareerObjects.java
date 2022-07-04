package PageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitlerCareerObjects {
	
	WebDriver driver4;
	public FitlerCareerObjects(WebDriver driver4)
	{
		PageFactory.initElements(driver4, this);
	}
	
	@FindBy(id="wt-cli-accept-all-btn")
	public WebElement acceptCookies;
	
	@FindBy(xpath="//header/nav[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")
	public 	WebElement careerMenu;

	@FindBy(xpath="//span[contains(text(),'Check our open positions')]")
	public 	WebElement checkPositionsButton;

	@FindBy(id="get_location")
	public 	WebElement jobLocation;
	
	@FindBy(xpath="//option[contains(text(),'Sofia')]")
	public 	WebElement sofiaLocationOption;
	
	@FindBy(xpath="//option[contains(text(),'Skopje')]")
	public 	WebElement skopjeLocationOption;
	
	@FindBy(className="card-jobsHot")
	public 	List <WebElement> jobCards;
	
	@FindBy(className="card-container")
	public 	List <WebElement> cardContainers;
	
	@FindBy(className="card-jobsHot__title")
	public 	List <WebElement> jobTitles;
	
	@FindBy(className="card-jobsHot__link")
	public 	List <WebElement> jobLinks;
		
}
