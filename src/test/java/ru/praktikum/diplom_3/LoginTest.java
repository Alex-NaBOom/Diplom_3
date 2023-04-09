package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.diplom_3.config.Config;
import ru.praktikum.diplom_3.config.Helper;
import ru.praktikum.diplom_3.page.ForgotPasswordPage;
import ru.praktikum.diplom_3.page.LoginPage;
import ru.praktikum.diplom_3.page.MainPage;
import ru.praktikum.diplom_3.page.RegistrationPage;


public class LoginTest extends AbstractUITest{
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static RegistrationPage registrationPage;
    private static ForgotPasswordPage forgotPasswordPage;
    private String email = Config.getEmail();
    private String password = Config.getPassword();


    @Test
    @DisplayName("Sign in from main page")
    public void signInFromMainTest() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage.open();
        mainPage.signInBtnClick();
        loginPage.setEmailInputSendKeys(email);
        loginPage.setPasswordInputSendKeys(password);
        loginPage.signInBtnClick();
        String expected = "https://stellarburgers.nomoreparties.site/";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("site page should be visible", expected, webDriver.getCurrentUrl()); // TODO
    }

    @Test
    @DisplayName("Sign in from personal account")
    public void signInFromPersonalAccount() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage.open();
        mainPage.personalAccountLinkClick();
        loginPage.setEmailInputSendKeys(email);
        loginPage.setPasswordInputSendKeys(password);
        loginPage.signInBtnClick();
        String expected = "https://stellarburgers.nomoreparties.site/";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Страница сайта должна быть видимой", expected, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Sign in from registration form")
    public void signInFromRegistrationForm() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        mainPage.open();
        mainPage.personalAccountLinkClick();
        loginPage.registrationLinkClick();
        registrationPage.signInLinkClick();
        loginPage.setEmailInputSendKeys(email);
        loginPage.setPasswordInputSendKeys(password);
        loginPage.signInBtnClick();
        String expected = "https://stellarburgers.nomoreparties.site/";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Страница сайта должна быть видимой", expected, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Sign in from password recovery")
    public void signInFromPasswordRecovery() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        mainPage.open();
        mainPage.signInBtnClick();
        loginPage.passwordRecoveryLinkClick();
        forgotPasswordPage.signInLinkClick();
        loginPage.setEmailInputSendKeys(email);
        loginPage.setPasswordInputSendKeys(password);
        loginPage.signInBtnClick();
        String expected = "https://stellarburgers.nomoreparties.site/";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Страница сайта должна быть видимой", expected, webDriver.getCurrentUrl());
    }
}
