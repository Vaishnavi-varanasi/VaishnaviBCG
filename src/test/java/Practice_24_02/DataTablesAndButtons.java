package Practice_24_02;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DataTablesAndButtons {
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

		js.executeScript("window.scrollBy(0 , 800)", "");
		WebElement tab = driver.findElement(By.xpath("//h1[contains(text(),'DATA, TABLES & BUTTON STATES')]"));
		tab.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

				System.out.println("Table 1 User Details:");
				WebElement fname = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[3]/td[1]"));
				String text1 = fname.getText();
				System.out.println(text1);
				WebElement lname = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[3]/td[2]"));
				String text2 = lname.getText();
				System.out.println(text2);
				WebElement age = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[3]/td[3]"));
				String text3 = age.getText();
				System.out.println(text3);

				Actions builder = new Actions(driver);

				WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
				Action seriesofact = builder.moveToElement(firstname).click().keyDown(firstname, Keys.INSERT)
						.sendKeys(text1).build();
				seriesofact.perform();
				WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
				Action seriesofact1 = builder.moveToElement(lastname).click().keyDown(lastname, Keys.INSERT)
						.sendKeys(text2).build();
				seriesofact1.perform();

				WebElement InputTxt = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/textarea[1]"));
				Action seriesofact2 = builder.moveToElement(InputTxt).click().keyDown(InputTxt, Keys.INSERT)
						.sendKeys(text1 + " " + text2 + "'s Age is " + text3).build();
				seriesofact2.perform();

				List<WebElement> rowno2 = driver.findElements(By.xpath("//table[@id = 't02']/tbody/tr"));
				int rowcount2 = rowno2.size();
				System.out.println("Table 2 Row Count is: " + rowcount2);
				System.out.println("Table 2 User Details:");
				WebElement fname2 = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr[2]/td[1]"));
				String text4 = fname2.getText();
				System.out.println(text4);
				WebElement lname2 = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr[2]/td[2]"));
				String text5 = lname2.getText();
				System.out.println(text5);
				WebElement age2 = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr[2]/td[3]"));
				String text6 = age2.getText();
				System.out.println(text6);
			}
		}
	}
}
