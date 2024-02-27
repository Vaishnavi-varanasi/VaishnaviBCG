package Practice_24_02;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ContactUS {
	public static WebDriver driver;

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://webdriveruniversity.com/");

		driver.manage().window().maximize();
		String parentwindow = driver.getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// vertical down scroll (x and y coordinates)

		js.executeScript("window.scrollBy(0 , 400)", "");
		WebElement tab = driver.findElement(By.xpath("//h1[contains(text(),'CONTACT US')]"));
		tab.click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		Iterator<String> itr = allWindows.iterator();

		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				
				Actions builder = new Actions(driver);

				WebElement firstname = driver.findElement(By.xpath("//input[@name='first_name']"));
				Action seriesofact = builder.moveToElement(firstname).click().keyDown(firstname, Keys.INSERT)
						.sendKeys(firstname, "Vaishnavi").build();
				seriesofact.perform();

				WebElement lastname = driver.findElement(By.xpath("//input[@name='last_name']"));
				Action seriesofact1 = builder.moveToElement(lastname).click().keyDown(lastname, Keys.INSERT)
						.sendKeys(lastname, "Varanasi").build();
				seriesofact1.perform();

				WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
				Action seriesofact2 = builder.moveToElement(email).click().keyDown(email, Keys.INSERT)
						.sendKeys(email, "vaishnavi@gmail.com").build();
				seriesofact2.perform();
				
				WebElement comment = driver.findElement(By.xpath("//textarea[@name='message']"));
				Action seriesofact3 = builder.moveToElement(email).click().keyDown(email, Keys.INSERT)
						.sendKeys(comment, "Comment").build();
				seriesofact3.perform();
				
				WebElement submit = driver.findElement(
						By.xpath("//input[@type='submit']"));

				submit.click();
				
				WebElement fname = driver.findElement(By.xpath("//h1[contains(text(),'Thank You for your Message!')]"));
				String text = fname.getText();
		 		String expectedTxt = "Thank You for your Message!";
		 		if(text.equals(expectedTxt)) {
		 			System.out.println("Thank You for your Message! is being displayed");
		 		} else {
		 			System.out.println("Thank You for your Message! is not being displayed");
		 		}

			}
		}
	}
}
