package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.BasketPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketTest extends BaseTest {
    private BasketPage basketPage;

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        basketPage = new BasketPage(driver);
    }

    @Test
    void testAddItemToBasket() {
        basketPage.goToWebsite();
        basketPage.acceptCookies();
        basketPage.navigateToCategories();
        basketPage.selectProduct("#subcategories > ul > li:nth-child(4) > h5 > a"); // Improved with parameters
        basketPage.selectProduct2(); // Improved with parameters
        basketPage.addItemToBasket();

        assertTrue(basketPage.isItemAddedMessageDisplayed(), "The confirmation message should be displayed.");
    }

    @AfterEach
    void tearDown() {
        super.tearDown(); // Call tearDown from BaseTest
    }
}
