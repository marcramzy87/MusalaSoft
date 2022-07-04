package Website.MusalaSoft;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.FitlerCareerObjects;

public class FilterCareers extends Base{

	@Test(priority=1)
	public void OpenCareersPage_TC() throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver4;
		FitlerCareerObjects fOjbect = new FitlerCareerObjects(driver4);

		//Accept cookies
		fOjbect.acceptCookies.click();

		//Open Careers page
		js.executeScript("arguments[0].click();", fOjbect.careerMenu);
		Thread.sleep(4000);

		//Check Opened Vacancies
		fOjbect.checkPositionsButton.click();

	}

	@Test(priority=2,dependsOnMethods = { "OpenCareersPage_TC" })
	public void FilterCareersByLocation() throws InterruptedException{

		List<WebElement> jobsTitles = null;
		List<WebElement> jobsURLs = null;
		FitlerCareerObjects fOjbect = new FitlerCareerObjects(driver4);

		//Filter By Sofia Location
		fOjbect.jobLocation.click();
		fOjbect.sofiaLocationOption.click();

		//Check if there are jobs at Sofia location	   
		try {
			Assert.assertTrue(fOjbect.cardContainers.size()>0 && fOjbect.jobCards.size()>0,"There are available jobs in Sofia");
			jobsTitles= fOjbect.jobTitles;
			jobsURLs= fOjbect.jobLinks;
			System.out.println("Sofia"+"\n");
			for(int i=0; i<jobsTitles.size(); i++)
			{
				System.out.println("Position: "+jobsTitles.get(i).getText().toString());
				System.out.println("More Info: "+jobsURLs.get(i).getAttribute("href").toString());
				System.out.println();
			}

			System.out.println("………………………………………………………………"+"\n");
		}
		catch(Exception e) {
			System.out.println("No Jobs at Sofia location");
		}

		//Filter By Skopje Location
		fOjbect.jobLocation.click();
		fOjbect.skopjeLocationOption.click();

		//Check if there are jobs at Skopje location
		try {
			Assert.assertTrue(fOjbect.cardContainers.size()>0 && fOjbect.jobCards.size()>0,"There are available jobs in Skopje");
			jobsTitles= fOjbect.jobTitles;
			jobsURLs= fOjbect.jobLinks;
			System.out.println("Skopje"+"\n");
			for(int i=0; i<jobsTitles.size(); i++)
			{
				System.out.println("Position: "+jobsTitles.get(i).getText().toString());
				System.out.println("More Info: "+jobsURLs.get(i).getAttribute("href").toString());
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("No Jobs at Skopje location");
		}

	}

}

