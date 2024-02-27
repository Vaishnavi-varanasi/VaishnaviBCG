package Axis.BCG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollEg {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// vertical down scroll (x and y coordinates)

		js.executeScript("window.scrollBy(0 , 800)", "");

		// vertical up scroll (x and y coordinates)
		js.executeScript("window.scrollBy(0 , -400)", "");

		Thread.sleep(500);
		// resizing of the window
		// horizontal down scroll (x and y coordinates)
		js.executeScript("window.scrollBy(200 , 0)", "");

		// vertical up scroll (x and y coordinates)
		js.executeScript("window.scrollBy(-300 , 0)", "");

		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Meta © 2024')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

	}
}