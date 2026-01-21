package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу логина")
    public void open() {
        log.info("Открываем страницу логина: https://www.saucedemo.com/");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Выполнить вход с логином: {username}")
    public void login(String username, String password) {
        log.info("Вводим логин: {}", username);
        driver.findElement(By.id("user-name")).sendKeys(username);

        log.info("Вводим пароль (не логируем содержимое)");
        driver.findElement(By.id("password")).sendKeys(password);

        log.info("Нажимаем кнопку Login");
        driver.findElement(By.id("login-button")).click();
    }

    @Step("Получить сообщение об ошибке авторизации")
    public String getErrorMessage() {
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        log.warn("Отображено сообщение об ошибке: {}", error);
        return error;
    }
}
