package ru.yandex.praktikum;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.equalTo;
import static ru.yandex.praktikum.Endpoins.*;

public class Requests {

    @Step("запрос на авторизацию пользователя")
    public String loginUser(String json) {
        return given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(HTTP_OK)
                .and()
                .body("success", equalTo(true))
                .extract().path("accessToken");
    }

    @Step("Запрос на создание нового пользователя")
    public String registrUser(String json) {
        return given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(REGISTER)
                .then()//.log().all()
                .assertThat()
                .statusCode(HTTP_OK)
                .and()
                .body("success", equalTo(true))
                .extract().path("accessToken");
    }
}
