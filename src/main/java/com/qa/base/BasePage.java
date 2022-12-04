package com.qa.base;

import com.qa.util.TestDataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static Properties prop;
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    /**
     * Constructor Initialization Of Configuration File
     */
    public BasePage(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
            prop.load(ip);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
