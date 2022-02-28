package com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MyFirstUITestRefactored {

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

    @Test
    void userNameIsCorrectOnOverviewTab(){
        //Arrange

        String user = "habibshahid2013";
        driver.get(Base_URL + user);

        //Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        //Assert

        assertEquals(user, actualUserName);

    }

    @Test
    void repoLinkGoesToCorrectRepo(){
        //Arrange

        String user = "habibshahid2013";
        driver.get(Base_URL + user);

        //Act
        String repo = "Solo-Project-MeditateWithMe";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        String actualURL = driver.getCurrentUrl();


        //Assert

        assertEquals("https://github.com/habibshahid2013/" + repo, actualURL);

    }

    @Test
    void repositoryCountIsCorrect(){
        //Arrange


        //Act
        driver.get("https://github.com/habibshahid2013?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));


        //Assert

        assertEquals(repos.size(), 30);


    }

}
