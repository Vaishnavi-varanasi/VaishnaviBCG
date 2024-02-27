package Axis.BCG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		
		driver.manage().window().maximize();
		
		WebElement radiobtn2 = driver.findElement(By.xpath("(//input[@name=\"optradio\"])[2]"));
		Thread.sleep(500);
		radiobtn2.click();
		
		WebElement radiobtn1 = driver.findElement(By.xpath("(//input[@name=\"optradio\"])[1]"));
		Thread.sleep(500);
		if (radiobtn1.isSelected()) {

			radiobtn1.click();
		}

		

	}
}