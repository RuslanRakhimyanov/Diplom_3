package ru.yandex.praktikum;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.pageobjects.*;

import static ru.yandex.praktikum.Endpoins.DRIVER_CHROME;
import static ru.yandex.praktikum.Endpoins.MAIN_PAGE;

public class GeneralTest {
    private final Requests requests = new Requests();
    private final ConstantUserData userAccountData = new ConstantUserData();
    private final String userLogin = userAccountData.getLoginIssue();
    private final String userPassword = userAccountData.getPasswordIssue();
    private final String userName = userAccountData.getNameIssue();
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected ProfilePage profilePage;
    protected RegistrationPage registerPage;
    protected PasswordRecoveryPage passwordRecoveryPage;
    protected WebDriver driver;

    @Before
    public void browserChange() {
        if (DRIVER_CHROME) {
            driver = new ChromeDriver();
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary(System.getProperty("user.home") + "\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        RestAssured.baseURI = MAIN_PAGE;
    }

    @After
    public void closeDelete() {
        driver.quit();
    }

    protected void registrTestUser() {
        String json = "{" + userLogin + "\"," + userName + "\"," + userPassword + "\"}";
        requests.registrUser(json);
    }

    protected void loginTestUser(String json) {
        requests.loginUser(json);
    }
}
