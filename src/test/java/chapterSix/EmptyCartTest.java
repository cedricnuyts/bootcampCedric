package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

public class EmptyCartTest extends TestShopScenario{

    @Test
    public void emptyCart() throws InterruptedException {

        //check if cart is empty
        Boolean isEmpty = driver.findElement(By.xpath("//span[contains(text(), '(empty)')]")).isDisplayed();

        //if cart is empty, add item to cart
        if (isEmpty){
            fillCart();
        }

        //go to shopping cart
        driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();

        //remove item
        driver.findElement(By.className("icon-trash")).click();

        //check if cart is empty
        Assertions.assertThat(isEmpty).as("Cart is not empty.").isTrue();

    }

    private void fillCart(){
        //Click on ipod near tags
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();

        //Click on ipod shuffle name
        driver.findElement(By.xpath("//a[contains(text(), 'iPod shuffle')]")).click();

        //Click on Add to cart
        driver.findElement(By.id("add_to_cart")).click();

        //Wait until "Continue shopping" is clickable
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']")));

        //If the wait above does not work, use sleep
        //Thread.sleep(5000);

        //Click on continue shopping
        driver.findElement(By.cssSelector("span[title='Continue shopping']")).click();
    }
}
