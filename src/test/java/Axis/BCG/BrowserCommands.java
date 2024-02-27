package Axis.BCG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		
		//get URL
		driver.get("https://automationexercise.com/");
		
		//get page title
		String title = driver.getTitle();
		System.out.println(title);
		
		// get currentURL
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		// get Source Code
		String sourcecode = driver.getPageSource();
		System.out.println(sourcecode);
		
		driver.close();

	}

}
