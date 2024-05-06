package base;

import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	public void setUp() throws IOException{
		if(driver==null) {
			//FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
			FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			prop.load(fr);
		}
		
		if(prop.getProperty("browser").contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			 driver = new ChromeDriver(options);
			 driver.get(prop.getProperty("testurl"));
			 
		}else if(prop.getProperty("browser").contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}else if(prop.getProperty("browser").contentEquals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
		}
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
