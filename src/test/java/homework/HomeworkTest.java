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

        //Define the wishlist you want to find
        String itemToDeleteAndAdd = "iPod Nano";

        //Define the action you want to do (= equals the header cell)
        String textToLocate = "Delete";

        //Check if a user is logged in.
        checkLogin();

        //Check if the correct page "My account" is opened
        assertXpathIsDisplayedIsTrue(".//*[@id='center_column']/p[@class='info-account']",
                "Your not on the 'My account' page.");

        //Click on My Wishlist
        driver.findElement(By.xpath(".//*[@id='center_column']/div//i[@class='icon-heart']")).click();

        //Check if the correct page "My wishlists" is opened
        assertXpathIsDisplayedIsTrue(".//*[@id='mywishlist']/h1[contains(text(), 'My wishlists')]",
                "Your not on the 'My wishlists' page.");

        //Delete the wishlist
        deleteWishlist(textToLocate, itemToDeleteAndAdd);

        //Wait some time, the row is being deleted
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Check if the row is deleted
        Assertions.assertThat(driver.findElements(
                By.xpath(".//table/tbody//td/a[contains(text(), '"+itemToDeleteAndAdd+"')]")).size()>0)
                .as("Item is not deleted.");

        //Add the wishlist again
        addWishlist(itemToDeleteAndAdd);

        //Wait until the row is added
        wait.until(ExpectedConditions
                .presenceOfElementLocated(
                        By.xpath(".//table/tbody//td/a[contains(text(), '"+itemToDeleteAndAdd+"')]")));

        //Check if the row is added
        assertXpathIsDisplayedIsTrue(".//table/tbody//td/a[contains(text(), '"+itemToDeleteAndAdd+"')]",
                "Item is not added.");
    }

    private void checkLogin(){
        //Check if a user is logged in
        if (driver.findElement(By.className("login")).isDisplayed()){
            //if no user is logged in, go to login method
            login();
        } else {
            //if a user is logged in, go to the users customer account
            driver.findElement(By.className("account")).click();
        }

    }

    private void login(){
        //Click on the link to Sign in
        driver.findElement(By.className("login")).click();

        //Fill in the email and password
        driver.findElement(By.id("email")).sendKeys("cedric@nuyts.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        //Click on the submit button
        driver.findElement(By.id("SubmitLogin")).click();
    }

    private void assertXpathIsDisplayedIsTrue(String xpath, String explanation){
        Assertions.assertThat(driver.findElement(By.xpath(xpath))
                .isDisplayed()).as(explanation).isTrue();
    }

    private void deleteWishlist(String textToLocate, String itemToDeleteAndAdd) {
        //Locate the table
        WebElement table = driver.findElement(By.xpath(".//*[@id='block-history']/table"));

        //Get the number of the column
        int columnToDelete = locateColumn(table, textToLocate);
        int rowToDelete = locateRow(table, itemToDeleteAndAdd);

        //Check if the row and column are retrieved correctly (values can never be '0' when the wishlist is found)
        //If wishlist is found, delete is, otherwise add it
        if (columnToDelete != 0 && rowToDelete != 0){
            //Delete the wishlist
            driver.findElement(By.xpath(".//tr["+rowToDelete+"]/td["+columnToDelete+"]/a/i")).click();

            //Check for an alert
            checkAlert();

        } else {
            //Wishlist is not found, so add it
            addWishlist(itemToDeleteAndAdd);

            //Help text
            System.out.println("Wishlist is added, because he was not there yet.");
        }
    }

    private int locateColumn(WebElement table, String textToLocate){
        //Define variable
        int columnToDelete = 0;

        //Locate the table header columns
        List<WebElement> columnsHeader = table.findElements(By.tagName("th"));

        //Calculate the number of header columns
        int columnsCount = columnsHeader.size();

        //Loop through the header columns
        for (int columnHeader=0; columnHeader<columnsCount; columnHeader++){
            //Retrieve the text from the header cells
            String headerCellText = columnsHeader.get(columnHeader).getText();

            //Print help text
            System.out.println("Header cell value with column number " + columnHeader
                    + " is equal to " + headerCellText);

            //Compare the text of the header cell with the textToLocate
            if (headerCellText.equals(textToLocate)){
                //Remember the current header column + 1, because a list starts from 0, but the DOM starts from 1
                columnToDelete = columnHeader + 1;

                //Print help text
                System.out.println("The number of the column to delete is: " + columnToDelete);

                //Leave the loop
                break;
            }
        }
        //return the column number
        return columnToDelete;
    }

    private int locateRow(WebElement table, String itemToDeleteAndAdd){
        //Define variable
        int rowToDelete = 0;

        //Locate all the rows of the table
        List<WebElement> rowsTable = table.findElements(By.tagName("tr"));

        //Calculate the number of rows of the table
        int rowsCount = rowsTable.size();

        outerloop:
        //Loop through the rows of the table (start at 1, because 0 is the header row)
        for (int row = 1; row<rowsCount; row++){
            //Locate the table data cells per row
            List<WebElement> rowDataCells = rowsTable.get(row).findElements(By.tagName("td"));

            //Calculate the columns
            int columnsSize = rowDataCells.size();

            //Loop through the columns of the row
            for (int column = 0; column<columnsSize; column++){
                //Get the text of each cell in the row
                String cellText = rowDataCells.get(column).getText();

                //Print to help
                System.out.println("The cell on row " + row + " and column " + column + " has value " + cellText);

                //Compare the text of each cell with the text of the wishlist you want to delete
                if (cellText.equals(itemToDeleteAndAdd)){
                    //When the text is equal, remember the number of the row
                    rowToDelete = row; //is unnecessary, but I find it more clear

                    //Print the row
                    System.out.println("The row to delete is: " + rowToDelete);

                    //Leave the loop
                    break outerloop;
                }
            }
        }
        //Return row number
        return rowToDelete;
    }

    private void checkAlert(){
        //Wait for a possible alert
        wait.until(ExpectedConditions.alertIsPresent());

        //Check if an alert is triggered
        if (driver.switchTo().alert().getText().contains(" ")){
            //Accept the alert if it is triggered
            driver.switchTo().alert().accept();

            //Help text to know there was an alert
            System.out.println("Alert is accepted.");
        }
    }

    private void addWishlist(String itemToAdd){
        //Add the row again - Fill in the field en click on Save
        driver.findElement(By.xpath(".//*[@id='name']")).sendKeys(itemToAdd);
        driver.findElement(By.xpath(".//*[@id='submitWishlist']")).click();
    }
}