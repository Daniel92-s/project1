package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends BasePage {
    private final WebDriverWait wait;

    // Selectors
    private final By searchBarSelector = By.cssSelector("input#search_query_top"); // Adjust the selector as needed
    private final By searchButtonSelector = By.cssSelector("button.btn.btn-default.button-search"); // Adjust the selector as needed
    private final By addToBasketButtonSelector = By.cssSelector("#js-product-list > div.products.product-thumbs.row.produse_search > article:nth-child(1) > div > div.ttproduct-desc > div > div > div.an_productattributes > form > div.an_productattributes-qty-add.clearfix > div > button"); // Adjust the selector as needed
    private final By goToBasketButtonSelector = By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-6.divide-left > div > div > a"); // Adjust the selector as needed
    private final By firstNameFieldSelector = By.cssSelector("#shipping-new > div:nth-child(2) > div:nth-child(1) > div > input"); // Adjust the selector as needed
    private final By lastNameFieldSelector = By.cssSelector("#shipping-new > div:nth-child(2) > div:nth-child(2) > div > input"); // Adjust the selector as needed
    private final By addressFieldSelector = By.cssSelector("#shipping-new > div:nth-child(5) > div > input"); // Adjust the selector as needed
    private final By postalCodeFieldSelector = By.cssSelector("#shipping_post_code > div:nth-child(1) > div > input"); // Adjust the selector as needed
    private final By phoneFieldSelector = By.cssSelector("#shipping-new > div:nth-child(13) > div > input"); // Adjust the selector as needed
    private final By orderButtonSelector = By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div > div.checkout.cart-detailed-actions.card-block > div > a"); // Adjust the selector as needed
    private final By OrderSelector = By.cssSelector("#supercheckout_confirm_order");
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time for better reliability
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarSelector));
        searchBar.clear();
        searchBar.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonSelector));
        searchButton.click();
    }

    public void addProductToBasket() {
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(addToBasketButtonSelector));
        addToBasketButton.click();
    }

    public void goToBasket() {
        WebElement goToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(goToBasketButtonSelector));
        goToBasketButton.click();
    }

    public void fillCheckoutDetails(String firstName, String lastName, String address, String postalCode, String phone) {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFieldSelector));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFieldSelector));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);

        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(addressFieldSelector));
        addressField.clear();
        addressField.sendKeys(address);

        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeFieldSelector));
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);

        // Wait until the overlay is not visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pay-loader")));

        // Select country from dropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("s_id_country"))); // Selecting dropdown by ID
        countryDropdown.click(); // Click the dropdown to open it

        // Wait for country options to be visible and then select by ID
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#IT"))).click(); // Select the country option by ID (adjust as needed)

        // Select county from dropdown
        WebElement countyDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("s_id_state"))); // Selecting dropdown by ID
        countyDropdown.click(); // Click the dropdown to open it

        // Wait for county options to be visible and then select by ID
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#AN"))).click(); // Select the county option by ID (adjust as needed)

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFieldSelector));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void clickOrderButton() {
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(orderButtonSelector));
        orderButton.click();
    }

    public void clickOrder() {
        WebElement Order = wait.until(ExpectedConditions.elementToBeClickable(OrderSelector));
        Order.click();
    }


}