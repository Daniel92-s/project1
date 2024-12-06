package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {
    private final WebDriverWait wait;

    // Selectors
    private final By searchBarSelector = By.cssSelector("#search_query_top"); // Adjust the selector as needed
//    private final By searchButtonSelector = By.cssSelector("#search_keyword"); // Adjust the selector as needed
    private final By searchButtonSelector = By.cssSelector("#searchbox > button");
    private final By firstItemSelector = By.cssSelector("#js-product-list > div.products.product-thumbs.row.produse_search > article:nth-child(1) > div > div.ttproduct-image > a > img"); // Adjust the selector as needed

    public SearchPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time for better reliability
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarSelector));
        searchBar.clear();
        searchBar.sendKeys(searchTerm);
        System.out.println("test writes morcov ");
    }

    public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonSelector));
        searchButton.click();
        System.out.println("test clicks the search bar");
    }

    public void clickFirstItem() {
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(firstItemSelector));
        firstItem.click();
        System.out.println("Item was selected");
    }
}