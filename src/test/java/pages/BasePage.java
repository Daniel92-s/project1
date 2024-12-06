package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) { // Constructor that accepts a WebDriver
        this.driver = driver; // Assign the WebDriver to the class variable
    }


    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set to null to allow reinitialization in future tests if needed
        }
    }
}