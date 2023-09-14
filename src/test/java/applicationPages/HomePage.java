package applicationPages;

import env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage extends DriverUtil {
    public HomePage() {
        getDefaultDriver();
        WaitFor();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="gh-search-input")
    WebElement searchInput;
    @FindBy(className = "header-search-button")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@class='sku-item-list']")
    WebElement itemList;

    @FindAll({
        @FindBy(className = "sku-title")})
        public List<WebElement> descriptions;

    @FindBy(xpath = "//*[@data-button-state='ADD_TO_CART']")
    WebElement addToCart;

    @FindBy(className = "fulfillment-fulfillment-summary")
    WebElement getItTodaySection;

    @FindBy(className = "added-to-cart")
    WebElement addedToCartMsgTxt;

    @FindBy(className = "go-to-cart-button")
    WebElement goToCart;

    public void navigateToHomePage() {
        driver.get("https://www.bestbuy.com");
    }

    public void searchForItem(String searchItem) {
        // Find the search input element and enter the item to search
        searchInput.click();
        searchInput.sendKeys(searchItem);
        // Find and click the search button
        searchBtn.click();
    }

    public void waitForSearchResultsToLoad() {
        // Wait for search results to load
        wait.until(ExpectedConditions.visibilityOf(itemList));
    }

    public void clickTheSearchedItem(String description, String model, String price) {
        for (WebElement itemDescription : descriptions) {
            // get model and price by getting sibling of the name of item
            String itemModel = itemDescription.findElement(By.xpath("following-sibling::div//div[1]/span[@class='sku-value']")).getText();
            String itemPrice = itemDescription.findElement(By.xpath("ancestor::div[@class='list-item  lv']//div[@data-testid='customer-price']/span[1]")).getText();
            if (itemDescription.getText().equalsIgnoreCase(description)
                    && itemModel.equalsIgnoreCase(model)
                    && itemPrice.equalsIgnoreCase(price)) {
                itemDescription.click();
                break;
            }
        }
    }

    public void addItemToCart() {
        try {
            WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOf(addToCart));
            addToCartBtn.click();
        } catch (Exception e) {
            WebElement getItToday = wait.until(ExpectedConditions.visibilityOf(getItTodaySection));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getItToday);
            WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOf(addToCart));
            addToCartBtn.click();
        }
    }

    public void verifyMessage(String validationMessage) {
        WebElement addedToCartMsg = wait.until(ExpectedConditions.visibilityOf(addedToCartMsgTxt));
        if (addedToCartMsg.getText().equalsIgnoreCase(validationMessage)) {
            System.out.println("Message verified successfully");
        }
        WebElement goToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(goToCart));
        goToCartBtn.click();
    }
}
