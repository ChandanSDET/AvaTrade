package com.avatrade.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Head_less_demo {
    public static void main(String[] args) {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless=new"); // Recommended for recent Chrome versions
        WebDriver driver = new ChromeDriver(opt);

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle()); // Optional: verify page load
        driver.quit();
    }
}
