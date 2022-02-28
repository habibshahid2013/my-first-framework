package uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    public static final String Base_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeTest //@BeforeEach in Junit
    static void setup(){
        //Create the driver Object
        System.setProperty("webdriver.chrome.driver", "/Users/hshahid/Documents/chromedriver 8");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    static void cleanUp(){
        driver.close();
    }
}
