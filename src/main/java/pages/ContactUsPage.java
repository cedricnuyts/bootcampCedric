package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        //this call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    /*
    *****************************************************
    * */

    public void fillInContactForm(String email, String orderReference, String message){

        //Hardcoded at the moment
        //xPath = .//*[@id='id_contact']/option[2] --- Rework this to based on text in a variable
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");

        emailTextField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageTextField.sendKeys(message);
        submitButton.click();
    }
}
