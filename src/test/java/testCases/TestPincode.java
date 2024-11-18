package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;

public class TestPincode extends Browser {
	
	@Test
	public void checkPincode() {
		HomePage home = new HomePage(driver);
		
		String city=home.checkPin(properties.getProperty("delhiPincode").toString());
//		System.out.println(city);
		
		Assert.assertTrue(city.contains("New Delhi"), "Pincode text does not contain 'New Delhi'");;
		 
	}
	
	

}
