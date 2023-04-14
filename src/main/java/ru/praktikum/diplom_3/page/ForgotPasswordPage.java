package ru.praktikum.diplom_3.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends AbstractPage {
    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By signInLink = By.xpath("//a[text()='Войти']");

    @Step("Click sign in")
    public void signInLinkClick() {
        webDriver.findElement(signInLink).click();
    }
}
