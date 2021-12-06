package steps;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageFactory.MainPage;
import utils.DriverFactory;
import utils.ReadExcel;

public class SignUpStepsDefinitions  extends DriverFactory{
	
	String projectPath=System.getProperty("user.dir");
    String excelFilePath=projectPath+"/src/test/resources/swiggy_negative_accounts.xlsx";
	
	@Given("Click on Sign up button")
	public void click_on_sign_up_button() throws IOException, InterruptedException {
		mainPage.clickOnSignUpBtn();

	}

	@Then("Sign up menu should show")
	public void sign_up_menu_should_show() {
		Assert.assertTrue(mainPage.signUpMenuShown());
	}
	
	
	@Then("User enter Phone number and System check the validity of the information entered")
	public void user_enter_phone_number_and_system_check_the_validity_of_the_information_entered() throws IOException, InterruptedException {

		Object[][] data = ReadExcel.loadExcel(excelFilePath, "phone", true);
		
  
        	for(int i=0;i<data.length;i++) {
        		mainPage.setMobileField(data[i][0].toString());
        		String actual = mainPage.getMobileField();
        		String expected = data[i][1].toString();
        		Assert.assertEquals(actual, expected);
        		Thread.sleep(1000);
        	}
	}

	@Then("User enter Name and System check the validity of the information entered")
	public void user_enter_name_and_system_check_the_validity_of_the_information_entered() throws IOException, InterruptedException {

		Object[][] data = ReadExcel.loadExcel(excelFilePath, "name", true);
		
		  
    	for(int i=0;i<data.length;i++) {
    		mainPage.setNameField(data[i][0].toString());
    		String actual = mainPage.getNameField();
    		String expected = data[i][1].toString();
    		Assert.assertEquals(actual, expected);
    		Thread.sleep(1000);
    	}

	}

	@Then("User enter Email and System check the validity of the information entered")
	public void user_enter_email_and_system_check_the_validity_of_the_information_entered() throws IOException, InterruptedException {

		Object[][] data = ReadExcel.loadExcel(excelFilePath, "email", true);
		
		  
    	for(int i=0;i<data.length;i++) {
    		mainPage.setEmailField(data[i][0].toString());
    		String actual = mainPage.getEmailField();
    		String expected = data[i][1].toString();
    		Assert.assertEquals(actual, expected);
    		Thread.sleep(1000);
    	}


	}

	@Then("User enter Password and System check the validity of the information entered")
	public void user_enter_password_and_system_check_the_validity_of_the_information_entered() throws IOException, InterruptedException {
		Object[][] data = ReadExcel.loadExcel(excelFilePath, "password", true);
		  
    	for(int i=0;i<data.length;i++) {
    		mainPage.setPasswordField(data[i][0].toString());
    		String actual = mainPage.getPasswordField();
    		String expected = data[i][1].toString();
    		Assert.assertEquals(actual, expected);
    		Thread.sleep(1000);
    	}

	}
	
	

}
