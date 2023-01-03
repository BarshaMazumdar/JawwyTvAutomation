package testCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		return driver;
	}

	public List<String> GetTypeCurrencyPrice(String type, WebElement currencyPrice) {
		List<String> listArray = new ArrayList<String>();
		String[] values = currencyPrice.getText().split(" ");
		String price = values[0].toString();
		String[] splitCurrency = values[1].split("/");
		String currency = splitCurrency[0];
		listArray.add(type);
		listArray.add(price);
		listArray.add(currency);
		return listArray;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
