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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time for better reliability
    }

    public void goToWebsite() {
        driver.get("https://www.agropataki.ro/ro/"); // Replace with actual URL
    }

    public void acceptCookies() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookiesplus-form > div.cookiesplus-actions.col-12.col-xs-12 > div.first-layer > div:nth-child(1) > div:nth-child(1) > button > span")));
        acceptButton.click();
    }

    public void navigateToCategories() {
        try {
            // Wait until the categories menu is clickable
            WebElement categoriesMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#header > div.ets_mm_megamenu.layout_layout2.show_icon_in_mobile.transition_fadeInUp.transition_floating.agro_mega_menu.sticky_enabled.ets-dir-ltr.hook-default.single_layout.disable_sticky_mobile > div > div > div > ul > li.mm_menus_li.mm_menus_li_tab.agro_products_menu.mm_sub_align_left.mm_has_sub > a > span"))); // Simplified selector
            categoriesMenu.click(); // Click the categories menu
        } catch (Exception e) {
            System.err.println("Error navigating to categories: " + e.getMessage());
            // Optionally, take a screenshot or perform additional logging here
        }
    }

    public void selectProduse() {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subcategories > ul > li:nth-child(4) > h5 > a")));
        categoryElement.click();
    }
    public void selectsubProdus() {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subcategories > ul > li:nth-child(5) > h5 > a")));
        categoryElement.click();
    }

    public void addItemToBasket() {
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list > div.products.product-thumbs.row > article:nth-child(1) > div > div.ttproduct-desc > div > div > div.an_productattributes > form > div.an_productattributes-qty-add.clearfix > div > button")));
        addToBasketButton.click();
    }

    public void closeTab(){
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#blockcart-modal > div > div > div.modal-header > button > span")));
        categoryElement.click();
    }

    public void click() {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#_desktop_cart > div > div.header > a")));
        categoryElement.click();
    }

    public void click2(){
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#_desktop_cart > div > div.cart_block.block.exclusive > div > div > div.cart-buttons > a")));
        categoryElement.click();
    }

    public void QuantityUp(){
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > div > div.cart-grid-body.col-xs-12.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(1) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-6.qty > div > span.input-group-btn-vertical > button.btn.btn-touchspin.js-touchspin.js-increase-product-quantity.bootstrap-touchspin-up > i")));
        categoryElement.click();
    }

    public void RemoveItem(){
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > div > div.cart-grid-body.col-xs-12.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(1) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-2.col-xs-2.text-xs-right > div > a > i")));
        categoryElement.click();
    }

//    public boolean isItemAddedMessageDisplayed() {
//        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myModalLabel")));
//        return confirmationMessage.isDisplayed();
//    }
}