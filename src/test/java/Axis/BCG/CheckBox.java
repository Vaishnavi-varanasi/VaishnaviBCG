package Axis.BCG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type= 'checkbox'])[2]"));
		Thread.sleep(500);
		if (checkbox2.isEnabled()) {

			checkbox2.click();
		}
		
		WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type= 'checkbox'])[1]"));
		Thread.sleep(500);
		if (checkbox1.isEnabled()) {

			checkbox1.click();
		}
	}
}