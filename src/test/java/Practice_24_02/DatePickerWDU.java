package Practice_24_02;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerWDU {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/");

		driver.manage().window().maximize();
		String parentwindow = driver.getWindowHandle();
		Thread.sleep(500);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// vertical down scroll (x and y coordinates)

		js.executeScript("window.scrollBy(0 , 400)", "");
		WebElement tab = driver.findElement(By.xpath("//h1[contains(text(),'DATEPICKER')]"));
		tab.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

				WebElement Calender = driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-calendar']"));
				Calender.click();

				WebElement ChangeDate = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
				ChangeDate.click();

				WebElement ChangeYear = driver
						.findElement(By.xpath("//body[1]/div[2]/div[2]/table[1]/thead[1]/tr[1]/th[2]"));
				ChangeYear.click();

				WebElement SelectYear = driver.findElement(By.xpath("//span[contains(text(),'2020')]"));
				SelectYear.click();

				WebElement ChangeMonth = driver.findElement(By.xpath("//span[contains(text(),'Oct')]"));
				ChangeMonth.click();

				WebElement SelectDate = driver.findElement(By.xpath("//td[contains(text(),'16')]"));

				SelectDate.click();

			}
		}
	}
}
