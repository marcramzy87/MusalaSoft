package Website.MusalaSoft;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CareerSubmitObjects;

public class CareerSubmit extends Base{

	@Test(priority=1)
	public void OpenCareersPage_TC() throws IOException, InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver3;
		CareerSubmitObjects sObject = new CareerSubmitObjects(driver3);

		//Accept cookies
		sObject.acceptCookies.click();

		//Open Careers page
		js.executeScript("arguments[0].click();",  sObject.careerMenu);
		Thread.sleep(4000);


	}    

	@Test(priority=2,dependsOnMethods = { "OpenCareersPage_TC" })
	public void VerifyJoinUsPage_TC() throws IOException, InterruptedException{

		CareerSubmitObjects sObject = new CareerSubmitObjects(driver3);

		//Check Opened Vacancies
		sObject.checkPositionsButton.click();

		//Validate Join Us page
		Assert.assertEquals(driver3.getCurrentUrl().toString(),"https://www.musala.com/careers/join-us/", "Join Us URL is correct");

	}    

	@Test(priority=3,dependsOnMethods = { "VerifyJoinUsPage_TC" })
	public void VerifyQAPosition_TC() throws IOException, InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver3;
		WebElement subelement;
		CareerSubmitObjects sObject = new CareerSubmitObjects(driver3);

		//Filter By Anywhere Location
		sObject.jobLocation.click();
		sObject.anywhereLocationOption.click();

		Assert.assertTrue(sObject.automationQAJob.isDisplayed(),"Experienced Automation QA Engineer is displayed");
		subelement = sObject.automationQAJob;
		js.executeScript("arguments[0].scrollIntoView();",subelement);
		js.executeScript("window.scrollBy(0,-200)");
		subelement.click();

		//Validate Experienced Automation QA Engineer job description content is displayed	   
		Assert.assertTrue(sObject.jobEntryContent.isDisplayed() && sObject.joinUsContent.size()==2,"Content Area is displayed");
		Assert.assertTrue(sObject.jobGeneralDescription.isDisplayed(),"General Description is displayed");
		Assert.assertTrue(sObject.jobRequirements.isDisplayed(),"Requirements is displayed");
		Assert.assertTrue(sObject.jobResponsibilities.isDisplayed(),"Responsibilities is displayed");
		Assert.assertTrue(sObject.jobOffer.isDisplayed(),"What we offer is displayed");

	} 

	@Test(priority=4,dependsOnMethods = { "VerifyQAPosition_TC" })
	public void VerifyCareerApplyForm_TC() throws IOException, InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver3;
		WebElement subelement;
		WebElement uploadElement;
		List <WebElement> Items;
		CareerSubmitObjects sObject = new CareerSubmitObjects(driver3);

		//Apply Button
		subelement = sObject.applyButton;
		Assert.assertTrue(subelement.isDisplayed(),"Apply Button is not displayed");
		js.executeScript("arguments[0].scrollIntoView();",subelement);
		subelement.click();


		//Load Test Data from Excel file
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.xlsx"); 
		FileInputStream inputStream = new FileInputStream(file);      

		XSSFWorkbook wb=new XSSFWorkbook(inputStream);      
		XSSFSheet sheet=wb.getSheet("JobData");     


		uploadElement = sObject.uploadIinput;
		//Upload File
		uploadElement.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Test_CV.pdf");

		for(int i=0; i<3;i++)
		{ 
			//Fill Form
			if(sheet.getRow(1).getCell(i, MissingCellPolicy.RETURN_BLANK_AS_NULL)!=null)			
			{
				sObject.yourNameInput.sendKeys(sheet.getRow(1).getCell(i).getStringCellValue());
			}
			if(sheet.getRow(2).getCell(i, MissingCellPolicy.RETURN_BLANK_AS_NULL)!=null)
			{
				sObject.yourEmailInput.sendKeys(sheet.getRow(2).getCell(i).getStringCellValue());
			}
			if(sheet.getRow(3).getCell(i, MissingCellPolicy.RETURN_BLANK_AS_NULL)!=null)
			{
				sObject.mobileNumberInput.sendKeys(sheet.getRow(3).getCell(i).getStringCellValue());
			}
			if(sheet.getRow(4).getCell(i, MissingCellPolicy.RETURN_BLANK_AS_NULL)!=null)
			{
				sObject.linkedinInput.sendKeys(sheet.getRow(4).getCell(i).getStringCellValue());
			}
			if(sheet.getRow(5).getCell(i, MissingCellPolicy.RETURN_BLANK_AS_NULL)!=null)
			{
				sObject.yourMessageInput.sendKeys(sheet.getRow(5).getCell(i).getStringCellValue());
			}

			//Checkbox
			if(!sObject.agreementCheckbox.isSelected())
			{sObject.agreementCheckbox.click();}
			js.executeScript("arguments[0].scrollIntoView();",sObject.submitButton);
			sObject.submitButton.click();
			Thread.sleep(5000);

			//Validate that there are field errors
			Assert.assertTrue(sObject.errorsExistTitle.isDisplayed(),"Field errors are displayed");

			js.executeScript("arguments[0].click();",  sObject.closeErrorForm);
			Thread.sleep(5000);
			System.out.println("Test Data "+ (i+1) +" Errors:");
			Items = sObject.errorsList;
			for(int j=0; j <sObject.errorsList.size();j++)
			{
				System.out.println(Items.get(j).getText().toString());
			}
			System.out.println("............................");

			//Clear Inputs
			sObject.yourNameInput.clear();
			sObject.yourEmailInput.clear();
			sObject.mobileNumberInput.clear();
			sObject.linkedinInput.clear();
			sObject.yourMessageInput.clear();

		}
		sObject.popupCloseButton.click();
	} 
}

