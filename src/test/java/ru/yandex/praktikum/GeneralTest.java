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
    WebDriver driver;
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

    private String token;
    @Before
    public void browserChange() {
        if (DRIVER_CHROME) {
            driver = new ChromeDriver();
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary(System.getProperty("webdriver.yandex.driver",  "C:\\WebDriver\\bin"));
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        RestAssured.baseURI = MAIN_PAGE;
        token = null;
    }

    @After
    public void closeBrowser() {
        driver.quit();
        if (token != null) requests.deleteUser(token.substring(7));
    }

    protected void registrTestUser() {
        String json = "{" + userLogin + "\"," + userName + "\"," + userPassword + "\"}";
        token = requests.registrUser(json);
    }

    protected void loginTestUser(String json) {
        token = requests.loginUser(json);
    }
}
