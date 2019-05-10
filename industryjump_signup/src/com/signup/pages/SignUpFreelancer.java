package com.signup.pages;

import java.awt.Button;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpFreelancer {

	
	WebDriver driver;
	
	public SignUpFreelancer(WebDriver driver) 
	{
		this.driver =driver;
	}
	
	//Locator for the Home Page
	
	@FindBy(how=How.XPATH,using=("//*[@id=\"profile-choice\"]/button[1]")) WebElement selectFreelancer;
	@FindBy(how=How.XPATH,using=("//*[@id=\"profile-choice\"]/button[2]")) WebElement selectProductionCompany;
	
	//Locator for the Profile Page
	
	@FindBy(how=How.NAME,using="fullName") WebElement fullname;
	@FindBy(how=How.NAME,using="email") WebElement email;
	@FindBy(how=How.NAME,using="address") WebElement address;
	@FindBy(how=How.NAME,using="dOB") WebElement dateofbirth;
	@FindBy(how=How.XPATH,using="//*[@id=\"fields\"]/form/div[6]/div/input") WebElement phone;
	@FindBy(how=How.XPATH,using="//*[@id=\"fields\"]/form/div[7]/div[1]/button/span[2]") WebElement pictureUpload;
	@FindBy(how=How.XPATH,using = "//input[@type='file']") WebElement ChooseFile;
	@FindBy(how=How.CSS,using = "body > div.ng-tns-c11-1.custom-img-dialog.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-shadow.ui-dialog-draggable.ng-trigger.ng-trigger-dialogState > div.ui-dialog-content.ui-widget-content > article > footer > input[type=submit]") WebElement SubmitButton;
	@FindBy(how=How.NAME,using="gender") WebElement gender;
	@FindBy(how=How.NAME,using="password") WebElement password;
	@FindBy(how=How.NAME,using="confirmPassword") WebElement confirmPassword;
	@FindBy(how=How.XPATH,using="//input[@type='submit']") WebElement nextpage;
	@FindBy(how=How.XPATH,using = "//*[@id=\"roles\"]/span/ul/li/input") WebElement roles;
	@FindBy(how = How.XPATH,using = "//*[@id=\"roles\"]/span/button/span[1]") WebElement idrolesdrp;
	@FindBy(how=How.TAG_NAME,using="h1") WebElement assertionText;
	//Locator for the Portfolio Page
	
	@FindBy(how=How.NAME,using="imdb") WebElement imdblink;
	@FindBy(how=How.NAME,using="Personal Website") WebElement website;
	@FindBy(how=How.NAME,using="reel") WebElement reel;
	@FindBy(how=How.XPATH,using="//*[@id=\"portfolio\"]/form/div/div[4]/button/span[2]") WebElement pdfResume;
	@FindBy(how=How.XPATH,using="//*[@id=\"portfolio\"]/form/div/div[5]/button/span[2]") WebElement pdfGear;
	@FindBy(how=How.XPATH,using="//*[@id=\"portfolio\"]/form/div/div[6]/div/label[1]") WebElement acceptCheckbox;
	@FindBy(how=How.XPATH,using="//*[@id=\"input-button\"]") WebElement btnSignup;

	//Methods for the first page
	public void signup_profile(String fn, String eml, String addr, String dob, String ph)
	{
		selectFreelancer.click();
		fullname.sendKeys(fn);
		email.sendKeys(eml);
		address.sendKeys(addr);
		dateofbirth.sendKeys(dob);
		phone.sendKeys(ph);
	}
	//Select Roles
	public void selectroles_list()
	{
		roles.sendKeys("Agency");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		roles.sendKeys(Keys.DOWN);
	}
	
	//Upload Profile Picture
	public void uploadProfilePicture()
	{
	     pictureUpload.click();
	     ChooseFile.sendKeys("c:\\1.png");  
	     SubmitButton.click();
	}
	
	//Select Gender
	public void selectGender()
	{
		Select dropgender = new Select(gender);
		dropgender.selectByValue("1: Male");
	}
	
	//Select Password
	public void selectPassword(String pass, String conpass)
	{
		password.sendKeys(pass);
		confirmPassword.sendKeys(conpass);
	}
	
	//Navigate to Portfolio Page
	public void goToPortfolio() 
	{
		nextpage.click();
	}
	
	//-------------------------------------------------------------------------------------
	//Methods for the Portfolio page
	
	//Select IMDB link
	public void signup_PortfolioIMDBLink(String urlimdb) 
	{
		imdblink.sendKeys(urlimdb);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Select Portfolio Link	
	public void signup_PortfolioPersonalWebsite(String urlweb) 
	{
		website.sendKeys(urlweb);
	}
	
	//Select Youtube/Vimeo reels
	public void signup_PortfolioReel(String urlreel) 
	{
		reel.sendKeys(urlreel);
	}	
	
	//Accept T&C
	public void signup_PortfolioAccept() 
	{
		acceptCheckbox.click();
	}
	
	//Confirm Signup
	public void signup_PortfolioSignUp() 
	{
		btnSignup.click();
	}
	
	//signup
	public void signup(String ContractorName, String emailaddress) {
		signup_profile(ContractorName, emailaddress, "111 Fulton St, NY", "12/12/1980", "(902)400-0000");
		selectroles_list();
		uploadProfilePicture();
		selectGender();
		selectPassword("Password1", "Password1");
		goToPortfolio();
		signup_PortfolioIMDBLink("https://www.imdb.com/name/nm4622648");
		signup_PortfolioAccept();
		signup_PortfolioSignUp();
	}
}
