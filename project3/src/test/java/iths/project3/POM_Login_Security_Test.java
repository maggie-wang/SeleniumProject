package iths.project3;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Author: Yu Wang
 * Date: 2016-04-07
 * 
 * security test  --- attack testing
 * not logged in , input logged in page address, see if we can access it. 
 * if not, msg "you must be logged in.." should be shown.
*/
public class POM_Login_Security_Test {
	
	private WebDriver driver;
	String remindMsg = "You must be logged in to use this page. Please use the form below to login to your account.";
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@After
	public void testDown(){
		driver.quit();
	}
    
	// not logged in , go to the logged in page directly, see if we can access it.  
	//if not, msg "you must be logged in.." should be shown.

	@Test
	public void testLoginPageDirect(){
		
        driver.navigate().to("http://store.demoqa.com/products-page/your-account/?login=1");  
		driver.manage().window().maximize();       
        
        assertTrue(LoginPage.account_Login_Remind_Msg(driver).getText().contains(remindMsg));
	}

}         