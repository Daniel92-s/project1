package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://www.agropataki.ro/ro/"); // Replace with actual URL
    }

    public void acceptCookies() {
        WebElement acceptButton = driver.findElement(By.cssSelector("#cookiesplus-form > div.cookiesplus-actions.col-12.col-xs-12 > div.first-layer > div:nth-child(1) > div:nth-child(1) > button > span"));
        acceptButton.click();
    }

    public void navigateToLoginPage() {
        WebElement loginLink = driver.findElement(By.cssSelector("#_user_info > div > a"));
        loginLink.click();
    }

    public void fillLoginForm(String email, String password) {
        driver.findElement(By.cssSelector("#login-form > section > div:nth-child(2) > div.col-md-6 > input")).sendKeys(email);
        driver.findElement(By.cssSelector("#login-form > section > div:nth-child(3) > div.col-md-6 > div > input")).sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("#submit-login"));
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.cssSelector("#_user_info")).isDisplayed();
    }
}