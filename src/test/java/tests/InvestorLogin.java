package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvestorLogin {
	@Test
	public static void LoginAsInvestor() throws InterruptedException {
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
		System.out.println("Logged in");
		
		try {
       
            WebElement firstH2 = driver.findElement(By.tagName("h2"));

            String h2Text = firstH2.getText();

            String expectedText = "How can we help with your\r\n"
            		+ "Wealth Growth?";
            if (h2Text.equals(expectedText)) {
                System.out.println("Validation Successful! The text of the first h2 tag matches the expected text.");
            } else {
                System.out.println("Validation Failed! Actual text '" + h2Text + "' does not match expected text '" + expectedText + "'.");
            }

        } catch (Exception e) {
            System.out.println("Validation Failed! Exception occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
