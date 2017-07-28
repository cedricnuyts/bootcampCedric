package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import testcases.TestShopScenario;

public class LogInTest_9_06 extends TestShopScenario{

    @Parameters({"email", "passwd"})
    @Test
    public void loginTest_9_06(String email, String passwd){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);

        //Check if a user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on "Sign in"
        homePage.clickSignIn();

        //Fill in credentials
        logInPage.fillInLogInForm(email, passwd);

        //Check if email format is NOK
        Assertions.assertThat(logInPage.getFormError()).as("Email is valid.").contains("Email");
    }
}
