package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;

public class TestInvalidPin extends Browser {
	@Test
	public void invalidPinCheck() {
		HomePage home = new HomePage(driver);

		Boolean isInvalid = home.checkInvalidPin(properties.getProperty("invalidPincode").toString());
		assertTrue(isInvalid, null);

	}
}
