package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.Endpoins.REGISTRATION_PAGE;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameInput = By.xpath(".//div/label[text()='Имя']/../input");
    private final By emailInput = By.xpath(".//div/label[text()='Email']/../input");
    private final By passwordInput = By.xpath(".//div/label[text()='Пароль']/../input");
    private final By RegistrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By siginButton = By.xpath(".//a[text()='Войти']");
    private final By InvalidPasswordText = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы Регистрация")
    public void open() {
        driver.get(REGISTRATION_PAGE);
    }

    @Step("Нажатие кнопки Войти на странице Регистрации")
    public LoginPage clickSiginButton() {
        driver.findElement(siginButton).click();
        return new LoginPage(driver);
    }

    @Step("Ввод имени")
    public void nameInput(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
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

    @Step("Нажатие на кнопку регистрации")
    public LoginPage clickRegistrationButton() {
        driver.findElement(RegistrationButton).click();
        return new LoginPage(driver);
    }

    @Step("Проверка текста ошибки онеправильнм пароле")
    public void checkInvalidPasswordText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(InvalidPasswordText));
        Assert.assertTrue(driver.findElement(InvalidPasswordText).isDisplayed());
    }
}
