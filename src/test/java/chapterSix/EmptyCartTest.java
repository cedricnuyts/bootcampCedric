package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

public class EmptyCartTest extends TestShopScenario{

    @Test
    public void emptyCart() {

        //check if cart is empty
        //if cart is empty, add item to cart
        if (driver.findElement(By.xpath("//span[contains(text(), '(empty)')]")).isDisplayed()){
            fillCart();
        }

        //go to shopping cart
        driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();

        //remove item
        driver.findElement(By.className("icon-trash")).click();

        //wait for alert to be visible
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '(empty)')]")));

        //check if cart is empty
        Assertions.assertThat(driver.findElement(By.xpath("//span[contains(text(), '(empty)')]")).isDisplayed())
                .as("Cart is not empty.").isTrue();

    }

    private void fillCart(){
        //Click on ipod near tags
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();

        //Click on ipod shuffle name
        driver.findElement(By.xpath("//a[contains(text(), 'iPod shuffle')]")).click();

        //Click on Add to cart
        driver.findElement(By.id("add_to_cart")).click();

        //Wait until "Continue shopping" is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']")));

        //Click on continue shopping
        driver.findElement(By.cssSelector("span[title='Continue shopping']")).click();
    }
}
