package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.CheckOutPage;

public class E2E_CheckOutTest extends BaseTest {
    private LoginPage loginPage;
    private CheckOutPage checkOutPage;

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        loginPage = new LoginPage(driver); // Initialize LoginPage
        checkOutPage = new CheckOutPage(driver); // Initialize CheckOutPage
    }

    @Test
    void testCheckOutProcess() {
        driver.get("https://www.agropataki.ro/ro/"); // Go to website
        loginPage.acceptCookies(); // Accept cookies
        loginPage.navigateToLoginPage(); // Navigate to the login form
        loginPage.fillLoginForm("$@a.com", "$$$$$$$$"); // Replace with actual credentials
        loginPage.clickLoginButton(); // Click the login button

        // Perform search and checkout
        checkOutPage.enterSearchTerm("pepene"); // Write "pepene"
        checkOutPage.clickSearchButton(); // Click the search button
        checkOutPage.addProductToBasket(); // Add product to basket
        checkOutPage.goToBasket(); // Go to basket
        checkOutPage.clickOrderButton(); // Click on order button
        // Fill in checkout details
        System.out.println("so ales");
        checkOutPage.fillCheckoutDetails("John", "Doe", "123 Street Name", "445100", "0749999999");

        System.out.println("nume si tot so scris da nu si tara");

//        checkOutPage.clickOrderButton(); // Click on order button
    }

    @AfterEach
    void tearDown() {
        super.tearDown(); // Call tearDown from BaseTest
    }
}