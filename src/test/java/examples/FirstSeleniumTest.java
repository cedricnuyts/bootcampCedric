package examples;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

public class FirstSeleniumTest {

    @Test
    public void logInSuccessFul(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        Boolean signOutKnop = driver.findElement(By.cssSelector("a.logout")).isDisplayed();
        String signOutText = driver.findElement(By.className("logout")).getText();

        assertKnopSignOut(signOutKnop);
        assertTextSignOut(signOutText);

        driver.quit();
    }

    private void assertTextSignOut(String text){

        Assertions.assertThat(text).as("Controle of login gelukt is.").contains("Sign out");
    }

    private void assertKnopSignOut(Boolean knop){

        Assertions.assertThat(knop).as("Controle of knop 'Sign out' beschikbaar is.").isTrue();
    }
}
