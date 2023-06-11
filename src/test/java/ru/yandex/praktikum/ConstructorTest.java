package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.MainPage;

public class ConstructorTest extends GeneralTest {

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    @Description("Проверка перехода к разделу Булки")
    public void transitionToBuns() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickBuns();
        mainPage.checkSectionBun();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    @Description("Проверка перехода к разделу Соусы")
    public void transitionToSauces() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauces();
        mainPage.checkSectionSauce();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    @Description("Проверка перехода к разделу Начинки")
    public void transitionToFillings() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillings();
        mainPage.checkSectionFilling();
    }
}
