package tests;

import pages.BasketPage;
import utils.webUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketTest {
    private WebDriver driver;
    private BasketPage basketPage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        basketPage = new BasketPage(driver);
    }

    @Test
    void testAddItemToBasket() {
        // Step 1: Navigate to the website and accept cookies
        basketPage.goToWebsite();
        basketPage.acceptCookies();

        // Step 2: Navigate to product categories
        basketPage.navigateToCategories();

        // Step 3: Select a product
        basketPage.selectProduct();

        // Step 4: Select a product
        basketPage.selectProduct2();

        // Step 5: Add product to the basket
        basketPage.addItemToBasket();

        // Step 6: Verify the confirmation message
        assertTrue(basketPage.isItemAddedMessageDisplayed(), "The confirmation message should be displayed.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
