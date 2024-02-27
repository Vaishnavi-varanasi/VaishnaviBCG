package Axis.BCG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class KeyBoardEvents {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/login/");

		driver.manage().window().maximize();

		Thread.sleep(500);

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));

		Actions builder = new Actions(driver);

		// action class to be used when we need to do series of actions together.

		Action seriesofact = builder.moveToElement(email).click().keyDown(email, Keys.SHIFT).sendKeys(email, "VAISHNAVI").build();

		seriesofact.perform();

	}

}
