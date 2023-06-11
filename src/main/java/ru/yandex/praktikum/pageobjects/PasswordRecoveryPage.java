package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.Endpoins.PASSWORDRECOVERY_PAGE;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    private final By siginButton = By.linkText("Войти");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы Восстановление пароля")
    public void open() {
        driver.get(PASSWORDRECOVERY_PAGE);
    }

    @Step("Нажатие на кнопку Войти на странице Восстановление пароля")
    public LoginPage clickSiginButton() {
        driver.findElement(siginButton).click();
        return new LoginPage(driver);
    }
}
