package tests;

import pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.webUtils;

public class BaseTest {
    protected WebDriver driver; // Declare driver as protected
    protected BasePage basePage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver(); // Initialize WebDriver
        basePage = new BasePage(driver); // Initialize BasePage with the WebDriver
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            try {
                driver.quit(); // Quit the driver after each test
            } catch (Exception e) {
                System.err.println("Error during driver quit: " + e.getMessage());
            } finally {
                driver = null; // Ensure driver is nullified
            }
        }
    }
}
