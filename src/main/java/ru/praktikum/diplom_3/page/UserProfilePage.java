package ru.praktikum.diplom_3.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage extends AbstractPage {
    public UserProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    private By linkToMain = By.xpath("/html/body/div/div/header/nav/div/a");
    private By feedLink = By.xpath("//p[text()='Лента Заказов']");
    private By constructorLink = By.xpath("//p[text()='Конструктор']");

    @Step("Click to go back to main")
    public void linkToMainClick() {
        webDriver.findElement(linkToMain).click();
    }

    @Step("Click to go to order list")
    public void linkToFeedlick() {
        webDriver.findElement(feedLink).click();
    }

    @Step("Click to go to constructor")
    public void linkToConstructorlick() {
        webDriver.findElement(constructorLink).click();
    }
}
