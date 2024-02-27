package Practice_24_02;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxLoader {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://webdriveruniversity.com/");

		driver.manage().window().maximize();

// get the parent window handle 

		String parentwindow = driver.getWindowHandle();

		System.out.println(parentwindow);

		JavascriptExecutor js = (JavascriptExecutor) driver;

// vertical down scroll (x and y coordinates) 

		js.executeScript("window.scrollBy(0 , 1000)", "");

		WebElement AjaxLoader = driver.findElement(By.xpath("//h1[contains(text(),'AJAX LOADER')]"));

		AjaxLoader.click();

		Set<String> allWindows = driver.getWindowHandles();

		System.out.println(allWindows);

		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {

			String childwindow = itr.next();

			if (!parentwindow.equalsIgnoreCase(childwindow)) {

				driver.switchTo().window(childwindow);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/span[1]/p[1]")));

				WebElement clickme = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/span[1]/p[1]"));

				clickme.click();

				Thread.sleep(500);

				WebElement ajaxclose = driver.findElement(By.xpath("//*[@id=\"myModalClick\"]/div/div/div[3]/button"));

				ajaxclose.click();

			}

		}

	}

}
