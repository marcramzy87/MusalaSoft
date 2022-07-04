package Website.MusalaSoft;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import PageObjects.ContactUsObjects;

public class ContactUs extends Base{
			
   @Test(priority=1)
   public void OpenContactUsForm_TC() throws IOException, InterruptedException{
       
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		WebElement subelement;
		ContactUsObjects cObject = new ContactUsObjects(driver1);
		
		//Accept cookies
		cObject.acceptCookies.click();
		
		//Scroll to Contact Us button
		subelement= cObject.contactButton;                 
		js.executeScript("arguments[0].scrollIntoView();",subelement);

		//Open Contact Form
		subelement.click();
	} 
   
   @Test(priority=2,dependsOnMethods = { "OpenContactUsForm_TC" })   
   public void VerifyContactForm_TC() throws IOException, InterruptedException{
       
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		ContactUsObjects cObject = new ContactUsObjects(driver1);
					
		//Load Excel File
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.xlsx"); 
		FileInputStream inputStream = new FileInputStream(file);      
		
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);      
		XSSFSheet sheet=wb.getSheet("Emails");     
		
		//Fill Form
		cObject.yourNameInput.sendKeys(sheet.getRow(0).getCell(0).getStringCellValue());
		cObject.mobileNumberInput.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		cObject.yourSubjectInput.sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		cObject.yourMessageInput.sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		
		//Verifying 5 emails are invalid.       
	    for(int i=1; i<5;i++)
		{ 	
	    	cObject.yourEmailInput.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());		    
		    cObject.sendButton.click();
		    Thread.sleep(5000);
		    Assert.assertTrue(cObject.emailError.isDisplayed(),"Email error is displayed for invalid email format: "+ sheet.getRow(i).getCell(1).getStringCellValue());
		    cObject.yourEmailInput.clear();
		}	
	} 
}

