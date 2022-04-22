package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utility.elementUtils;

public class loginPage 
{
	private WebDriver driver;
	private elementUtils eUtils;
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		eUtils = new elementUtils(driver);
	}
	
	private By emailAddress = By.xpath("//*[@id='email']");
	private By emailAddressForm = By.xpath("//*[@id='email']/..");
	
	public String validateLoginPageTitle()
	{
		return eUtils.doGetPageTitle();
	}
	
	public String enterEmailAddress(String emailAddress) throws InterruptedException
	{
		//eUtils.doSendKeys(this.emailAddress, emailAddress);
		driver.findElement(this.emailAddress).sendKeys(emailAddress, Keys.TAB);
		Thread.sleep(1000);
		System.out.println("Attribute value is"+ eUtils.getElementAttribute(emailAddressForm, "class"));
		return eUtils.getElementAttribute(emailAddressForm, "class");
	}
	
	public void validateEmailAddressField(String status)
	{	
		
		status=  eUtils.getElementAttribute(emailAddressForm, "color");
	
		System.out.println(status);
		if(status.contains("form-ok"))
		{
			System.out.println("Entered Email Address format is correct");
			
		}
		else
		{
			System.out.println("Entered Email Address format is not correct");
			
		}
	}
}

