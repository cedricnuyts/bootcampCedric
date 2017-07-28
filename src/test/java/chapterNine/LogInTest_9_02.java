package chapterNine;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import testcases.TestShopScenario;

public class LogInTest_9_02 extends TestShopScenario {

    /*
    Tests
    1 Bad email format
    2 No email before submit
    3 No password before submit
    4 No email after submit
    5 No password after submit
    6 wrong password
    7 No email and password after submit
     */

    //1 Bad email format
    @Test
    public void testBadEmailFormat(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm("email", "");

        //Check if email format is NOK
        Assertions.assertThat(logInPage.getFormError()).as("Email is valid.").contains("Email");
    }

    //2 No email before submit
    @Test
    public void testNoEmailError(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm("", "123456");

        //Check if email empty is NOK
        Assertions.assertThat(logInPage.getFormError()).as("Email is not required.").contains("Email");
    }

    //3 No password before submit
    @Test
    public void testNoPasswordError(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm("cedric.nuyts@polteq.com", "");

        //Focus out of password field
        driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys(Keys.TAB);

        //Check if password empty is NOK
        Assertions.assertThat(logInPage.getFormError()).as("Password is not required.").contains("Password");
    }

    //4 No email after submit
    @Test
    public void testEmailIsRequired(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm("", "abc123");

        //Click submit button
        logInPage.submitLogInForm();

        //Check if email is required
        Assertions.assertThat(logInPage.getAlertMessageDanger())
                .as("Email is not required.")
                .contains("An email address required");
    }

    //5 No password after submit
    @Test
    public void testPasswordIsRequired(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm("cedric.nuyts@polteq.com", "");

        //Click submit button
        logInPage.submitLogInForm();

        //Check if email is required
        Assertions.assertThat(logInPage.getAlertMessageDanger())
                .as("Password is not required.")
                .contains("Password is required");
    }

    //6 Wrong password
    @Test
    public void testWrongPasswordError(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm("cedric.nuyts@polteq.com", "badpasswd");

        //Click submit button
        logInPage.submitLogInForm();

        //Check if wrong password is NOK
        Assertions.assertThat(logInPage.getAlertMessageDanger())
                .as("Wrong password is accepted.")
                .contains("Authentication failed");
    }

    //6 No email and password after submit
    @Test
    public void testEmailAndPasswordIsRequired(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Click submit button
        logInPage.submitLogInForm();

        //Check if email is required
        Assertions.assertThat(logInPage.getAlertMessageDanger())
                .as("Email and password is not required.")
                .contains("An email address required");
    }
}

