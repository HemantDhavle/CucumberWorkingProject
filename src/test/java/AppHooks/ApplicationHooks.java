package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.driverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks 
{
	public Properties prop;
	public WebDriver driver;
	@Before
	public void setUp()
	{
		driverUtility driverU = new driverUtility();
		prop = driverU.init_prop();
		driver = driverU.init_driver(prop);
	}
	
	@After(order=1)
	public void takeScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] srcByte= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			String screenshotName = scenario.getName();
			scenario.attach(srcByte, "image/png", screenshotName);
		}
	}
	
	@After(order=0)
	public void tearDown()
	{
		driver.quit();
	}

}
