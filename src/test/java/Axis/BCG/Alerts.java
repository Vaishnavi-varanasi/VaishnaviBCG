package Axis.BCG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		
		driver.manage().window().maximize();
		
		WebElement InfoAlert = driver.findElement(By.xpath("//input[@name='alert']"));
		
		InfoAlert.click();
		Thread.sleep(500);
		Alert alt1 = driver.switchTo().alert();
		alt1.accept();
		
		WebElement ConfirmAlt = driver.findElement(By.xpath("//input[@name='confirmation']"));
		ConfirmAlt.click();
		Thread.sleep(500);
		Alert alt2 = driver.switchTo().alert();
		alt2.dismiss();
		
		WebElement PromptAlt = driver.findElement(By.xpath("//input[@name='prompt']"));
		PromptAlt.click();
		Thread.sleep(500);
		Alert alt3 = driver.switchTo().alert();
		alt3.accept();
	}
}
