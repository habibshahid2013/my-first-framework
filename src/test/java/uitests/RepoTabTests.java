package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RepoTabTests extends BaseTestClass{

    @Test
    void repositoryCountIsCorrect(){
        //Act
        driver.get("https://github.com/habibshahid2013?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        //Assert

        assertEquals(repos.size(), 30);

    }
}
