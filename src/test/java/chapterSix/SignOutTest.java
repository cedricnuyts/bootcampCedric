package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignOutTest {

    @Test
    public void SignOut(){

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        Boolean signOutBtn = driver.findElement(By.cssSelector("a.logout")).isDisplayed();
        Assertions.assertThat(signOutBtn).as("Sign out button is not found on the page.").isTrue();

        Assertions.assertThat(driver.findElement(By.cssSelector("a.logout")).isDisplayed())
                .as("Sign out button is not found on the page.").isTrue();

        driver.findElement(By.cssSelector("a.logout")).click();

        Assertions.assertThat(driver.findElement(By.cssSelector("a.login")).isDisplayed())
                .as("Sign in button is not found on the page.").isTrue();

        driver.quit();

    }
}
