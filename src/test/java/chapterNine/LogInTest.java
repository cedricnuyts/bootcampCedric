package chapterNine;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import testcases.TestShopScenario;

public class LogInTest extends TestShopScenario {

    @Test
    public void logIn(){
        //Reference to LogInPage
        LogInPage logInPage = new LogInPage(driver);

        //Reference to HomePage
        HomePage homePage = new HomePage(driver);

        //Check if no user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Go to the login page
        homePage.clickSignIn();

        //Login the user
        logInPage.login("bootcamper@feelthepain.com", "1qazxsw2");

        //Wait until login is done
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(".//*[@id='header']/div[1]/div/div/nav/div[2]/a[@title='View my customer account']")));

        //Check if the login was successful
        Assertions.assertThat(driver.findElement(
                By.xpath(".//*[@id='header']/div[1]/div/div/nav/div[2]/a[@title='View my customer account']"))
                .isDisplayed()).as("Login was not successful").isTrue();
    }

}
