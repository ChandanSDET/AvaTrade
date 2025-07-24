package com.avatrade.test;

import com.avatrade.util.BrowserUtil;
import com.avatrade.util.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void initClass() throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities dc;

        System.out.println(System.getProperty("BROWSER"));
        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = new FirefoxOptions();
        }else{
            dc = new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        System.out.println(host);
        // String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":80/wd/hub";
        //dc.setCapability("name", testName);
        //this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        this.driver = new ChromeDriver();
        this.driver.get(new PropertiesFileUtil().getProperty("applicationUrl"));
    }

    @AfterMethod
    public void teardown() {
      this.driver.quit();
    }
}
