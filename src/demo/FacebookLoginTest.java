package demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest {
	
	
	@Test
	public void testFacebookPageTitle() {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\IT TRAINING 2020\\chromedriver.exe");
		driver.get("https://www.facebook.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - Log In or Sign Up";

		assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	

	/**
	 * Test Facebook Invalid Login
	 */
	@Test
	
	public void testInvalidLogin() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("supeeerrrman2382@hotail.com");
		driver.findElement(By.id("pass")).sendKeys("pass12345");
		driver.findElement(By.id("loginbutton")).click();

		String actualErrMsg = driver
				.findElement(By.cssSelector(
						"#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div"))
				.getText();

		String expectedErrMsg = "The email you’ve entered doesn’t match any account. Sign up for an account.";

		assertEquals(expectedErrMsg, actualErrMsg);
		driver.close();

	}

	

}
