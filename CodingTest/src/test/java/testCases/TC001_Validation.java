package testCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.SubscriptionPage;

public class TC001_Validation extends BaseClass {
	WebDriver driver;
	SubscriptionPage sp;

	@Test
	public void TC001_ClickURL() throws InterruptedException {
		driver = GetDriver();
		driver.get("https://subscribe.stctv.com/");

	}

	@Test
	public void TC002_LanguageSelection() {
		sp = new SubscriptionPage(driver);
		sp.ClickLanguage();

	}

	@Test
	public void TC003_CountrySelection() {
		sp.ClickCountry();
	}

	@Test
	public void TC004_LiteValidation() {
		List<String> typePriceCurrency = sp.GetLite();
		Assert.assertEquals(typePriceCurrency.get(0), "LITE");

		Assert.assertEquals(typePriceCurrency.get(1), "5.4");
		Assert.assertEquals(typePriceCurrency.get(2), "USD");
	}

	@Test
	public void TC005_ClassicValidation() {
		List<String> typePriceCurrency = sp.GetClassic();
		Assert.assertEquals(typePriceCurrency.get(0), "CLASSIC");
		Assert.assertEquals(typePriceCurrency.get(1), "10.9");
		Assert.assertEquals(typePriceCurrency.get(2), "USD");
	}

	@Test
	public void TC006_PremiumcValidation() {
		List<String> typePriceCurrency = sp.GetPremium();
		Assert.assertEquals(typePriceCurrency.get(0), "PREMIUM");
		Assert.assertEquals(typePriceCurrency.get(1), "16.3");
		Assert.assertEquals(typePriceCurrency.get(2), "USD");

	}
}
