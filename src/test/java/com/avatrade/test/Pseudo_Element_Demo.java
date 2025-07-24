package com.avatrade.test;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pseudo_Element_Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://play1.automationcamp.ir/advanced.html");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String txt = js.executeScript("return window.getComputedStyle(document.querySelector('.star-rating'),'::after').getPropertyValue('content')").toString();
        System.out.println(txt.replaceAll("\"", ""));
        driver.quit();
    }

}
