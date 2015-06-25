package yahoo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Home
{
	WebDriver driver;
	
	public Home(WebDriver driver)
	{
	  this.driver=driver;	
	}
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
	}
	public void validate_links()
	{
		open();
	//	Reporter.log(((FirefoxDriver)driver).getCapabilities().getBrowserName()+"    "+((FirefoxDriver)driver).getCapabilities().getPlatform());
		
		String links[]={"About Mail","Features","Get App","Help"};
		//find parent element having the above links and find all links in that
		WebElement w=driver.findElement(By.xpath("//*[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
		List<WebElement> lst=w.findElements(By.tagName("a"));
		for(int i=0;i<4;i++)
		{
			//compare each link in the list with each link in the array
			if(lst.get(i).getText().matches(links[i]))
			{
				Reporter.log("<font color='green'><b>link is matching</b></font>"+links[i]);
			}
			else
			{
				Reporter.log("<font color='red'><b>link is not  matching</b></font>"+links[i]);
			}
		}		
	}
	public void login() throws Exception
	{
		open();		
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		if(driver.findElement(By.linkText("Sign Out")).isDisplayed())
		{
			Reporter.log("<font color='green'><b>Login is success</b></font>");			
		}
	}
	public void createacc() throws Exception
	{
		open();
		driver.findElement(By.id("login-signup")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("first-name")).sendKeys("abcd");
				
		driver.findElement(By.xpath("//*[@class='country-code-arrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-code='91']")).click();
		driver.findElement(By.id("mobile")).sendKeys("9898989898");
		
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("July");
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1984");
		
		driver.findElement(By.id("male")).click();		
	}
}
