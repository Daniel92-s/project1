package tests;

import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        loginPage = new LoginPage(driver); // Explicitly pass driver
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testValidLogin(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.acceptCookies();
        loginPage.navigateToLoginPage();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isUserLoggedIn(), "User should be logged in successfully.");
        System.out.println("User is logged in Succesfuly");
    }
}
