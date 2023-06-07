package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.MainPage;
import ru.yandex.praktikum.pageobjects.PasswordRecoveryPage;
import ru.yandex.praktikum.pageobjects.RegistrationPage;

public class LoginTest extends GeneralTest {
    private final ConstantUserData user = new ConstantUserData();

    @Test
    @DisplayName("Проверка входа через главную страницу")
    @Description("Проверка входа через главную страницу")
    public void loginMainPageTest() {
        registrTestUser();
        mainPage = new MainPage(driver);
        mainPage.open();
        loginPage = mainPage.clickSiginButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        loginPage.clickSiginButton();
        mainPage.checkClickableCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через личный кабинет")
    @Description("Проверка входа через личный кабинет")
    public void LoginProfileButtonTest() {
        registrTestUser();
        mainPage = new MainPage(driver);
        mainPage.open();
        loginPage = mainPage.clickProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        loginPage.clickSiginButton();
        mainPage.checkClickableCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через форму регистрации")
    @Description("Проверка входа через форму регистрации")
    public void loginRegistrationPageTest() {
        registrTestUser();
        registerPage = new RegistrationPage(driver);
        registerPage.open();
        loginPage = registerPage.clickSiginButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        mainPage = loginPage.clickSiginButton();
        mainPage.checkClickableCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через форму восстановления пароля")
    @Description("Проверка входа через форму восстановления пароля")
    public void loginPasswordRecoveryPageTest() {
        registrTestUser();
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.open();
        loginPage = passwordRecoveryPage.clickSiginButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(user.getEmail());
        loginPage.passwordInput(user.getPassword());
        mainPage = loginPage.clickSiginButton();
        mainPage.checkClickableCreateOrderButton();
    }

}
