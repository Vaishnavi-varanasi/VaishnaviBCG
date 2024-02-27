package Axis.BCG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeFirefox {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/");

	}
}