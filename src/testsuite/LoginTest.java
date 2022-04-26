package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl ="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setup(){
        openBrowser(baseUrl);}

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        //Enter tha valid Username
        clickOnElement(By.id("customer.username"));
        // valid Usename Field
        sendTextToElement(By.id("customer.username"),"Jalpa");
        //Enter valid Password
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        // validUserName Field
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"Jalpa123");
        // Click on LOGINButton
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"11111");
        //This is from requirement
        String expectedMessage = "Accounts Overview";
        // Find your account was created successfully
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }
    @Test
    public void VarifyTheErrorMessage() {
        //Enter tha valid Username
        clickOnElement(By.id("customer.username"));
        // Invalid Usename Field
        sendTextToElement(By.id("customer.username"),"Jalpaa");
        //Enter valid Password
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        // validUserName Field
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"Jalpaaa");
        // Click on LOGINButton
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"11111");
    }
    @Test
    public void UserShouldLogOutSuccessfully() {
        //Enter tha valid Username
        clickOnElement(By.id("customer.username"));
        // valid Usename Field
        sendTextToElement(By.id("customer.username"),"Jalpa");
        //Enter valid Password
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        // validUserName Field
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"Jalpa123");

        // Click on LOGINButton
        clickOnElement(By.xpath("//input[@id='customer.password']"));
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"11111");
        // Click on LOGOut link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //This is from requirement
        String expectedMessage1 = "Customer Login";
        // Find your account was created successfully

        // Validate actual and expected message
        // The username and Password could not be verified

        // Validate actual and expected message
        sendTextToElement(By.xpath("//div[@id='rightPanel']"),"username and password could be verified");

        String expectedMessage = getTextFromElement(By.xpath("//div[@id='rightPanel']"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }}


