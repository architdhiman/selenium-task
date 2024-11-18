package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	WebDriver driver;
	WebDriverWait wait;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void switchTab() {
		Set<String> windowHandles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();

		for (String windowHandle : windowHandles) {
			System.out.println(windowHandle);

			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);

				break;
			}
		}
	}

	public void addToCart() {

		WebElement addButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='add-to-cart-button'])[2]")));
		addButton.click();
	}

	public boolean checkTitle(String expectedTitle) {

		WebElement prodTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
		return prodTitle.getText().equals(expectedTitle);

	}

	public void openCart() {
		WebElement viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@id='attach-sidesheet-view-cart-button']//input[@class='a-button-input']")));
		viewCart.click();
	}
}
