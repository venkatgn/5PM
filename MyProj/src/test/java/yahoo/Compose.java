package yahoo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compose 
{
	WebDriver driver;
	public Compose(WebDriver driver)
	{
		this.driver=driver;
	}
	public void sendmail() throws Exception
	{
		Thread.sleep(5000);
		System.out.println("sending mails");
		//click compose and enter details to, subj, body of mail and click send
		driver.findElement(By.xpath("//*[@class='composeicon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("to")).sendKeys("testing@gmail.com");
		driver.findElement(By.id("Subj")).sendKeys("hello");
		driver.findElement(By.name("Content")).sendKeys("This is sample mail for testing");
		driver.findElement(By.id("send_top")).click();
	}
	public void signout()
	{
		driver.findElement(By.linkText("Sign Out")).click();	
		driver.close();
	}
}
