package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToWebsite() {
        driver.get("https://www.agropataki.ro/ro/");
    }

    public void acceptCookies() {
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookiesplus-form > div.cookiesplus-actions.col-12.col-xs-12 > div.first-layer > div:nth-child(1) > div:nth-child(1) > button"))); // Confirm correct selector
        cookieButton.click();
    }

    public void navigateToCategories() {
        WebElement categoriesButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#header > div.ets_mm_megamenu.layout_layout2.show_icon_in_mobile.transition_fadeInUp.transition_floating.agro_mega_menu.sticky_enabled.ets-dir-ltr.hook-default.single_layout.disable_sticky_mobile > div > div > div > ul > li.mm_menus_li.mm_menus_li_tab.agro_products_menu.mm_sub_align_left.mm_has_sub > a"))); // Update selector
        categoriesButton.click();
    }

    public void selectProduct() {
        WebElement productItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subcategories > ul > li:nth-child(5) > h5 > a"))); // Update selector
        productItem.click();
    }

    public void selectProduct2() {
        WebElement productItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subcategories > ul > li:nth-child(1) > h5 > a"))); // Update selector
        productItem.click();
    }

    public void addItemToBasket() {
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list > div.products.product-thumbs.row > article:nth-child(1) > div > div.ttproduct-desc > div > div > div.an_productattributes > form > div.an_productattributes-qty-add.clearfix > div > button"))); // Update selector
        addToBasketButton.click();
    }

    public boolean isItemAddedMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myModalLabel"))); // Update selector
        return confirmationMessage.isDisplayed();
    }
}
