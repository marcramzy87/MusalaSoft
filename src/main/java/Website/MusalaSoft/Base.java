package Website.MusalaSoft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {
	
	public static WebDriver driver1;
	public static WebDriver driver2;
	public static WebDriver driver3;
	public static WebDriver driver4;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException {
		
		//Call configuration file.
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Website\\MusalaSoft\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String baseURL=(String)prop.get("baseUrl");
		String browser=(String)prop.get("browser");
		
        if(browser.toLowerCase().contentEquals("chrome"))
        {
        	ChromeOptions cOptions = new ChromeOptions();  
			cOptions.addArguments("start-maximized");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver1 = new ChromeDriver(cOptions);
			driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver1.get(baseURL);
					
			driver2 = new ChromeDriver(cOptions);
			driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver2.get(baseURL);
			
			driver3 = new ChromeDriver(cOptions);
			driver3.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver3.get(baseURL);
			
			driver4 = new ChromeDriver(cOptions);
			driver4.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver4.get(baseURL);
        }       
        else if(browser.toLowerCase().contentEquals("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");  
        
        	driver1 = new FirefoxDriver();
    		driver1.manage().window().maximize();
    		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		driver1.get(baseURL);
    		
    		driver2 = new FirefoxDriver();
    		driver2.manage().window().maximize();
    		driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		driver2.get(baseURL);
    		
    		driver3 = new FirefoxDriver();
    		driver3.manage().window().maximize();
    		driver3.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		driver3.get(baseURL);
    		
    		driver4 = new FirefoxDriver();
    		driver4.manage().window().maximize();
    		driver4.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		driver4.get(baseURL);
        }
        else
        {
        	System.out.println("Invalid browser name entered");
        }
		
	  }
	
	  @AfterTest
	  public void afterTest() throws IOException {
		  
		System.out.println("Open test results report from here "+System.getProperty("user.dir")+"\\Reports\\Musalatestreport.html");
		driver1.close();
		driver2.close();
		driver3.close();
		driver4.get(System.getProperty("user.dir")+"\\Reports\\Musalatestreport.html");
		driver4.navigate().refresh();
		
	  }
}
