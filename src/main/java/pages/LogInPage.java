package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void fillInLogInForm(String user, String passwd){
        //Fill in the email
        emailTextField.sendKeys(user);

        //Fill in the password
        passwdTextField.sendKeys(passwd);
    }

    public void submitLogInForm(){
        //Click on the submit button
        submitLoginButton.click();
    }

    public String getFormError() {
        WebElement formError = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(".//*[@id='login_form']//div[@class='form-group form-error']")));

        return formError.getText();
    }

    public String getAlertMessageDanger(){
        WebElement alertMessageDanger = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(".//div[@class='alert alert-danger']")));

        return alertMessageDanger.getText();
    }
}