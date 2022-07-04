package Website.MusalaSoft;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ProfilePictureObjects;

public class ProfilePicture extends Base{

	@Test(priority=1)
	public void VerifyCompanyLink_TC() throws IOException, InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver2;
		ProfilePictureObjects pObject = new ProfilePictureObjects(driver2);

		//Accept cookies
		pObject.acceptCookies.click();

		//Open Company page	  
		js.executeScript("arguments[0].click();", pObject.companyMenu);
		Thread.sleep(4000);

		//Validate Company URL
		Assert.assertEquals(driver2.getCurrentUrl().toString(),"https://www.musala.com/company/", "Company URL is correct");
	}

	@Test(priority=2,dependsOnMethods = { "VerifyCompanyLink_TC" })
	public void VerifyLeadershipSection_TC() throws IOException, InterruptedException{

		ProfilePictureObjects pObject = new ProfilePictureObjects(driver2);

		//Validate Leadership section is displayed
		Assert.assertTrue(pObject.leadershipContent.isDisplayed()
				&& pObject.leadershipTitle.isDisplayed()
				&& pObject.companyprofileContainer.isDisplayed(), "Leadership Section is displayed");

	}

	@Test(priority=3,dependsOnMethods = { "VerifyCompanyLink_TC" })
	public void VerifyFacebookProfilePicture_TC() throws IOException, InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver2;
		WebElement subelement;
		ProfilePictureObjects pObject = new ProfilePictureObjects(driver2);

		//Scroll down to Facebook icon
		subelement= pObject.facebookIcon;                 
		js.executeScript("arguments[0].scrollIntoView();",subelement);

		pObject.facebookIcon.click();

		Thread.sleep(5000);

		//Validate Company URL
		pObject.pageBody.sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		ArrayList<String> tabs = new ArrayList<String>(driver2.getWindowHandles());
		driver2.switchTo().window(tabs.get(1));
		Assert.assertEquals(driver2.getCurrentUrl().toString(),"https://www.facebook.com/MusalaSoft?fref=ts", "Company URL is correct");


		//Validate Profile Picture
		Assert.assertTrue(pObject.musalaFacebookImage.isDisplayed());
		String imgURL = pObject.musalaFacebookImage.getAttribute("xlink:href").toString();

		URL url = new URL(imgURL);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();	    
		int responseCode = huc.getResponseCode();	    
		Assert.assertEquals(HttpURLConnection.HTTP_OK, responseCode,"Musala Facebook profile picture is valid and displayed");
	}

}

