package chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testcases.TestShopScenario;

public class FillInContactFormTest extends TestShopScenario{

    @Test
    public void fillInContactForm(){

        //Click on button "Contact us"
        HomePage homePage = new HomePage(driver);
        homePage.clickContactUs();

        //Fill in contact form
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm("cedric.nuyts@polteq.com", "123456", "Dit is een test.");

        //Assert if form is correctly send
        Assertions.assertThat(contactUsPage.getAlertMessage())
                .as("Form was not successfully send.").contains("has been successfully sent");
    }
}
