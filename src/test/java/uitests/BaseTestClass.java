package uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static SeleniumTest.testframework.DriverFactory.getChromeDriver;

public class BaseTestClass {

    public static final String Base_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeTest //@BeforeEach in Junit
    static void setup(){
        driver = getChromeDriver();
        //Create the driver Object
    }

    @AfterTest
    static void cleanUp(){
        driver.close();
    }
}
