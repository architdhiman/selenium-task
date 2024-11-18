package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;
import pages.ProductPage;

public class TestProductPage extends Browser {

	@Test
	public void checkProductPage() {
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		home.search();

		home.clickImage();
		product.switchTab();
		assertTrue(product.checkTitle(properties.getProperty("expectedTitle").toString()), "title not found");
		;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void failcheckProductPage() {
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		home.search();

		home.clickImage();
		product.switchTab();
		assertTrue(!product.checkTitle(properties.getProperty("expectedTitle").toString()), "title not found");
		;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
