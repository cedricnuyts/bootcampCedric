package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    /*
    ********** THIS DO WE NEED ON EVERY PAGE **********
    * */

    private WebDriver driver;

    //@FindBy(css = "#email")
    //private WebElement emailTextField;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        //this call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    /*
    *****************************************************
    * */



}
