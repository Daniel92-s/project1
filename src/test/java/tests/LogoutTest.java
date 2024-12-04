package tests;

import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.LogoutPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testLogout(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.acceptCookies();
        loginPage.navigateToLoginPage();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLoginButton();

        logoutPage.clickProfileButton();
        logoutPage.clickLogoutButton();

        assertTrue(logoutPage.isLoggedOut(), "User should be logged out successfully.");
    }
}