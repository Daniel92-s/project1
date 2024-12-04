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
        basketPage.selectProduct(); // Improved with parameters
        basketPage.addItemToBasket();

        assertTrue(basketPage.isItemAddedMessageDisplayed(), "Produs adăugat cu succes în coșul de cumpărături");
        System.out.println("Item added to the Basket");
    }

    @AfterEach
    void tearDown() {
        super.tearDown(); // Call tearDown from BaseTest
    }
}
