package com.avatrade.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FindBrokenLinks {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> links_we = driver.findElements(By.tagName("a"));
        List<String> links =  links_we.stream().map(lw -> lw.getDomAttribute("href")).collect(Collectors.toList());
        System.out.println(links);
        for(String link: links){
            checkUrl(link);
        }
        driver.quit();
    }

    public static void checkUrl(String url)  {
        try {
            HttpURLConnection connection = null;
            if(!url.contains("http")) {
                connection = (HttpURLConnection) new URL("https://the-internet.herokuapp.com" + url).openConnection();
            } else{
                connection = (HttpURLConnection) new URL(url).openConnection();
            }
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setInstanceFollowRedirects(true);

            int statusCode = connection.getResponseCode();

            if (statusCode >= 400) {
                System.out.println("❌ Broken link: " + url + " -> Status Code: " + statusCode);
            } else {
                System.out.println("✅ Valid link: " + url + " -> Status Code: " + statusCode);
            }
        }catch (IOException e){
            System.out.println("⚠️ Error checking link: " + url + " -> " + e.getMessage());
        }

    }
}
