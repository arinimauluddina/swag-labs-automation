Feature: Product Detail

  Scenario Outline: User Views Product Details and Adds to Cart
    Given user do login
    When the user selects a product <item_link_id> as item
    Then the user is taken to a product details page
    And the product details page displays the product's name, description, and price
    And the user can click the Add to cart button
    And the number of products in the cart icon increases by 1 in the top right corner

    Examples:
      | product_id | item_link_id      |
      | 4          | item_4_title_link |