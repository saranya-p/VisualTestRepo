package VisualTest.VisualTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;

/**
 * Hello world!
 *
 */
public class AppTest {

	static WebDriver driver;
	static Eyes eyes = new Eyes();
	static Properties prop;
	static FileInputStream fis; 

	@BeforeClass

	public static void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saranya_p\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void Applitest() throws IOException {

		// Open a Chrome browser.
		

		try {
			// Initialize the eyes SDK and set your private API key.
			eyes.setApiKey("J8SMDdz2x4A12BBQ2UYMBFnwIU610957tOv7cTKRjQrko110");

			// Start the test and set the browser's viewport size to 800x600.
			eyes.open(driver, "Hello World!", "My first Selenium Java test!", new RectangleSize(800, 600));

			// Navigate the browser to the "hello world!" web-site.
			driver.get("https://www.amazon.com/");

			// Visual checkpoint #1.
			eyes.checkWindow("Hello!");
			prop=new Properties();
			fis = new FileInputStream("C:\\Users\\saranya_p\\git\\VisualTestRepo\\VisualTest\\Locators.Properties");
			prop.load(fis);
			// Click the "Click me!" button.

			driver.findElement(By.id(prop.getProperty("SearchTextBox"))).sendKeys("baby");
			driver.findElement(By.xpath(prop.getProperty("SearchButton"))).click();

			// Visual checkpoint #2.
			eyes.checkWindow("Click!");

			// End the test.
			eyes.close();
			

		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test as
			// aborted.
			eyes.abortIfNotClosed();
		}

	}

}
