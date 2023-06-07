package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By siginButton = By.xpath(".//button[text()='Войти']");
    private final By emailInput = By.xpath(".//input[@name = 'name']");
    private final By passwordInput = By.xpath(".//input[@name = 'Пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод Email")
    public void emailInput(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void passwordInput(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Ожидание доступности кнопки Войти")
    public void waitClicableSiginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(siginButton));
    }

    @Step("Проверка доступности кнопки Войти")
    public void checkClickableSiginButton() {
        waitClicableSiginButton();
        Assert.assertTrue(driver.findElement(siginButton).isDisplayed());
    }

    @Step("Нажатие на кнопку Войти")
    public MainPage clickSiginButton() {
        driver.findElement(siginButton).click();
        return new MainPage(driver);
    }
}
