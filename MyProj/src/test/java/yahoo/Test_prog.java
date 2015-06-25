package yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_prog 
{
    WebDriver driver;
	@Test
	@Parameters({"browser"})  // read the paremeter tag --name variable from xml file
	public void testing(String br) throws Exception
	{
		if(br.matches("firefox"))
			driver=new FirefoxDriver();
		if(br.matches("ie"))
			driver=new InternetExplorerDriver();	
		
		Home hm=new Home(driver);
		hm.validate_links();
		hm.createacc();
		hm.login();
		
		Compose cm=new Compose(driver);
		cm.sendmail();
		cm.signout();
	}
}
