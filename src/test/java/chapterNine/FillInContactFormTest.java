package chapterNine;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

public class FillInContactFormTest extends TestShopScenario{

    @Test
    public void fillInContactForm(){
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();
    }
}
