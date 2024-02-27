package Practice_24_02;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownCheckboxRadio {
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

		js.executeScript("window.scrollBy(0 , 1000)", "");
		WebElement tab = driver
				.findElement(By.xpath("//h1[contains(text(),'DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)')]"));
		tab.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				
				WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
				Select seldropdown1 = new Select(dropdown1);
				Thread.sleep(1000);
				seldropdown1.selectByVisibleText("Python");
				
				
				
				WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-2']"));
				Select seldrop2 = new Select(dropdown2);
				Thread.sleep(1000);
				seldrop2.selectByVisibleText("Maven");
				
				WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-3']"));
				Select seldropdown3 = new Select(dropdown3);
				Thread.sleep(1000);
				seldropdown3.selectByVisibleText("JavaScript");
				
				List<WebElement> allcheck = driver.findElements(By.xpath("//input[@type='checkbox']"));
				Thread.sleep(500);
				for (WebElement wb : allcheck) {
					wb.click();
				}
				
				WebElement radiobtn1 = driver.findElement(By.xpath("//input[@name='color'][@value='purple']"));
				Thread.sleep(500);
				radiobtn1.click();
				
				WebElement radiobtn2 = driver.findElement(By.xpath("//input[@name='vegetable'][@value='pumpkin']"));
				Thread.sleep(500);
				radiobtn2.click();
				
				WebElement dropdown4 = driver.findElement(By.xpath("//select[@id='fruit-selects']"));
				Select seldropdown4 = new Select(dropdown4);
				Thread.sleep(1000);
				seldropdown4.selectByVisibleText("Apple");
				
			}
		}
	}
}
