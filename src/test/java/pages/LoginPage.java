package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.cssSelector("#_user_info")).isDisplayed(); // Update selector if needed
    }
}
