package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testcases.TestShopScenario;
import java.util.concurrent.TimeUnit;

public class AdjustPersonalInfoTest extends TestShopScenario{

    @Test
    public void adjustPersonalInfo() {

        //Check if a user is logged in
        //if no user is logged in, log in a user
        if (driver.findElement(By.className("login")).isDisplayed()){
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("cedric.nuyts@polteq.com");
            driver.findElement(By.id("passwd")).sendKeys("abc123!");
            driver.findElement(By.id("SubmitLogin")).click();
            //Click on the my personal info icon
            driver.findElement(By.className("icon-user")).click();
        } else {
            //Go to the users customer account
            //Click on the my personal info icon
            driver.findElement(By.className("account")).click();
            driver.findElement(By.className("icon-user")).click();
        }

        //Check the name
        //if the name is equal to the initial name, change it
        //if the name is equal to the new name, change it back to the initial name
        //if the name is equal to another name, change it back to the initial name
        String initialName = "Nuyts";
        String newName = "Appelmans";
        WebElement lastNameField = driver.findElement(By.id("lastname"));
        String currentName = lastNameField.getText();

        if ( currentName == initialName) {
            //change it to newName
            lastNameField.clear();
            lastNameField.sendKeys(newName);
        } else if (currentName == newName) {
            //change it back to initial
            lastNameField.clear();
            lastNameField.sendKeys(initialName);
        } else {
            //change it back to initial
            lastNameField.clear();
            lastNameField.sendKeys(initialName);
        }

        //Fill in the current password before saving the changes
        driver.findElement(By.xpath(".//*[@id='old_passwd']")).sendKeys("abc123!");

        //Save the changes
        driver.findElement(By.name("submitIdentity")).click();

        //Validate if the change is successful
        Assertions.assertThat(driver.findElement(By.xpath(".//*[@id='center_column']/div/p")).getText())
                .as("Update was not successfully.").contains("successfully updated");

    }
}
