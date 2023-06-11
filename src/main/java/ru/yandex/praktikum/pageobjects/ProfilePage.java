package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;
    private final By profileText = By.xpath(".//a[text()='Профиль']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By ConstructorTextButton = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.xpath(".//*[name()='svg' and @fill='none']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Выход на странице личного кабинета")
    public void clickExitButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    @Step("Нажатие на кнопку Конструктор")
    public void clickConstructorTextButton() {
        driver.findElement(ConstructorTextButton).click();
    }

    @Step("Нажатие на логотип")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Проверка видимости текста Профиль")
    public void checkProfileText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
        Assert.assertTrue(driver.findElement(profileText).isDisplayed());
    }
}
