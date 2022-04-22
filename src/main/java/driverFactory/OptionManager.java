package driverFactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager 
{
	private ChromeOptions co;
	private EdgeOptions eo;
	private FirefoxOptions fo;
	private Properties prop;
	
	public OptionManager(Properties prop)
	{
		this.prop = prop;
	}
	
	public ChromeOptions chromeoptions()
	{
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		return co;	
	}
	
	public FirefoxOptions firefoxoptions()
	{
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		return fo;	
	}
	
	public EdgeOptions edgeoptions()
	{
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) eo.addArguments("--incognito");
		return eo;	
	}

}
