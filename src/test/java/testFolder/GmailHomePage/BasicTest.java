package testFolder.GmailHomePage;

import com.qa.pages.GoogleHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testFolder.BaseTest;

public class BasicTest extends BaseTest {

    GoogleHomePage googleHomePage = new GoogleHomePage();

    @Test(groups = {"smoke"})
    public void testOne() throws InterruptedException {
        System.out.println("Smoke One");
        Thread.sleep(2000);
        System.out.println(getDriver().getTitle());
    }

    @Test(groups = {"sanity"})
    public void testTwo() throws InterruptedException {
        System.out.println("Santy One");
        getDriver().findElement(By.partialLinkText("Gmail")).click();
        Thread.sleep(2000);
        System.out.println(getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(),"Gmail: Private and secure email at no cost | Google Workspace");
    }

    @Test(groups = {"smoke"})
    public void testThree() throws InterruptedException {
        System.out.println("Smoke Two");
        getDriver().findElement(By.partialLinkText("Images")).click();
        Thread.sleep(2000);
        System.out.println(getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(),"Google Images");
    }

    @Test(groups = {"sanity"})
    public void testFour() throws InterruptedException {
        System.out.println("Santy Two");
        Thread.sleep(2000);
        System.out.println(getDriver().getTitle());
        Assert.assertTrue(googleHomePage.validateResults());
    }
}

