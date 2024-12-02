package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://www.agropataki.ro/ro/");
    }

    public void acceptCookies() {
        driver.findElement(By.cssSelector("#cookiesplus-form > div.cookiesplus-actions.col-12.col-xs-12 > div.first-layer > div:nth-child(1) > div:nth-child(1) > button > span")).click(); // Update with the actual cookie button ID or selector
    }

    public void navigateToLoginPage() {
        driver.findElement(By.cssSelector("#_user_info > div > a")).click();
    }

    public void fillLoginForm(String loginEmail, String loginPassword) {
        driver.findElement(By.cssSelector("#login-form > section > div:nth-child(2) > div.col-md-6 > input")).sendKeys(loginEmail);
        driver.findElement(By.cssSelector("#login-form > section > div:nth-child(3) > div.col-md-6 > div > input")).sendKeys(loginPassword);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("#submit-login")).click();
    }
}