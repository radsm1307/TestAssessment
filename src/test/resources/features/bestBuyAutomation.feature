Feature: Shopping at best buy

  Scenario Outline: I login with valid credential
    Given I open the BestBuy website
    And I search for "<Phone>" in the top search bar and click the search icon
    And I wait for the search results to load
    When I find an item with a "<Description>", "<Model>", "<Price>"
    Then I click on Add to Cart
    And I verify that a popup appears with the text "ValidationMessage"
    And I verify that I am on the Cart page by validating the presence of "Order Summary"
    And I click the checkout button
    Examples:
      | Phone     | Description                                                    | Model     | Price   |ValidationMessage|
      | Iphone 13 | Apple - Pre-Owned iPhone 13 Pro 5G 128GB (Unlocked) - Graphite | A2483-GRY | $879.99 |Added to cart    |
      | Iphone 12 | Apple - iPhone 12 5G 64GB (Unlocked) - Black                   | MGF43LL/A | $629.99 |Added to cart    |

