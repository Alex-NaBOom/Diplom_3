package ru.praktikum.diplom_3.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By emailInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");
    private By passwordInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private By registrationLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By signInBtn = By.xpath("//button[text()='Войти']"); //TODO buttonEnter
    private By passwordRecoveryLink = By.xpath("//a[text()='Восстановить пароль']");

    @Step("Enter email")
    public void setEmailInputSendKeys(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }
    @Step("Enter password")
    public void setPasswordInputSendKeys(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }
    @Step("Open registration page")
    public void registrationLinkClick() {
        webDriver.findElement(registrationLink).click();
    }
    @Step("Click sign in")
    public void signInBtnClick() {
        webDriver.findElement(signInBtn).click();
    }
    @Step("Open password recovery page")
    public void passwordRecoveryLinkClick() {
        webDriver.findElement(passwordRecoveryLink).click();
    }
}
