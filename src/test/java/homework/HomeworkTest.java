package homework;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeworkTest extends TestShopScenario {


    @Test
    public void Homework() {

        //Initialize the row and column
        int rowToDelete;
        int columnToDelete = 0;

        //Define the string that you want to delete from the web table
        String itemToDelete = "iPod Nano";

        //Check if a user is logged in
        if (driver.findElement(By.className("login")).isDisplayed()){
            //if no user is logged in, log in a user
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("cedric@nuyts.com");
            driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
            driver.findElement(By.id("SubmitLogin")).click();
        } else {
            //Go to the users customer account
            driver.findElement(By.className("account")).click();
        }

        //Check if the correct page "My account" is opened
        Assertions.assertThat(driver.findElement(By.xpath(".//*[@id='center_column']/p[@class='info-account']"))
                .isDisplayed()).as("Your not on the 'My account' page").isTrue();

        //Click on My Wishlist
        driver.findElement(By.xpath(".//*[@id='center_column']/div//i[@class='icon-heart']")).click();

        //Check if the correct page "My wishlists" is opened
        Assertions.assertThat(driver.findElement(By
                .xpath(".//*[@id='mywishlist']/h1[contains(text(), 'My wishlists')]")).isDisplayed())
                .as("Your not on the 'My wishlists' page").isTrue();

        //Locate the table
        WebElement table = driver.findElement(By.xpath(".//*[@id='block-history']/table"));

        //Locate all the rows of the table
        List<WebElement> rowsTable = table.findElements(By.tagName("tr"));

        //Calculate the number of rows of the table
        int rowsCount = rowsTable.size();

        //Locate the columns of the header
        List<WebElement> columnsTable = table.findElements(By.tagName("th"));

        //Calculate the number of columns in the header row
        int columnsCount = columnsTable.size();

        //Loop until the last cell of the header row
        for (int columnHeader=0; columnHeader<columnsCount; columnHeader++){
            //Retrieve the text from the header cells
            String headerCellText = columnsTable.get(columnHeader).getText();

            //Print help text
            System.out.println("Header cell value with column number " + columnHeader
                    + " is equal to " + headerCellText);

            //If the text of the cell is equal to Delete, remember the number of the column and stop the loop
            if (headerCellText.equals("Delete")){
                //The current column + 1 because a list starts from 0, but the DOM starts from 1
                columnToDelete = columnHeader + 1;

                //Print help text
                System.out.println("The number of the column to delete is: " + columnToDelete);

                //Leave the loop
                break;
            }
        }

        System.out.println("----------------------------------------");

        outerloop:
        //Loop the rows of the table until the item that you want to delete (start at 1, because 0 is the table header)
        for (int row = 1; row<rowsCount; row++){
            //Locate the colums per row
            List<WebElement> columnRow = rowsTable.get(row).findElements(By.tagName("td"));

            //Calculate the columns
            int columnsSize = columnRow.size();

            //Loop through the columns of the row

            for (int column = 0; column<columnsSize; column++){
                //Get the text of each cell in the row
                String cellText = columnRow.get(column).getText();

                //Print to help
                System.out.println("The cell on row " + row + " and column " + column + " has value " + cellText);

                //Compare the text of each cell with the text to delete
                if (cellText.equals(itemToDelete)){
                    //When the text is equal, remember the number of the row
                    rowToDelete = row;

                    //Print the row
                    System.out.println("The row to delete is: " + rowToDelete);

                    //Delete the row
                    driver.findElement(By.xpath(".//tr["+rowToDelete+"]/td["+columnToDelete+"]/a/i")).click();

                    //Wait for a possible alert
                    wait.until(ExpectedConditions.alertIsPresent());

                    //Check if an alert is triggered
                    if (driver.switchTo().alert().getText().contains(" ")){
                        //Accept the alert if it is triggered
                        driver.switchTo().alert().accept();

                        //Help text to know there was an alert
                        System.out.println("Alert is accepted.");
                    }

                    //Leave the loop
                    break outerloop;
                }
            }
        }

        //Wait some time, the row is being deleted
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Check if the row is deleted
        Assertions.assertThat(driver.findElements(
                By.xpath(".//table/tbody//td/a[contains(text(), '"+itemToDelete+"')]")).size()>0)
                .as("Item is not deleted.");

        //Add the row again - Fill in the field en click on Save
        driver.findElement(By.xpath(".//*[@id='name']")).sendKeys(itemToDelete);
        driver.findElement(By.xpath(".//*[@id='submitWishlist']")).click();

        //Wait until the row is added
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(".//table/tbody//td/a[contains(text(), '"+itemToDelete+"')]")));

        //Check if the row is added again
        Assertions.assertThat(driver.findElement(
                By.xpath(".//table/tbody//td/a[contains(text(), '"+itemToDelete+"')]")).isDisplayed())
                .as("Item is not added again.");
    }
}