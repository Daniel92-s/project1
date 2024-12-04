package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickProfileButton() {
        WebElement profileButton = driver.findElement(By.cssSelector("#_user_info > div"));
        profileButton.click();
    }

    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(By.cssSelector("#_user_info > ul > li:nth-child(2) > a > span"));
        logoutButton.click();
    }

    public boolean isLoggedOut() {
        try {
            return driver.findElement(By.cssSelector("#submit-login")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}