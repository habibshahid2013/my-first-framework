package com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MYFirstUITest {

    @Test
    void userNameIsCorrectOnOverviewTab(){


        //Arrange
        System.setProperty("webdriver.chrome.driver", "/Users/hshahid/Documents/chromedriver 8");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "habibshahid2013";
        driver.get("https://github.com/" + user);

        //Act
          String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        //Assert

        Assert.assertEquals(user, actualUserName);

        driver.close();


    }

    @Test
    void repoLinkGoesToCorrectRepo(){

        //Arrange

        System.setProperty("webdriver.chrome.driver", "/Users/hshahid/Documents/chromedriver 8");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "habibshahid2013";
        driver.get("https://github.com/" + user);

        //Act
        String repo = "Solo-Project-MeditateWithMe";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        String actualURL = driver.getCurrentUrl();


        //Assert

        Assert.assertEquals("https://github.com/habibshahid2013/" + repo, actualURL);

        driver.close();
    }

    @Test
    void repositoryCountIsCorrect(){
        //Arrange
        System.setProperty("webdriver.chrome.driver", "/Users/hshahid/Documents/chromedriver 8");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Act
        driver.get("https://github.com/habibshahid2013?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));


        //Assert

        Assert.assertEquals(repos.size(), 30);

        driver.close();
    }

}
