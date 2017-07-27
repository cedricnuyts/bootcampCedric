package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testcases.TestShopScenario;

public class FillInContactFormTest extends TestShopScenario{

    @Test
    public void fillInContactForm(){

        //Reference to HomePage
        HomePage homePage = new HomePage(driver);

        //Click on button "Contact us"
        homePage.clickContactUs();

        //Fill in contact form
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("Customer service", "cedric.nuyts@polteq.com", "123456", "Dit is een test.");

        //Send the form
        contactUsPage.sendContactForm();

        //Assert if form is correctly send
        Assertions.assertThat(contactUsPage.getAlertMessageSuccess())
                .as("Form was not successfully send.").contains("has been successfully sent");
    }
}
