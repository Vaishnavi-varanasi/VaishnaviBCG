package Practice_24_02;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {
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

		js.executeScript("window.scrollBy(0 ,4400)", "");
		Thread.sleep(1000);

		WebElement buttonclicks = driver.findElement(By.xpath("//h1[contains(text(),'FILE UPLOAD')]"));

		Actions Builder = new Actions(driver);
		Builder.click(buttonclicks).perform();

		Thread.sleep(500);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement upload = driver.findElement(By.xpath("//input[@id='myFile']"));

				upload.sendKeys("C:\\Users\\hp\\Downloads\\Lotus.jpg");
				Thread.sleep(500);
				
				WebElement sub = driver.findElement(By.xpath("//input[@id='submit-button']"));
				Builder.click(sub).perform();
				System.out.println("File Uploaded Successfully");
				Thread.sleep(500);
				
				Alert alt1 = driver.switchTo().alert();
				alt1.accept();
				Thread.sleep(500);
			}
		}
	}
}
