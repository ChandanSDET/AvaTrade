package com.avatrade.pages;

import com.avatrade.util.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage extends BrowserUtil {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By popupFame = By.xpath("//iframe[@title='Iframe']");
    private By closeButton = By.xpath("//button[text()='Close']");
    private By skipTutorialButton = By.xpath("//span[@data-key='tourPopupButtonSkip']");
    private By cryptoLink = By.xpath("//a//div[text()='Crypto']");
    private By allDisplayedCryptos = By.xpath("//td//span[@data-qa='watchlist-entity__symbol-cell']");
    private By favoritesLink = By.xpath("//a//div[text()='Favorites']");

    public By favoriteIcon(String crypto){
        return By.xpath("//tr[td[div[span[text()='" + crypto + "']]]]/descendant::div[@data-qa='watchlist-entity__favorite-icon-cell-fav']");
    }

    public By firstItemOnDashboard(String currencyInCurrentUrl){
        return By.xpath("//td[div[span[text()='"  + currencyInCurrentUrl + "']]]");
    }

    public By crypto(String crypto){
        return By.xpath("//td[div[span[text()='" + crypto + "']]]");
    }

    public void clearPopups(){
        waitForPresenceOfElement(popupFame);
        switchToFrame(popupFame);
        waitForElementToBeClickable(closeButton);
        element(closeButton).click();
        switchToDefaultContent();
        waitForElementToBeClickable(skipTutorialButton);
        element(skipTutorialButton).click();
    }

    public void clickCryptoLink(){
        waitForElementToBeClickable(cryptoLink);
        element(cryptoLink).click();
    }

    public void clickFavoriteLink(){
        waitForElementToBeClickable(favoritesLink);
        element(favoritesLink).click();
    }

    public List<String> getAllListedCryptosOnDashboard(int maxLimit){
        return elements(allDisplayedCryptos)
                .stream()
                .limit(maxLimit)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectFavoriteIconOfCryptos(List<String> cryptos){
        for(String crypto: cryptos){
            WebElement favoriteIcon  = element(favoriteIcon(crypto));
            favoriteIcon.click();
            hardPause(2);
        }
    }

    public void clickFirstItemOnDashboard(){
        String currentCurrencyInUrl = getCurrentUrl().substring(getCurrentUrl().lastIndexOf("/") + 1);
        waitForElementToBeClickable(firstItemOnDashboard(currentCurrencyInUrl));
        element(firstItemOnDashboard(currentCurrencyInUrl)).click();
    }

    public void validateSelectedCryptosUnderFavorite(List<String> selectedCryptos){
        for(String selectedCrypto: selectedCryptos){
            WebElement cryptoUnderFavorite = null;
            Boolean isVisible = false;
            while(!isVisible) {
                try {
                    cryptoUnderFavorite = element(crypto(selectedCrypto));
                    isVisible = true;
                } catch (Exception e) {
                    pressDownArrow();
                }
            }
            Assert.assertTrue(cryptoUnderFavorite.isDisplayed());
        }
    }
}
