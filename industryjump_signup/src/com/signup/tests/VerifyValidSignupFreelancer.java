package com.signup.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.signup.pages.SignUpFreelancer;

import Helper.BrowserFactory;

public class VerifyValidSignupFreelancer {

	
	@Test
	public void checkValidSignup() {
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://dev.industryjump.com/signup");
		SignUpFreelancer profile= PageFactory.initElements(driver, SignUpFreelancer.class);
		profile.signup("Tom Hanks","tom.hanks13@yahoo.com");
		assertEquals("Industry Jump", driver.getTitle());
	}
	
}

