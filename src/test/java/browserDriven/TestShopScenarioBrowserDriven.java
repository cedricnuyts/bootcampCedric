package browserDriven;

import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.Browser browser){
        //init driver
        //ChromeDriverManager.getInstance().setup();
        //driver = new ChromeDriver();

        //new basic method to init driver
        //driver = BrowserFactoryBasic.getDriver("chrome");

        //new medior method to init driver
        //driver = BrowserFactoryMedior.getDriver("Chrome");

        //new advanced method with enum to init driver
        //driver = BrowserFactoryAdvanced.setBrowser(BrowserFactoryAdvanced.Browser.CHROME);

        //new BrowserDriven method to set driver
        driver = BrowserFactoryAdvanced.setBrowser(browser);

        //init wait for explicit
        wait = new WebDriverWait(driver,10);

        //Maximize the window
        //driver.manage().window().maximize();

        //Go to the website
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown(){
        //Close the driver
        driver.quit();
    }

}
