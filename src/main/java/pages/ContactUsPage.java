package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    /*
    ********** THIS DO WE NEED ON EVERY PAGE **********
    * */

    private WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailTextField;

    @FindBy(css = "#id_order")
    private WebElement orderReferenceField;

    @FindBy(css = "#message")
    private WebElement messageTextField;

    @FindBy(css = "#submitMessage")
    private WebElement submitButton;

    @FindBy(css = "select#id_contact")
    private Select subjectHeadingSelectBox;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        //this call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    /*
    *****************************************************
    * */

    public void fillInContactForm(String subject, String email, String orderReference, String message){


        //SELECTBOX is hardcoded at the moment
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");

        //Select "Customer service" as header subject
        //subjectHeadingSelectBox.selectByVisibleText(subject);

        emailTextField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageTextField.sendKeys(message);
    }

    public void sendContactForm(){
        //Click on submit to send the form
        submitButton.click();
    }

    public String getAlertMessageSuccess(){
        WebElement alertMessageSuccessfully = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));

        return alertMessageSuccessfully.getText();
    }

    public String getAlertMessageDanger(){
        WebElement alertMessageDanger = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(".//div[@class='alert alert-danger']")));

        return alertMessageDanger.getText();
    }

    public String getFormError(){
        WebElement formError = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(".//*[@id='center_column']/form/fieldset//p[@class='form-group form-error']")));

        return formError.getText();
    }
}
