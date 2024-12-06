package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SearchPage;

public class E2E_SearchTest extends BaseTest {
    private LoginPage loginPage;
    private SearchPage searchPage;

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        loginPage = new LoginPage(driver); // Initialize LoginPage
        searchPage = new SearchPage(driver); // Initialize SearchPage
    }

    @Test
    void testSearchForItem() {
        driver.get("https://www.agropataki.ro/ro/"); // Go to website
        loginPage.acceptCookies(); // Accept cookies
        loginPage.navigateToLoginPage(); // Navigate to the login form
        loginPage.fillLoginForm("$@a.com", "$$$$$$$$"); // Replace with actual credentials
        loginPage.clickLoginButton(); // Click the login button

        // Perform search
//        searchPage.clickSearchButton();
        searchPage.enterSearchTerm("morcov"); // Write "morcov"
        searchPage.clickSearchButton(); // Click the search button
        searchPage.clickFirstItem(); // Click on the first item

        // Additional assertions can be added here to verify the item was found
    }

    @AfterEach
    void tearDown() {
        super.tearDown(); // Call tearDown from BaseTest
    }
}