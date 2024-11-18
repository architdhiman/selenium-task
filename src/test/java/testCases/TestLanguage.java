package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.Browser;
import pages.HomePage;

public class TestLanguage extends Browser {

	@Test
	public void testLangChange() {
		HomePage home=  new HomePage(driver);
		home.changeLangToHindi();
		assertTrue(home.checkHindi());
		
		
	}
	
	@Test
	public void failtestLangChange() {
		HomePage home=  new HomePage(driver);
		home.changeLangToHindi();
		assertTrue(!home.checkHindi());
		
		
	}

}
