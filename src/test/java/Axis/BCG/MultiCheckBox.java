package Axis.BCG;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiCheckBox {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

		driver.manage().window().maximize();

		List<WebElement> allcheck = driver.findElements(By.xpath("//input[@class='cb1-element']"));
		Thread.sleep(500);
		for (WebElement wb : allcheck) {
			wb.click();
		}

	}
}
