package com.avatrade.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeLocatorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        Thread.sleep(5000);
        WebElement bestSeller =  driver.findElement(By.linkText("Bestsellers"));
        WebElement sell = driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(bestSeller));
        System.out.println(sell.getText());
        WebElement searchInput = driver.findElement(RelativeLocator.with(By.id("nav-logo-sprites")).above(bestSeller));
        System.out.println(searchInput.getDomAttribute("aria-label"));
        Thread.sleep(3000);
        driver.quit();
    }

}
