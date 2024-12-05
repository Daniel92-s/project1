//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class AccountPage {
//    private WebDriver driver;
//
    // Selectors
//    private final By editButtonSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(4) > li:nth-child(2) > a");
//    private final By nameFieldSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.account-section.clearfix.col-sm-12.col-xs-12.col-lg-9.col-md-9 > form > div:nth-child(2) > input");
//    private final By saveButtonSelector = By.cssSelector("#Save");
//
    // Constructor
//    public AccountPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
    // Actions
//
//    public void updateName(String newName) {
//        WebElement nameField = driver.findElement(nameFieldSelector);
//        nameField.clear();
//        nameField.sendKeys(newName);
//    }
//
//
//    public void clickSaveButton() {
//        driver.findElement(saveButtonSelector).click();
//}
//}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccInfoPage {
    private WebDriver driver;

    // Selectors
    private final By nameFieldSelector = By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6 > input");
    private final By saveButtonSelector = By.cssSelector("#customer-form > footer > button"); // Uncommented for future use

    // Constructor
    public AccInfoPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
    }

    // Actions
    public void updateName(String newName) {
        WebElement nameField = driver.findElement(nameFieldSelector);
        nameField.clear();
        nameField.sendKeys(newName);
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonSelector).click(); // Click save button
    }
}