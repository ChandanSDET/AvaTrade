package com.avatrade.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrowserUtil {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    public BrowserUtil(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public WebElement element(By locator){
        return this.driver.findElement(locator);
    }

    public List<WebElement> elements(By locator){
        return this.driver.findElements(locator);
    }

    public void switchToFrame(By locator){
        this.driver.switchTo().frame(element(locator));
    }

    public void switchToDefaultContent(){
        this.driver.switchTo().defaultContent();
    }

    public void maximizeBrowser(){
        this.driver.manage().window().maximize();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void pressDownArrow(){
        this.actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    public void waitForElementToBeClickable(By locator){
        this.wait.until(ExpectedConditions.elementToBeClickable(element(locator)));
    }

    public void waitForPresenceOfElement(By locator){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void hardPause(int milliSecond){
        try {
            Thread.sleep(1000 * milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
