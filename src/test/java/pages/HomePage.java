package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void search() {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 15");
		searchBox.submit();

	}

	public boolean isImagePresent() {
		String xpath = "//img[contains(@src, '71d7rfSl0wL._AC_UY218_.jpg')]";

		WebElement image = driver.findElement(By.xpath(xpath));

		return image.isDisplayed();
	}

	public void clickImage() {
		String xpath = "//img[contains(@src, '71d7rfSl0wL._AC_UY218_.jpg')]";
		WebElement image = driver.findElement(By.xpath(xpath));
		image.click();
	}

	public void addToCart() {
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
		addButton.click();
	}

	public String checkPin(String pincode) {
		WebElement pinTextBox;
		WebElement submitButton;
		WebElement cityElement;

		WebElement pincodeTab = driver.findElement(By.id("nav-global-location-popover-link"));

		wait.until(ExpectedConditions.elementToBeClickable(pincodeTab)).click();

		pinTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")));
		pinTextBox.clear();
		pinTextBox.sendKeys(pincode);
		submitButton = driver
				.findElement(By.cssSelector("input.a-button-input[aria-labelledby='GLUXZipUpdate-announce']"));
		submitButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cityElement = driver.findElement(
				By.xpath("//span[@class='nav-line-2 nav-progressive-content' and @id='glow-ingress-line2']"));
		return cityElement.getText();
	}

	public Boolean checkInvalidPin(String pincode) {
		WebElement pinTextBox;
		WebElement submitButton;

		WebElement pincodeTab = driver.findElement(By.id("nav-global-location-popover-link"));

		wait.until(ExpectedConditions.elementToBeClickable(pincodeTab)).click();

		pinTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")));
		pinTextBox.clear();
		pinTextBox.sendKeys(pincode);
		submitButton = driver
				.findElement(By.cssSelector("input.a-button-input[aria-labelledby='GLUXZipUpdate-announce']"));
		submitButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipError")));
		return errorElement.isDisplayed();
	}

	public void changeLangToHindi() {
		WebElement langTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("icp-nav-flyout")));
		Actions actions = new Actions(driver);

		actions.moveToElement(langTab).perform();

		WebElement hindiButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#switch-lang=hi_IN']")));

		hindiButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean checkHindi() {
		WebElement langTab1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("icp-nav-flyout")));

		String currentLang = langTab1.getText();
		return currentLang.equals("HI");

	}

}
