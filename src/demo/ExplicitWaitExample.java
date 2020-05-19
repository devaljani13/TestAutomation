package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Example 1")).click();
		driver.findElement(By.cssSelector("#start > button")).click();
		//WebDriverWait wait = new WebDriverWait (driver,20);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).
				pollingEvery(Duration.ofSeconds(2)).
				ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(("#finish > h4"))));
		String actualText = driver.findElement(By.cssSelector("#finish > h4")).getText();
		String expectedText = "Hello World!";
		
		if (actualText .equals (expectedText)){
			System.out.println("Test Case Passed");
			
		}
		else {
			System.out.println("Test Case Failed");
		}
		driver.close();
		
		
			
		
	}

}
