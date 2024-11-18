package testCases;

import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import base.Browser;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TestCart extends Browser {
	private static final Logger logger = LoggerFactory.getLogger(TestCart.class);

	@Test
	public void addToCart() {
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		CartPage cart = new CartPage(driver);
		home.search();

		home.clickImage();
		product.switchTab();
		assertTrue(product.checkTitle(properties.getProperty("expectedTitle").toString()), "title not found");

		product.addToCart();
		product.openCart();

		String expectedTitle = properties.getProperty("expectedTitle");
		assertTrue(cart.checkCart(expectedTitle), "item not found in cart");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 logger.debug("Debug message");
	        logger.info("Info message");
	        logger.warn("Warning message");
	        logger.error("Error message");
	}

	@Test
	public void deleteFromCart() {
		CartPage cart = new CartPage(driver);
		cart.deleteFromCart();
		assertTrue(cart.checkEmptyCarty(),"error deleting product");
		
	}

}
