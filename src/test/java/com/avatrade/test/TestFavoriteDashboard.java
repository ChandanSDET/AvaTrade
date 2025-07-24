package com.avatrade.test;

import com.avatrade.pages.CreateAccountPage;
import com.avatrade.pages.DashboardPage;
import com.avatrade.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(com.aventstack.chaintest.plugins.ChainTestListener.class)
public class TestFavoriteDashboard extends BaseTest{

    LoginPage loginpage;
    CreateAccountPage createAccountPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void initTest() {
        loginpage = new LoginPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void testFavoriteDashboard(){
        loginpage.clickFreeDemoButton();
        createAccountPage.createDemoAccount();
        dashboardPage.clearPopups();
        dashboardPage.clickCryptoLink();
        List<String> availableCryptosOnDashboard = dashboardPage.getAllListedCryptosOnDashboard(5);
        dashboardPage.selectFavoriteIconOfCryptos(availableCryptosOnDashboard);
        dashboardPage.clickFavoriteLink();
        dashboardPage.clickFirstItemOnDashboard();
        dashboardPage.validateSelectedCryptosUnderFavorite(availableCryptosOnDashboard);
    }

}
