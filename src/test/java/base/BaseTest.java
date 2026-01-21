package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import utils.DriverFactoryUtil;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    void setUp() {
        String browser = System.getProperty("browser", "chrome");
        log.info("Запуск теста. Выбран браузер: {}", browser);

        driver = DriverFactoryUtil.createDriver(browser);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        loginPage.open();
        log.info("Браузер открыт и загружена страница логина");
    }

    @AfterEach
    void tearDown() {
        log.info("Завершаем тест, закрываем браузер");
        if (driver != null) {
            driver.quit();
        }
    }
}
