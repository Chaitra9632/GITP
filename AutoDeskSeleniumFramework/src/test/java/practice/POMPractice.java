package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutiltiy.FileUtiity;
import com.crm.autodesk.genericutiltiy.WebDriverUtility;

public class POMPractice {
	
	public static void main(String[] args) throws Throwable {
		
		FileUtiity fLib = new FileUtiity();
        WebDriverUtility wLib = new WebDriverUtility();
        
        /*read the data required*/
		String URL = fLib.getProPertyKeyValue("url");
		String BROWSER = fLib.getProPertyKeyValue("browser");
		String USERNAME = fLib.getProPertyKeyValue("username");
		String PASSWORD=fLib.getProPertyKeyValue("password");
		
		/*Launch the browser*/
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid Browser name");
		}
		wLib.waitForPageToLoad(driver);
	    driver.manage().window().maximize();
		driver.get(URL);
		
		/*login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		/*navigate to organizations page*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		/*logout*/
		hp.logout(driver);
	}

}

