package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.LoginPage;
import pages.LogoutPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketTest extends BaseTest {
    private BasketPage basketPage;
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        basketPage = new BasketPage(driver);
        loginPage = new LoginPage(driver); // Initialize LoginPage
        logoutPage = new LogoutPage(driver);
    }

    @Test
    void testAddItemToBasket() {
        basketPage.goToWebsite();
        basketPage.acceptCookies();

        // Perform login actions
//        loginPage.goTo(); // Go to the login page
//        loginPage.acceptCookies(); // Accept cookies on the login page
        loginPage.navigateToLoginPage(); // Navigate to the login form
        loginPage.fillLoginForm("$@a.com", "$$$$$$$$"); // Replace with actual credentials
        loginPage.clickLoginButton(); // Click the login button

        // Continue with basket actions
        basketPage.navigateToCategories();
        basketPage.selectProduse(); // Select first product
        basketPage.selectsubProdus(); // Select second product
        basketPage.addItemToBasket(); // Add items to basket
        System.out.println("Item added to the Basket");
        basketPage.closeTab();
        basketPage.click();
        basketPage.click2();
        basketPage.QuantityUp();
        System.out.println("Item was succesfully added");
        basketPage.RemoveItem();
        System.out.println("Item was succesuflly removed");
        logoutPage.clickProfileButton();
        logoutPage.clickLogoutButton();
        System.out.println("Logged out succesfully");


    }

    @AfterEach
    void tearDown() {
        super.tearDown(); // Call tearDown from BaseTest
    }
}
