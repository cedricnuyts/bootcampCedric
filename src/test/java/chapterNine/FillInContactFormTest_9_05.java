package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testcases.TestShopScenario;

public class FillInContactFormTest_9_05 extends TestShopScenario {

    @Parameters({"subject", "email", "orderID", "message"})
    @Test
    public void fillInContactForm_9_05(String subject, String email, String orderID, String message){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Click on button "Contact us"
        homePage.clickContactUs();

        //Fill in contact form
        contactUsPage.fillInContactForm(subject, email, orderID, message);

        //Send the form
        contactUsPage.sendContactForm();

        //Assert if form is correctly send
        Assertions.assertThat(contactUsPage.getAlertMessageSuccess())
                .as("Form was not successfully send.").contains("has been successfully sent");
    }

}
