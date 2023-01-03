package pageObjectClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;

public class SubscriptionPage {

	WebDriver driver;
	BaseClass bs = new BaseClass();

	@FindBy(xpath = "//a[@id='translation-btn']")
	@CacheLookup
	WebElement btnEnglish;

	@FindBy(xpath = "//div[@id='country']")
	@CacheLookup
	WebElement btnCountry;

	@FindBy(css = "#country-selct")
	WebElement countryList;

	@FindBy(xpath = "//a[@id='ae']")
	@CacheLookup
	WebElement selectedCountryae;

	@FindBy(xpath = "//strong[@id='name-premium']")
	@CacheLookup
	WebElement txtPremium;

	@FindBy(xpath = "//strong[@id='name-classic']")
	@CacheLookup
	WebElement txtClassic;

	@FindBy(xpath = "//strong[@id='name-lite']")
	@CacheLookup
	WebElement txtLite;

	@FindBy(xpath = "//div[@id='currency-lite']")
	@CacheLookup
	WebElement txtCurrencyLite;

	@FindBy(xpath = "//div[@id='currency-classic']")
	@CacheLookup
	WebElement txtCurrencyClassic;

	@FindBy(xpath = "//div[@id='currency-premium']")
	@CacheLookup
	WebElement txtCurrencyPremium;

	public SubscriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickLanguage() {
		btnEnglish.click();

	}

	public void ClickCountry() {

		btnCountry.click();

		// for (int i = 0; i < countryList.findElements(By.tagName("a")).size(); i++) {
		// countryList.findElements(By.tagName("a")).get(i).click();

		// }

		selectedCountryae.click();

	}

	public List<String> GetLite() {
		List<String> typePriceCurrency = bs.GetTypeCurrencyPrice(txtLite.getText(), txtCurrencyLite);

		return typePriceCurrency;
	}

	public List<String> GetClassic() {
		List<String> typePriceCurrency = bs.GetTypeCurrencyPrice(txtClassic.getText(), txtCurrencyClassic);

		return typePriceCurrency;
	}

	public List<String> GetPremium() {
		List<String> typePriceCurrency = bs.GetTypeCurrencyPrice(txtPremium.getText(), txtCurrencyPremium);

		return typePriceCurrency;
	}
}