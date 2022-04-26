package testsuite;

import javafx.scene.control.PasswordField;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegistrationTest extends Utility {

    String baseUrl ="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setup(){
        openBrowser(baseUrl);}


    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the Registration link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //This is from requirement
        String expectedMessage = "Signing up is easy!";
        //verify that the Signing up is easy!
        String actualMessage = getTextFromElement(By.xpath("//div[@id='rightPanel']"));
        //validate actual and expected message
    }
    @Test
    public void verifyUserShouldRegisterAccountSuccessfully() {
        //click on the Registration link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // Enter First Name
        clickOnElement(By.id("customer.firstName"));
        //  FirstName Field
        sendTextToElement(By.id("customer.firstName"),"Swaminarayan");
        // Enter Last Name
        clickOnElement(By.name("customer.lastName"));
        //  LastName Field
        sendTextToElement(By.name("customer.firstName"),"Nilkanth");
        // field Address
        clickOnElement(By.id("customer.address.street"));
        //  Email address Field
        sendTextToElement(By.id("customer.address.street"),"Watford,London");
        //click on city
        clickOnElement(By.className("input"));
        // CityName Field
        sendTextToElement(By.className("input"),"lONDON");
        //click on StateName
        clickOnElement(By.id("customer.address.state"));
        // StateNameField Field
        sendTextToElement(By.id("customer.address.state"),"Gujrat");
        //click on ZipCode
        clickOnElement(By.id("customer.address.zipCode"));
        // ZipCodeField Field
        sendTextToElement(By.id("customer.address.zipCode"),"365601");
        //click on PhoneNO
        clickOnElement(By.name("customer.phoneNumber"));
        // PhoneNoField Field
        sendTextToElement(By.name("customer.phoneNumber"),"9879651265");
        //click on SSN
        clickOnElement(By.id("customer.ssn"));
        // SSNField Field
        sendTextToElement(By.id("customer.ssn"),"123456");
        //click on Username
        clickOnElement(By.id("customer.username"));
        // UserName Field
        sendTextToElement(By.id("customer.username"),"Jalpa");
        //click on Password
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        // UserName Field
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"Jalpa123");
        // Click on ConfirmPassword
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        //  ConfirmPassword Field
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"Jalpa123");
        // Click on REGISTERBUTTOn
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"11111");
        //This is from requirement
        String expectedMessage = "Your account was created successfully.you are now logged in";
        // Find your account was created successfully
        String actualMessage = getTextFromElement(By.xpath("//div[@id='rightPanel']"));
        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();

    }}