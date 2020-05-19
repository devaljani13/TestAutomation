package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitlePage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - Log In or Sign Up";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Case Passed");
			
		}
		else {
			System.out.println("Test Case Failed");
		}
		driver.close();
		
	}

}
