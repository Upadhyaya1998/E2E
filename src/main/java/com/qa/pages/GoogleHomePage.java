package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.By;

public class GoogleHomePage extends BasePage {

    public boolean validateResults(){
        boolean a = driver.get().findElement(By.partialLinkText("Gmail")).isDisplayed();
        boolean b = driver.get().findElement(By.partialLinkText("Images")).isDisplayed();

        return a&b;
    }
}
