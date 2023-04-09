package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.diplom_3.config.Config;
import ru.praktikum.diplom_3.page.MainPage;

public class TransitionsBetweenPageObjectsTest extends AbstractUITest{
    private static MainPage mainPage;

    @Test
    @DisplayName("Checking that buns are selected by default")
    public void bunsAreSelectedByDefault() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        String expected = Config.getActiveSection();
        String actual = mainPage.getBunClass();
        Assert.assertTrue("Активный раздел должен иметь определенный класс", actual.contains(expected));
    }

    @Test
    @DisplayName("Checking transition from buns to sauces")
    public void transitionFromBunsToSauces() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.saucesSectionClick();
        String actual = mainPage.getSaucesClass();
        String expected = Config.getActiveSection();
        Assert.assertTrue("Активный раздел должен иметь определенный класс", actual.contains(expected));
    }

    @Test
    @DisplayName("Checking transition from buns to sauces and then to fillings")
    public void transitionFromSaucesToFillings() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.saucesSectionClick();
        mainPage.fillingsSectionClick();
        String actual = mainPage.getFillingsClass();
        String expected = Config.getActiveSection();
        Assert.assertTrue("Активный раздел должен иметь определенный класс", actual.contains(expected));

    }

    @Test
    @DisplayName("Checking transition from buns to sauces then to fillings and then to buns")
    public void transitionFromFillingsToBuns() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.saucesSectionClick();
        mainPage.fillingsSectionClick();
        mainPage.bunsSectionClick();
        String actual = mainPage.getBunClass();
        String expected = Config.getActiveSection();
        Assert.assertTrue("active section should have a current class", actual.contains(expected));

    }

}
