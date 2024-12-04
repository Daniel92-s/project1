package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage extends BasePage {
    private final WebDriverWait wait;

    public BasketPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectProduct(String category) {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(category)));
        categoryElement.click();
    }

    public boolean isItemAddedMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myModalLabel")));
        return confirmationMessage.isDisplayed();
    }
}
