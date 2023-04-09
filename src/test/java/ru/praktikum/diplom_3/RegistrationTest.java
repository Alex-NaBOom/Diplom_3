package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom_3.config.Helper;
import ru.praktikum.diplom_3.page.LoginPage;
import ru.praktikum.diplom_3.page.MainPage;
import ru.praktikum.diplom_3.page.RegistrationPage;

public class RegistrationTest extends AbstractUITest{
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static RegistrationPage registrationPage;

    @Before
    public void setUp() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        mainPage.open();
        mainPage.personalAccountLinkClick();
        loginPage.registrationLinkClick();
        registrationPage.nameInputSendKeys(RandomStringUtils.randomAlphabetic(8));
        registrationPage.emailInputSendKeys(RandomStringUtils.randomAlphabetic(7) + "@gmail.com"); // TODO
    }

    @Test
    @DisplayName("Registration with correct password")
    public void successfulUserRegistration() {
        registrationPage.passwordInputSendKeys(RandomStringUtils.randomAlphabetic(6));
        registrationPage.registrationBtnClick();
        String expected = "https://stellarburgers.nomoreparties.site/login";
        Helper.waitTillPageIsLoaded(webDriver, expected);
        Assert.assertEquals("Cтраница входа пользователя должна быть видна", expected, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Registration with incorrect password")
    public void failedUserRegistration() {
        registrationPage.passwordInputSendKeys(RandomStringUtils.randomAlphabetic(5));
        registrationPage.registrationBtnClick();
        registrationPage.waitWarningVisibility();
        Assert.assertEquals("Предупреждение должно быть видимым", true, registrationPage.checkWarningVisibility());
    }
}
