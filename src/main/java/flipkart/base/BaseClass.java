package flipkart.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	protected static Duration waitUnit = Duration.ofSeconds(20);
	protected static WebDriverWait wait;

	public void launchApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(waitUnit);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}

	public void tearDown() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void scrollToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
