package stepDefinition;

import applicationPages.CheckoutPage;
import applicationPages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class UserStepDefinitions {

	HomePage homePage = new HomePage();
	CheckoutPage checkoutPage = new CheckoutPage();
	
	@Given("I open the BestBuy website")
	public void openBestBuyWebsite() {
		homePage.navigateToHomePage();
	}

	@And("^I search for \"([^\"]*)\" in the top search bar and click the search icon$")
	public void iSearchFor(String Phone) {
		homePage.searchForItem(Phone);
	}

	@And("^I wait for the search results to load$")
	public void iWaitForTheSearchResultsToLoad() {
		homePage.waitForSearchResultsToLoad();
	}

	@When("^I find an item with a \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void iFindAnItemWithADescriptionModelPrice(String description, String model, String price) {
		homePage.clickTheSearchedItem(description, model, price);
	}

	@Then("^I click on Add to Cart$")
	public void iClickOnAddToCart() {
		homePage.addItemToCart();
	}

	@And("^I verify that a popup appears with the text \"([^\"]*)\"$")
	public void iVerifyThatAPopupAppearsWithTheText(String validationMessage) throws Throwable {
		homePage.verifyMessage(validationMessage);
	}

	@And("^I verify that I am on the Cart page by validating the presence of \"([^\"]*)\"$")
	public void iVerifyThatIAmOnTheCartPageByValidatingThePresenceOf(String arg0) throws Throwable {
		checkoutPage.verifyOrderSummary();
	}

	@And("^I click the checkout button$")
	public void iClickTheCheckoutButton() {
		checkoutPage.checkout();
	}

}
