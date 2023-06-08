package ru.yandex.praktikum;

import org.apache.commons.lang3.RandomStringUtils;

public class ConstantUserData {
    private final String LoginIssue;
    private final String passwordIssue;
    private final String nameIssue;
    private final String email;
    private final String password;
    private final String name;
    private final String passwordIncorrect;

    public ConstantUserData() {
        email = "richard@mail.ru";
        password = "Qazx123";
        name = "Richard";
        passwordIncorrect = RandomStringUtils.randomAlphabetic(5);
        LoginIssue = "\"email\": \"" + email;
        nameIssue = "\"name\": \"" + name;
        passwordIssue = "\"password\": \"" + password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordNoValid() {
        return passwordIncorrect;
    }

    public String getPasswordIssue() {
        return passwordIssue;
    }

    public String getNameIssue() {
        return nameIssue;
    }

    public String getLoginIssue() {
        return LoginIssue;
    }
}
