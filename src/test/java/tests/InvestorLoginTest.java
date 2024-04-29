package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import java.time.Duration;


public class InvestorLoginTest extends BaseTest{
	@Test
	public static void LoginAsInvestor() throws InterruptedException {


		
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
            
            Assert.assertEquals(h2Text, expectedText, "Text assertion failed");
            
        } catch (Exception e) {
            System.out.println("Validation Failed! Exception occurred: " + e.getMessage());
         // throw new RuntimeException("Validation Failed! Exception occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
