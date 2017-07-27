package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    /*
    ********** THIS DO WE NEED ON EVERY PAGE **********
    * */

    private WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailTextField;

    @FindBy(css = "#passwd")
    private WebElement passwdTextField;

    @FindBy(css = "#SubmitLogin")
    private WebElement submitLoginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        //this call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    /*
    *****************************************************
    * */

    public void login(String user, String passwd){
        //Fill in the email
        emailTextField.sendKeys(user);

        //Fill in the password
        passwdTextField.sendKeys(passwd);

        //Click on the submit button
        submitLoginButton.click();
    }
}