package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean checkCart(String expectedTitle) {
		
		WebElement productTitle = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
		return productTitle.getText().equals(expectedTitle);
		
	}
	public void deleteFromCart() {
		WebElement deleteButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-action='delete' and @value='Delete']")));
		deleteButton.click();
	}

	public boolean checkEmptyCarty() {
	 WebElement emptyMessag=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='a-size-extra-large a-spacing-mini a-spacing-top-base a-text-normal']")));
	 return emptyMessag.getText().equals("Your Amazon Cart is empty.");
	}


}
