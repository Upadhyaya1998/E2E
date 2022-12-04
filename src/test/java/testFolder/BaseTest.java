package testFolder;

import com.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends BasePage {

    public String gridURL = "http://34.121.74.164:4444/wd/hub";

    @BeforeMethod(groups = {"smoke","sanity","reg"})
    public void setUp() throws MalformedURLException {
        System.out.println("Before Test");
        System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/src/main/resources/WebDrivers/chromedriver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("use-fake-device-for-media-stream");
        chromeOptions.addArguments("use-fake-ui-for-media-stream");
        chromeOptions.addArguments("auto-select-desktop-capture-source=Entire screen");
        chromeOptions.addArguments("auto-select-desktop-capture-source=Entire screen");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        if(prop.getProperty("local").equals("Yes")){
            driver.set(new ChromeDriver());
        }
        else{
            driver.set(new RemoteWebDriver(new URL(gridURL), capabilities));
        }
        getDriver().get("https://google.com/");
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod(groups = {"smoke","sanity","reg"})
    public void tearDown(){
        getDriver().quit();
    }

}
