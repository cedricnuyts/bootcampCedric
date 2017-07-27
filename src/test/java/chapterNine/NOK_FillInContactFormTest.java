package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testcases.TestShopScenario;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void nok_fillInContactForm(){
        //References to pages
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Check if no user is logged in
        homePage.checkIfUserIsLoggedIn();

        //Click on button "Contact us"
        homePage.clickContactUs();

        //Fill in the contact form wrong
        contactUsPage.fillInContactForm("Customer service", "nope", "4321234", "Help!");

        //Send the form
        contactUsPage.sendContactForm();

        //Check if the email is not accepted
        Assertions.assertThat(contactUsPage.getAlertMessageDanger()).as("Email was valid.").contains("email");
    }

}
