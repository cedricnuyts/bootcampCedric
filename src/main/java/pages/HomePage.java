package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /*
    ********** THIS DO WE NEED ON EVERY PAGE **********
    * */

    private WebDriver driver;

    @FindBy(css = "#contact-link")
    private WebElement contactUsButton;

    @FindBy(className = "login")
    private WebElement signInButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        //this call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    /*
    *****************************************************
    * */

    public void clickContactUs(){
        contactUsButton.click();
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void checkIfUserIsLoggedIn(){
        //Check if no user is logged in
        Assertions.assertThat(driver.findElement(By.className("login")).isDisplayed()).isTrue();
    }

}
