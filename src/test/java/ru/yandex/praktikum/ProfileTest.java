package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.MainPage;
import ru.yandex.praktikum.pageobjects.ProfilePage;

public class ProfileTest extends GeneralTest {
    private final ConstantUserData user = new ConstantUserData();

    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    @Description("Проверка перехода в личный кабинет")
    public void transitionPersonalTest() {
        registrTestUser();
        mainPage = new MainPage(driver);
        mainPage.open();
        loginPage = mainPage.clickProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        loginPage.clickSiginButton();
        mainPage.clickProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.checkProfileText();
    }

    @Test
    @DisplayName("Проверка перехода в конструктор через кнопку конструктор")
    @Description("Проверка перехода в конструктор через кнопку конструктор")
    public void transitionConstructorTest() {
        registrTestUser();
        mainPage = new MainPage(driver);
        mainPage.open();
        loginPage = mainPage.clickProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        loginPage.clickSiginButton();
        mainPage.clickProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.clickConstructorTextButton();
        mainPage.checkVisibleCollectBurgerText();
    }

    @Test
    @DisplayName("Проверка перехода в конструктор через логотип")
    @Description("Проверка перехода в конструктор через логотип")
    public void transitionByLogoTest() {
        registrTestUser();
        mainPage = new MainPage(driver);
        mainPage.open();
        loginPage = mainPage.clickProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        loginPage.clickSiginButton();
        mainPage.clickProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.clickLogo();
        mainPage.checkVisibleCollectBurgerText();
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта")
    @Description("Проверка выхода из аккаунта")
    public void ExitLoginTest() {
        registrTestUser();
        mainPage = new MainPage(driver);
        mainPage.open();
        loginPage = mainPage.clickProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        loginPage.clickSiginButton();
        mainPage.clickProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.clickExitButton();
        loginPage.checkClickableSiginButton();
    }
}
