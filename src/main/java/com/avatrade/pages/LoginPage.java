package com.avatrade.pages;

import com.avatrade.util.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class LoginPage extends BrowserUtil {

    WebDriver driver;

    public LoginPage(WebDriver driver){
         super(driver);
         this.driver = driver;
    }

    private By freeDemoButton = By.xpath("//a/span[text()=' Try free demo ']");

    public void clickFreeDemoButton(){
        hardPause(5);
        element(freeDemoButton).click();
    }

}
