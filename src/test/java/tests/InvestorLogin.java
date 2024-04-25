package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvestorLogin {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://uat-investor.pickright.co.in/login");
		
		//driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-trading-on-boarding-dialog/div/div[1]/div[2]/div[1]/a)")).click();
		
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("9365214785");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary width-100-pr'][@type='submit']")).click();
		Duration timeout = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		
		
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large width-100-pr mb-15 btn-large-md']")).click();
		
	}

}
