//package tests;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//import pages.LoginPage;
//import pages.AccInfoPage;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class E2E_UserInformationTest extends BaseTest{
//    private LoginPage loginPage;
//    private AccInfoPage updateName;
//
//    @BeforeEach
//    void setup() {
//        super.setup(); // Call the setup method from BaseTest
//        loginPage = new LoginPage(driver); // Explicitly pass driver
//        updateName = new AccInfoPage();
//    }
//
//    @ParameterizedTest
//    @MethodSource("data.LoginDataProvider#validLoginData")
//    void testValidLogin(String loginEmail, String loginPassword) {
//        loginPage.goTo();
//        loginPage.acceptCookies();
//        loginPage.navigateToLoginPage();
//        loginPage.fillLoginForm(loginEmail, loginPassword);
//        loginPage.clickLoginButton();
//        loginPage.accountInformation();
//        loginPage.enterDetails();
//        updateName.updateName("Dumitru");
//
//
//        System.out.println("User details succesully edited");
//    }
//
//}


package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.AccInfoPage;


public class E2E_UserInformationTest extends BaseTest {
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
    void testValidLogin(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.acceptCookies();
        loginPage.navigateToLoginPage();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLoginButton();
        loginPage.accountInformation();
        loginPage.enterDetails();
        accInfoPage.updateName("Dumitru"); // Update the name
        accInfoPage.clickSaveButton(); // Save the changes (if necessary)

     }
}