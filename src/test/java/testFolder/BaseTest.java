package testFolder;

import com.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage {


    @BeforeMethod(groups = {"smoke","sanity"})
    public void setUp(){
        System.out.println("Before Test");
        System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/src/main/resources/WebDrivers/chromedriver");
        driver.set(new ChromeDriver());
        getDriver().get("https://google.com/");

    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod(groups = {"smoke","sanity"})
    public void tearDown(){
        getDriver().quit();
    }

}
