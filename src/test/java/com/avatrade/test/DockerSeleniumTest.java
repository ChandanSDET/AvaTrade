package com.avatrade.test;

import com.avatrade.listeners.TestListeners;
import com.avatrade.util.PropertiesFileUtil;
import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners(TestListeners.class)
public class DockerSeleniumTest {
    WebDriver driver;
    PropertiesFileUtil confUtil;
    @BeforeSuite
    public void cleanScreenshotDirectory() {
        File screenshotDir = new File("screenshots");
        if (screenshotDir.exists()) {
            for (File file : screenshotDir.listFiles()) {
                file.delete();
            }
        } else {
            screenshotDir.mkdirs();
        }
        System.out.println("Cleaned screenshots directory.");
    }
    @BeforeTest
    // @Parameters({"browser"})
    //public void initBrowser(String browser) throws MalformedURLException {
    public void initBrowser(ITestContext context) throws MalformedURLException {

        confUtil = new PropertiesFileUtil();
        System.out.println(confUtil.getProperty("application_url"));
        //System.out.println("Browser name is "+ browser);
        // if(Boolean.getBoolean("selenium.grid.enabled")) { // This will work if a pass the env variable form pom.xml
        System.out.println(confUtil.getProperty("selenium.grid.enabled"));
        if(Boolean.parseBoolean(confUtil.getProperty("selenium.grid.enabled"))) {
            // Connect to Selenium Grid running in Docker
            System.out.println(confUtil.getProperty("selenium.grid.enabled"));
            System.out.println(confUtil.getProperty("selenium.grid.hub.host"));
            URL seleniumServerUrl = new URL("http://"+confUtil.getProperty("selenium.grid.hub.host")+":4444/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            System.out.println("------>"+confUtil.getProperty("browser"));
            switch (confUtil.getProperty("browser")) {
            // switch (browser.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    throw new RuntimeException("Check your browser name");
            }


            driver = new RemoteWebDriver(seleniumServerUrl, capabilities);
            context.setAttribute("driver", this.driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else {
            driver =  new ChromeDriver();
            context.setAttribute("driver", this.driver);
        }
    }
    @AfterMethod
    public void sleep(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public  void test_main() {
        try {
            // Open Google and perform search
            driver.get("https://www.google.com");

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium Docker Java Test");
            searchBox.submit();

            // Wait and print title
            Thread.sleep(8000);
            System.out.println("Page title is: " + driver.getTitle());
            // Assert.assertTrue(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}