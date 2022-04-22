package driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverUtility 
{	
public WebDriver driver;
public Properties prop;
public static ThreadLocal<WebDriver> ltDriver= new ThreadLocal<WebDriver>();

public WebDriver init_driver(Properties prop)
{
	String browserName = prop.getProperty("browser");
	OptionManager om = new OptionManager(prop);
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		ltDriver.set(new ChromeDriver(om.chromeoptions()));
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		ltDriver.set(new FirefoxDriver(om.firefoxoptions()));
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		ltDriver.set(new EdgeDriver(om.edgeoptions()));
	}
	else
	{
		System.out.println("Please pass the correct browser");
	}
	
	getDriver().get(prop.getProperty("url"));
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().fullscreen();
	return getDriver();
}

public static synchronized WebDriver getDriver()
{
	return ltDriver.get();
}

public Properties init_prop()
{
	prop = new Properties();
	FileInputStream fs = null;
	String envName = System.getProperty("env");
	try
	{
	if(envName==null)
	{
		System.out.println("We are running on production environment");
		fs = new FileInputStream("./src/test/resources/config/prod_config.properties");
	}
	else 
	{
		switch (envName) {
		case "int":
		System.out.println("We are running on "+envName+" environment" );
		fs = new FileInputStream("./src/test/resources/config/int_config.properties");
			break;
		case "qa":
			System.out.println("We are running on "+envName+" environment" );
			fs = new FileInputStream("./src/test/resources/config/qa_config.properties");
			break;
		default:
			System.out.println("Please pass the correct environment name");
			break;
		}
	}
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try {
		prop.load(fs);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
}

}
