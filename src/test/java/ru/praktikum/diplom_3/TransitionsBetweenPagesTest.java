package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom_3.config.Config;
import ru.praktikum.diplom_3.config.Helper;
import ru.praktikum.diplom_3.page.FeedPage;
import ru.praktikum.diplom_3.page.LoginPage;
import ru.praktikum.diplom_3.page.MainPage;
import ru.praktikum.diplom_3.page.UserProfilePage;

public class TransitionsBetweenPagesTest extends AbstractUITest {
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static FeedPage feedPage;
    private static UserProfilePage userProfilePage;
    private String email = Config.getEmail();
    private String password = Config.getPassword();

    @Before
    public void setUp() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage.open();
        mainPage.signInBtnClick();
        loginPage.setEmailInputSendKeys(email);
        loginPage.setPasswordInputSendKeys(password);
        loginPage.signInBtnClick();
    }

    @Test
    @DisplayName("Checking transition from main page to personal account")
    public void transitionFromMainToPersonalAccount() {
        userProfilePage = new UserProfilePage(webDriver);
        userProfilePage.linkToMainClick();
        mainPage.personalAccountLinkClick();
        String expected = "https://stellarburgers.nomoreparties.site/account/profile";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Личный кабинет должен быть открыт", expected, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Checking transition from feed to personal account")
    public void transitionFromFeedToPersonalAccount() {
        userProfilePage = new UserProfilePage(webDriver);
        feedPage = new FeedPage(webDriver);
        userProfilePage.linkToFeedlick();
        feedPage.personalAccountLinkClick();
        String expected = "https://stellarburgers.nomoreparties.site/account/profile";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Личный кабинет должен быть открыт", expected, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Checking transition from constructor to personal account")
    public void transitionFromConstructorToPersonalAccount() {
        userProfilePage = new UserProfilePage(webDriver);
        mainPage = new MainPage(webDriver);
        userProfilePage.linkToConstructorlick();
        mainPage.personalAccountLinkClick();
        String expected = "https://stellarburgers.nomoreparties.site/account/profile";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Личный кабинет должен быть открыт", expected, webDriver.getCurrentUrl());
    }
}