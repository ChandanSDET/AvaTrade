package com.avatrade.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) result.getTestContext().getAttribute("driver");
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + result.getMethod().getMethodName() + ".png");

        // Create the directory if it doesn't exist
        destFile.getParentFile().mkdirs();
        try {
            // Copy file to destination
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

}
