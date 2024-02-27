package Axis.BCG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerMMT {
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		
		WebElement Departure = driver.findElement(By.xpath("//label[@for='departure']"));
		
		Departure.click();
		
		WebElement Date = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][@aria-label=\"Tue Feb 27 2024\"]"));
		
		Date .click();

	}

}
