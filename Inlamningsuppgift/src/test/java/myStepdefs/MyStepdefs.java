package myStepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class MyStepdefs {

    private WebDriver driver;

    private String generateRandomEmail() {
        String lowerCharacters = "abcdefghijklmnopqrstuvwxyz";
        String upperCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberCharacters = "0123456789";
        return RandomStringUtils.random(3, lowerCharacters)
                + RandomStringUtils.random(3, numberCharacters)
                + RandomStringUtils.random(3, upperCharacters)
                + System.currentTimeMillis()
                + "@dodgit.com";
    }

    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Given("I have used {string}")
    public void iHaveUsed(String browser) {
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String date) {
        WebElement dateOfBirth = driver.findElement(By.id("dp"));
        dateOfBirth.sendKeys(date);

    }

    @Given("I have entered first name {string}")
    public void iHaveEnteredFirstName(String firstname) {
        WebElement firstName = driver.findElement(By.id("member_firstname"));
        firstName.sendKeys(firstname);
    }

    @Given("I have entered {string}")
    public void iHaveEntered(String firstname) {
        WebElement lastName = driver.findElement(By.id("member_lastname"));
        lastName.sendKeys(firstname);
    }

    @Given("I have entered and confirmed my {string}")
    public String iHaveEnteredAndConfirmedMy(String emailAddress) {
        String generatedEmail = "";

        if (emailAddress.equals("random")) {
            generatedEmail = generateRandomEmail();
        } else {
            generatedEmail = emailAddress;
        }

        WebElement emailInput = driver.findElement(By.id("member_emailaddress"));
        emailInput.sendKeys(generatedEmail);

        WebElement confirmEmailInput = driver.findElement(By.id("member_confirmemailaddress"));
        confirmEmailInput.sendKeys(generatedEmail);

        return generatedEmail;
    }

    @Given("I have chosen a password {string}")
    public void iHaveChosenAPassword(String chosenPassword) {
        WebElement passwordField = driver.findElement(By.id("signupunlicenced_password"));
        passwordField.sendKeys(chosenPassword);
    }

    @Given("I have confirmed my {string}")
    public void iHaveConfirmedMy(String confirmedPassword) {
        WebElement passwordConfirm = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        passwordConfirm.sendKeys(confirmedPassword);
    }


    @Given("I have checked and agreed to the terms and conditions")
    public void iHaveCheckedAndAgreedToTheTermsAndConditions() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
    }

    @Given("I have not checked and agreed to the terms and conditions")
    public void iHaveNotCheckedAndAgreedToTheTermsAndConditions() {
    }


    @Given("I have marked the checkbox that i am over 18")
    public void iHaveMarkedTheCheckboxThatIAmOver() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
    }

    @Given("I have marked the checkbox for code of ethics and conduct")
    public void iHaveMarkedTheCheckboxForCodeOfEthicsAndConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }


    @When("I click on confirm and join")
    public void iClickOnConfirmAndJoin() {
        waitForElement(By.cssSelector("input[name='join']")).click();
    }


    @Then("I should see that I am registered")
    public void iShouldSeeThatIAmRegistered() {
        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actual = driver.findElement(By.cssSelector(".bold:nth-child(1)")).getText();

        assertEquals(expected, actual);
    }

    @Then("I should see that last name is missing")
    public void iShouldSeeThatLastNameIsMissing() {
        String expected = "Last Name is required";
        String actual = driver.findElement(By.cssSelector(".row:nth-child(6) .warning > span")).getText();

        assertEquals(expected, actual);
    }

    @Then("I should see that password did not match")
    public void iShouldSeePasswordDidNotMatch() {
        String expected = "Password did not match";
        String actual = driver.findElement(By.cssSelector(".row:nth-child(2) .warning > span")).getText();

        assertEquals(expected, actual);
    }

    @Then("I should see that terms and conditions are not checked")
    public void iShouldSeeThatTermsAndConditionsAreNotChecked() {
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        String actual = driver.findElement(By.cssSelector(".warning:nth-child(4) > span")).getText();

        assertEquals(expected, actual);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}


