package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class InventoryPage {

    private static final Logger log = LoggerFactory.getLogger(InventoryPage.class);

    private WebDriver driver;

    private By inventoryContainer = By.id("inventory_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверяем что страница товаров успешно открылась")
    public boolean isPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));

        log.info("Страница Inventory успешно загружена и видна");
        return true;
    }
}
