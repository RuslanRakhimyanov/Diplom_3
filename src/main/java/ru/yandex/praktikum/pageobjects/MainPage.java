package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

import static ru.yandex.praktikum.Endpoins.MAIN_PAGE;

public class MainPage {
    private final WebDriver driver;
    private final By profileButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By collectBurgerText = By.xpath(".//h1[text()='Соберите бургер']");
    private final By bunsTab = By.xpath(".//span[text()='Булки']/..");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']/..");
    private final By lastTabElement = By.xpath(".//p[text()='Сыр с астероидной плесенью']");
    private final By siginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(MAIN_PAGE);
    }

    @Step("Прокрутка меню до последнего элемента")
    public void scrollingTabDown() {
        WebElement element = driver.findElement(lastTabElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Выбор вкладки Булки")
    public void clickBuns() {
        scrollingTabDown();
        driver.findElement(bunsTab).click();
    }

    @Step("Проверка, что открыт раздел Булки")
    public void checkSectionBun() {
        String text = driver.findElement(bunsTab).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_tab_type_current__2BEPc"));
    }

    @Step("Выбор вкладки Соусы")
    public void clickSauces() {
        scrollingTabDown();
        driver.findElement(saucesTab).click();
    }

    @Step("Проверка, что открыт раздел Соусы")
    public void checkSectionSauce() {
        String text = driver.findElement(saucesTab).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_tab_type_current__2BEPc"));
    }

    @Step("Выбор вкладки Начинки")
    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверка, что открыт раздел Начинки")
    public void checkSectionFilling() {
        String text = driver.findElement(fillingsTab).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_tab_type_current__2BEPc"));
    }

    @Step("Нажатие кнопки <Войти в аккаунт> на главной странице")
    public LoginPage clickSiginButton() {
        driver.findElement(siginButton).click();
        return new LoginPage(driver);
    }

    @Step("Проверка видимости текста Соберите бургер")
    public void checkVisibleCollectBurgerText() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(collectBurgerText));
        Assert.assertTrue(driver.findElement(collectBurgerText).isDisplayed());
    }

    @Step("Проверка доступности кнопки Оформить заказ")
    public void checkClickableCreateOrderButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        Assert.assertTrue(driver.findElement(createOrderButton).isDisplayed());
    }

    @Step("Нажатие кнопки Личный кабинет на главной странице")
    public LoginPage clickProfileButton() {
        driver.findElement(profileButton).click();
        return new LoginPage(driver);
    }
}
