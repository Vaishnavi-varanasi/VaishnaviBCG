package Practice_24_02;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToDoList {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/");

		driver.manage().window().maximize();
		// get the parent window handle
		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// vertical down scroll (x and y coordinates)

		js.executeScript("window.scrollBy(0 , 400)", "");

		WebElement todolist = driver.findElement(By.xpath("//h1[contains(text(),'TO DO LIST')]"));
		todolist.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		Iterator<String> itr = allWindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement AddNewTodo = driver.findElement(By.xpath("//*[@id=\"container\"]/input"));

				Actions actions = new Actions(driver);
				actions.moveToElement(AddNewTodo).perform();
				Thread.sleep(800);
				AddNewTodo.sendKeys("Buy Chocolates");
				AddNewTodo.sendKeys(Keys.ENTER);
				Thread.sleep(800);
				AddNewTodo.sendKeys("Recharge Phone");
				AddNewTodo.sendKeys(Keys.ENTER);
				Thread.sleep(800);
				AddNewTodo.sendKeys("Water the Plants");
				AddNewTodo.sendKeys(Keys.ENTER);
				Thread.sleep(800);

				WebElement Delpracticemagic = driver.findElement(By.xpath("//i[@id='plus-icon']"));
				actions.moveToElement(Delpracticemagic).perform();
				Delpracticemagic.click();

				WebElement Plusicon = driver.findElement(By.xpath("//i[@id='plus-icon']"));
				actions.moveToElement(Plusicon).perform();
				Thread.sleep(800);
				Plusicon.click();

			}
		}
	}
}