package ru.praktikum.diplom_3.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    public static void waitTillPageIsLoaded(WebDriver webDriver, String url) {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.urlToBe(url));
    }
}
