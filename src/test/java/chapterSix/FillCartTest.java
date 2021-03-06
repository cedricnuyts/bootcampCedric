package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

public class FillCartTest extends TestShopScenario {

    @Test
    public void fillCart(){

        //check if cart is empty
        Boolean isEmpty = driver.findElement(By.xpath("//span[contains(text(), '(empty)')]")).isDisplayed();
        Assertions.assertThat(isEmpty).as("Cart is not empty.").isTrue();

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

        //check if cart has 1 item
        String strNumberOfItems = driver.findElement(By.cssSelector("span.ajax_cart_quantity")).getText();
        int intNumberOfItems = Integer.parseInt(strNumberOfItems);
        Assertions.assertThat(intNumberOfItems).as("The cart is empty.").isNotEqualTo(0);
        Assertions.assertThat(intNumberOfItems).as("There is more than 1 item in the cart.").isEqualTo(1);

    }
}
