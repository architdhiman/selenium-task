package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;

public class TestSearch extends Browser {

	@Test
	public void searchTest() {
		HomePage home = new HomePage(driver);
		home.search();

		boolean isImagePresent = home.isImagePresent();

		Assert.assertTrue(isImagePresent, "Image not found on the result page.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
