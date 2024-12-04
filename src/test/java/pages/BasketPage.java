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

    public void goToWebsite() {
        driver.get("https://www.agropataki.ro/ro/"); // Replace with actual URL
    }

    public void acceptCookies() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookiesplus-form > div.cookiesplus-actions.col-12.col-xs-12 > div.first-layer > div:nth-child(1) > div:nth-child(1) > button > span")));
        acceptButton.click();
    }


    public void navigateToCategories() {
        WebElement categoriesMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#header > div.ets_mm_megamenu.layout_layout2.show_icon_in_mobile.transition_fadeInUp.transition_floating.agro_mega_menu.sticky_enabled.ets-dir-ltr.hook-default.single_layout.disable_sticky_mobile > div > div > div > ul > li.mm_menus_li.mm_menus_li_tab.agro_products_menu.mm_sub_align_left.mm_has_sub.menu_ver_alway_show_sub > a")));
        categoriesMenu.click();
    }

    public void selectProduct() {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subcategories > ul > li:nth-child(4) > h5 > a")));
        categoryElement.click();
    }

    public void addItemToBasket() {
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list > div.products.product-thumbs.row > article:nth-child(1) > div > div.ttproduct-desc > div > div > div.an_productattributes > form > div.an_productattributes-qty-add.clearfix > div > button")));
        addToBasketButton.click();
    }

    public boolean isItemAddedMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myModalLabel")));
        return confirmationMessage.isDisplayed();
    }
}