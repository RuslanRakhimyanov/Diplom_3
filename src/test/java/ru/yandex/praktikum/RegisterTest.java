package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.RegistrationPage;

public class RegisterTest extends GeneralTest {
    private final ConstantUserData user = new ConstantUserData();

    @Test
    @DisplayName("Проверка регистрации с валидными данными")
    @Description("Проверка регистрации с валидными данными>")
    public void RegistrationValidDataTest() {
        String name = "xxx" + user.getName();
        String email = "xxx" + user.getEmail();
        String password = "xxx" + user.getPassword();
        registerPage = new RegistrationPage(driver);
        registerPage.open();
        registerPage.nameInput(name);
        registerPage.emailInput(email);
        registerPage.passwordInput(password);
        loginPage = registerPage.clickRegistrationButton();
        loginPage.waitClicableSiginButton();
        loginPage.emailInput(email);
        loginPage.passwordInput(password);
        mainPage = loginPage.clickSiginButton();
        String json = "{" + "\"email\": \"" + email + "\"," + "\"password\": \"" + password + "\"}";
        loginTestUser(json);
        mainPage.checkClickableCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка регистрации с не валидным паролем")
    @Description("Проверка регистрации с не валидным паролем")
    public void RegistrationNoValidPasswordTest() {
        registerPage = new RegistrationPage(driver);
        registerPage.open();
        registerPage.nameInput(user.getName());
        registerPage.emailInput(user.getEmail());
        registerPage.passwordInput(user.getPasswordNoValid());
        registerPage.clickRegistrationButton();
        registerPage.checkInvalidPasswordText();
    }

}
