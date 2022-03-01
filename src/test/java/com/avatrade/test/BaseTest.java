package com.avatrade.test;

import com.avatrade.util.BrowserUtil;
import com.avatrade.util.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void initClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        BrowserUtil browserUtil = new BrowserUtil(driver);
        PropertiesFileUtil properties = new PropertiesFileUtil();
        browserUtil.maximizeBrowser();
        driver.get(properties.getProperty("applicationUrl"));
    }

    @AfterMethod
    public void teardown() {
      driver.quit();
    }
}
