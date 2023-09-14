package applicationPages;

import env.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class CheckoutPage extends DriverUtil {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cart-order-summary")
    WebElement orderSumm;

    @FindBy(className = "checkout-buttons__checkout")
    WebElement checkOutButton;
    public void verifyOrderSummary(){
        // Confirm that the item is in the cart
        WebElement orderSummary = wait.until(ExpectedConditions.visibilityOf(orderSumm));
        if(orderSummary.getText().equalsIgnoreCase("Order Summary")){
            System.out.println("Pass");
        }
    }
    public void checkout(){
        wait.until(ExpectedConditions.visibilityOf(checkOutButton));
        closeDriver();
    }
}
