package Practice_24_02;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonClicks {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/");
		driver.manage().window().maximize();

		Thread.sleep(500);

		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0 , 900)", "");
		Thread.sleep(1000);
		WebElement buttonclicks = driver.findElement(By.xpath("//h1[contains(text(),'BUTTON CLICKS')]"));

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

				WebElement wbclick = driver.findElement(
						By.xpath("//p[contains(text(),'CLICK ME!')]"));
				Thread.sleep(2500);
				wbclick.click();
				Thread.sleep(2500);

				WebElement close = driver.findElement(By.xpath("//body/div[1]/div[4]/div[1]/div[1]/div[3]/button[1]"));
				Thread.sleep(2500);
				close.click();
				Thread.sleep(2500);

				WebElement wbclick1 = driver.findElement(By.cssSelector("#button2"));
				Thread.sleep(1500);
				Builder.click(wbclick1).perform();
				Thread.sleep(1500);

				WebElement close1 = driver.findElement(By.cssSelector(
						"body.modal-open:nth-child(2) div.container:nth-child(2) div.modal.fade.in.show:nth-child(6) div.modal-dialog.modal-md div.modal-content div.modal-footer > button.btn.btn-default"));
				Thread.sleep(1500);
				close1.click();
				Thread.sleep(1500);

				
				WebElement wbclick2 = driver.findElement(By.xpath("//span[@id='button3']"));
				Builder.click(wbclick2).perform();
				Thread.sleep(1500);
				
				WebElement close3 = driver.findElement(By.xpath("//body/div[1]/div[6]/div[1]/div[1]/div[3]/button[1]"));
				Thread.sleep(1500);
				close3.click();
				Thread.sleep(1500);

			}

		}
	}
}