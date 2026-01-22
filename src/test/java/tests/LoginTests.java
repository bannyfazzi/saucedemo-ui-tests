package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestUsers;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    void successfulLoginTest() {
        step("Открываем страницу логина и вводим валидные данные пользователя", () -> {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(TestUsers.STANDARD_USER, TestUsers.PASSWORD);
        });

        step("Проверяем, что пользователь успешно авторизован и открыта страница товаров", () -> {
            InventoryPage inventoryPage = new InventoryPage(driver);
            assertTrue(inventoryPage.isPageOpened());
        });
    }

    @Test
    void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        step("Вводим валидный логин и невалидный пароль", () -> {
            loginPage.login(TestUsers.STANDARD_USER, "wrong_password");
        });

        step("Проверяем отображение ошибки о неверных учетных данных", () -> {
            assertTrue(loginPage.getErrorMessage()
                    .contains("Username and password do not match"));
        });
    }

    @Test
    void lockedUserTest() {
        LoginPage loginPage = new LoginPage(driver);

        step("Пытаемся войти под заблокированным пользователем", () -> {
            loginPage.login(TestUsers.LOCKED_USER, TestUsers.PASSWORD);
        });

        step("Проверяем сообщение о блокировке пользователя", () -> {
            assertTrue(loginPage.getErrorMessage().contains("locked out"));
        });
    }

    @Test
    void emptyFieldsTest() {
        LoginPage loginPage = new LoginPage(driver);

        step("Пытаемся авторизоваться с пустыми полями логина и пароля", () -> {
            loginPage.login("", "");
        });

        step("Проверяем сообщение об обязательности заполнения логина", () -> {
            assertTrue(loginPage.getErrorMessage().contains("Username is required"));
        });
    }

    @Test
    void performanceUserTest() {
        LoginPage loginPage = new LoginPage(driver);

        step("Авторизуемся пользователем с возможными задержками загрузки", () -> {
            loginPage.login(TestUsers.PERFORMANCE_USER, TestUsers.PASSWORD);
        });

        step("Ожидаем успешную загрузку страницы товаров", () -> {
            InventoryPage inventoryPage = new InventoryPage(driver);
            assertTrue(inventoryPage.isPageOpened());
        });
    }
}
