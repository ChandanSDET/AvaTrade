package com.avatrade.pages;

import com.avatrade.util.BrowserUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class CreateAccountPage extends BrowserUtil {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By firstNameInput = By.id("name");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("email");
    private By phoneInput = By.id("phoneInput");
    private By createAccountButton = By.id("avaWidgetSubmit");

    public void createDemoAccount(){
        Faker faker = new Faker();
        waitForPresenceOfElement(firstNameInput);
        element(firstNameInput).sendKeys(faker.name().firstName());
        element(lastNameInput).sendKeys(faker.name().lastName());
        element(emailInput).sendKeys(faker.internet().emailAddress());
        element(phoneInput).sendKeys(faker.phoneNumber().cellPhone());
        waitForElementToBeClickable(createAccountButton);
        element(createAccountButton).click();
    }
}
