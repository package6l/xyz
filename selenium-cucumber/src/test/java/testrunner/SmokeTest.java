package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	WebDriver driver;
@Given("open browser")
public void open_browser()
{ System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURYA\\PracticeProject\\Practice\\Drivers\\chromedriver.exe");
  driver =new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://www.google.com/gmail/");

}
@When("e")
public void enter_valid_username_and_password() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("identifierId")).sendKeys("abhisheksharma181993");
	Thread.sleep(3000);
	driver.findElement(By.id("identifierNext")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys("Abhi1234");
	Thread.sleep(3000);
	driver.findElement(By.id("passwordNext")).click();
}

@Then("^user should be able to login$")
public void user_should_be_able_to_login() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	
	
	Thread.sleep(3000);
	String title = driver.getTitle();
	if(title.contains("Inbox"))
	{
		Actions action =new Actions(driver);
		WebElement target = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/a"));
		//WebElement	target1 =driver.findElement(By.xpath("//a[@href=\"https://accounts.google.com/Logout?hl=en&continue=https://mail.google.com/mail&service=mail&timeStmp=1522527655&secTok=.AG5fkS8AMl9GwMHraV59hrkhHlXFMOHWlg\"]"));
		Action signout =action
				.moveToElement(target)
				.click()
				.build();
		signout.perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@href="https://accounts.google.com/Logout?hl=en&continue=https://mail.google.com/mail&service=mail&timeStmp=1522527655&secTok=.AG5fkS8AMl9GwMHraV59hrkhHlXFMOHWlg"]").click();
		//driver.findElement(By.linkText("Privacy")).click();
		WebElement	target1 =driver.findElement(By.xpath("//*[@id=\"gb_71\"]"));
		
	target1.click();
		driver.close();
		
}



}
}
