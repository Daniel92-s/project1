package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.AccInfoPage;

public class E2E_ChangePasswordTest extends BaseTest {
    private LoginPage loginPage;
    private AccInfoPage accInfoPage; // Renamed to match the class name

    @BeforeEach
    void setup() {
        super.setup(); // Call the setup method from BaseTest
        loginPage = new LoginPage(driver); // Explicitly pass driver
        accInfoPage = new AccInfoPage(driver); // Pass driver to AccInfoPage
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testChangePassword(String loginEmail, String loginPassword) {
        // Step 1: Go to the base URL and accept cookies
        loginPage.goTo();
        loginPage.acceptCookies();

        // Step 2: Navigate to the login page and log in
        loginPage.navigateToLoginPage();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLoginButton();

        // Step 3: Navigate to account information page
        loginPage.accountInformation();

        // Step 4: Fill out the password change form
        accInfoPage.clickCurrentPasswordField(); // Click to enter current password
        accInfoPage.inputCurrentPassword("$$$$$$$$"); // Replace with actual current password
        accInfoPage.clickNewPasswordField(); // Click to enter new password
        accInfoPage.inputNewPassword("$$$$$$$$"); // Replace with desired new password
        accInfoPage.clickAcceptTerms(); // Click to accept terms
        accInfoPage.saveInfo(); // Save the changes
        System.out.println("Password Changed Succesfully");


    }
}