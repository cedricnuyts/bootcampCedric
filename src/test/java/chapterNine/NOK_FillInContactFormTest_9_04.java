package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testcases.TestShopScenario;

public class NOK_FillInContactFormTest_9_04 extends TestShopScenario {

    @Test
    public void nok_fillInContactFormTest_9_04(){
        //References to pages
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Check if no user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on button "Contact us"
        homePage.clickContactUs();

        //Fill in the contact form wrong
        contactUsPage.fillInContactForm("Customer service", "nope", "4321234", "Help!");

        //Check if the email format is not correct
        Assertions.assertThat(contactUsPage.getFormError()).as("Email is valid.").contains("Email");
    }
}
