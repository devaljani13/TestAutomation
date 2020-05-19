package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("supeeerrrman2382@hotail.com");
		driver.findElement(By.id("pass")).sendKeys("pass1234");
		driver.findElement(By.id("loginbutton")).click();
		String actualErrMsg = driver.findElement(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div")).getText();
		String expectedErrMsg = ("The email you’ve entered doesn’t match any account. Sign up for an account.");
		if (actualErrMsg.contentEquals(expectedErrMsg)) {
			System.out.println("Test Case Passsed");
		}
		else {
			System.out.println("Tesy Case Failed");
		}
		driver.close();
				
	}

}
