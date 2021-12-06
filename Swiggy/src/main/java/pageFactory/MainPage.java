package pageFactory;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends BasePage {

	public @FindBy(xpath = "//div[@class='_1b8uz']") WebElement searchMessage;

	public @FindBy(xpath = "//input[@id='location']") WebElement searchInput;

	public @FindBy(xpath = "//div[@class='NqZN6']") WebElement clearBtn;

	public @FindBy(xpath = "//div[@class='_1oLDb']/div[contains(@class,'3lmRa')]") List<WebElement> listOfSuggestion;

	public @FindBy(xpath = "//a[@class='_3iFC5']") WebElement findFoodBtn;
	
	public @FindBy(xpath= "//a[contains(text(),'Sign up')]") WebElement signUpBtn;
	
	public @FindBy(xpath="//div[@class='_12S7_']") WebElement signUpSideMenu;
	
	public @FindBy(xpath="//input[@id='mobile']") WebElement mobileField;
	
	public @FindBy(xpath="//input[@id='name']") WebElement nameField;
	
	public @FindBy(xpath="//input[@id='email']") WebElement emailField;
	
	public @FindBy(xpath="//input[@id='password']") WebElement passwordField;
	
	public @FindBy(xpath="//label[@for='mobile']") WebElement mobileLabel;
	
	public @FindBy(xpath="//label[@for='name']") WebElement nameLabel;
	
	public @FindBy(xpath="//label[@for='email']") WebElement emailLabel;
	
	public @FindBy(xpath="//label[@for='password']") WebElement passwordLabel;
	
	public @FindBy(xpath="//a[@class='a-ayg']") WebElement continueBtn;
	

	public MainPage() throws IOException {
		super();
	}

	public MainPage clearBtnClick() throws IOException, InterruptedException {
		waitAndClickElement(clearBtn, 500);
		return new MainPage();
	}

	public MainPage searchMessage(String location) throws IOException, InterruptedException {
		sendKeys(searchInput, location);
		return new MainPage();
	}

	public int getNumberOfSuggestion() throws IOException, InterruptedException {
		return getElementSize(listOfSuggestion, 1000);

	}

	public String getSearchBarValue() throws IOException {
		return getElementAttribute(searchInput, "value");

	}

	public MainPage clickOnSearchSuggestion(int eleNum) throws InterruptedException, IOException {
		waitAndClickNthElement(listOfSuggestion, 1, 500);
		// wait for url to redirect
		Thread.sleep(5000);
		return new MainPage();
	}

	public MainPage findFoodBtnClick() throws InterruptedException, IOException {
		waitAndClickElement(findFoodBtn, 500);
		return new MainPage();
	}

	public String getSearchMessage() throws IOException {
		return searchMessage.getText();

	}

	public MainPage assertResults(boolean actual, boolean expected) throws IOException {
		Assert.assertEquals(actual, expected);
		return new MainPage();
	}

	public MainPage assertResults(String actual, String expected) throws IOException {
		Assert.assertEquals(actual, expected);
		return new MainPage();
	}
	
	public MainPage clickOnSignUpBtn() throws IOException, InterruptedException {
		waitAndClickElement(signUpBtn, 1000);
		return new MainPage();
		
	}
	
	public boolean signUpMenuShown() {
		return signUpSideMenu.isDisplayed();
	}
	
	public MainPage setMobileField(String mobile) throws IOException, InterruptedException {
		mobileField.clear();
		sendKeys(mobileField, mobile);
		Thread.sleep(500);
		continueBtn.click();
		return new MainPage();
	}
	
	public String getMobileField() {
		return mobileLabel.getText();
		
	}
	
	public MainPage setNameField(String name) throws IOException, InterruptedException {
		nameField.clear();
		sendKeys(nameField, name);
		Thread.sleep(500);
		continueBtn.click();
		return new MainPage();
		
	}
	
	public String getNameField() {
		return nameLabel.getText();
		
	}
	
	public MainPage setEmailField(String email) throws IOException, InterruptedException {
		emailField.clear();
		sendKeys(emailField, email);
		continueBtn.click();
		Thread.sleep(500);
		return new MainPage();
		
	}
	
	public String getEmailField() {
		return emailLabel.getText();
		
	}
	
	public MainPage setPasswordField(String password) throws IOException, InterruptedException {
		passwordField.clear();
		sendKeys(passwordField, password);
		continueBtn.click();
		Thread.sleep(500);
		return new MainPage();
		
	}
	
	public String getPasswordField() {
		return passwordLabel.getText();
		
	}
	
	public MainPage clickContinue() throws IOException, InterruptedException {
		waitAndClickElement(continueBtn, 500);
		signUpSideMenu.click();
		return new MainPage();
		
	}
	
	

}
