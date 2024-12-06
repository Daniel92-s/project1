package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Selectors
    private final By nameFieldSelector = By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6 > input");
    private final By saveButtonSelector = By.cssSelector("#customer-form > footer > button"); // Uncommented for future use
    private final By currentPasswordFieldSelector = By.cssSelector("#customer-form > section > div:nth-child(5) > div.col-md-6 > div > input"); // Adjust selector as needed
    private final By newPasswordFieldSelector = By.cssSelector("#customer-form > section > div:nth-child(6) > div.col-md-6 > div > input"); // Adjust selector as needed
    private final By acceptTermsSelector = By.cssSelector("#customer-form > section > div:nth-child(7) > div.col-md-6 > span"); // Adjust selector as needed
    private final By savePasswordButtonSelector = By.cssSelector("#customer-form > footer > button"); // Adjust selector as needed

    // Constructor
    public AccInfoPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize wait
    }

    // Existing Actions
    public void updateName(String newName) {
        WebElement nameField = driver.findElement(nameFieldSelector);
        nameField.clear();
        nameField.sendKeys(newName);
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonSelector).click(); // Click save button
    }

    // New Actions for Password Change
    public void clickCurrentPasswordField() {
        WebElement currentPasswordField = wait.until(ExpectedConditions.elementToBeClickable(currentPasswordFieldSelector));
        currentPasswordField.click(); // Click on the current password field
    }

    public void inputCurrentPassword(String currentPassword) {
        WebElement currentPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(currentPasswordFieldSelector));
        currentPasswordField.clear(); // Clear existing text
        currentPasswordField.sendKeys(currentPassword); // Input current password
    }

    public void clickNewPasswordField() {
        WebElement newPasswordField = wait.until(ExpectedConditions.elementToBeClickable(newPasswordFieldSelector));
        newPasswordField.click(); // Click on the new password field
    }

    public void inputNewPassword(String newPassword) {
        WebElement newPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(newPasswordFieldSelector));
        newPasswordField.clear(); // Clear existing text
        newPasswordField.sendKeys(newPassword); // Input new password
    }

    public void clickAcceptTerms() {
        WebElement acceptTerms = wait.until(ExpectedConditions.elementToBeClickable(acceptTermsSelector));
        acceptTerms.click(); // Click on accept terms button
    }

    public void saveInfo() {
        WebElement savePasswordButton = wait.until(ExpectedConditions.elementToBeClickable(savePasswordButtonSelector));
        savePasswordButton.click(); // Click on save button for password change
    }
}