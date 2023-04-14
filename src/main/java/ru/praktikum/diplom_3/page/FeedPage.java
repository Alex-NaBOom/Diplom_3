package ru.praktikum.diplom_3.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedPage extends AbstractPage {
    public FeedPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By personalAccountLink = By.xpath("//p[text()='Личный Кабинет']");

    @Step("Open user profile")
    public void personalAccountLinkClick() {
        webDriver.findElement(personalAccountLink).click();
    }
}
