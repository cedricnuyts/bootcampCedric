package chapterNine;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import testcases.TestShopScenario;

public class FillInContactFormTest_9_05 extends TestShopScenario {

    @Test
    public void fillInContactForm_9_05(){
        //Reference to pages
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Click on button "Contact us"
        homePage.clickContactUs();

        //EXCEL
    }

}
