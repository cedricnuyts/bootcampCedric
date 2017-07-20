package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

public class FillCartTest extends TestShopScenario {

    @Test
    public void fillCart(){

        //check if cart is empty
        Assertions.assertThat(driver.findElement(By.cssSelector("span.ajax_cart_no_product")).isDisplayed())
                .as("Cart is not empty.").isTrue();

    }
}
