package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedOut() {
        try {
            return driver.findElement(By.cssSelector("#submit-login")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
