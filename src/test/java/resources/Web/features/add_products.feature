Feature: Add Products in Cart
  Background:
    Given launch chrome browser
    When Navigate to "https://automationexercise.com"
    And Click on "LoginSignUp_Icon" button
    And Enter correct Email and password
      | Email     | masti123@gmail.com    |
      | Password  | mastizone123          |
    And Click on "login_btn" button
    And Click on "Products" button

  @addtocart
  Scenario: Add Product to cart
    Given Verify that "All Products" is visible
    When Click on Search Product for "Tshirts" and search
    And Add "Pure Cotton V-Neck T-Shirt" Product to cart

  @addtocart
  Scenario Outline: Veiw Cart and Checkout Page for purchase order
    When Click on "Cart" button
    Then Verify that "Pure Cotton V-Neck T-Shirt" item is 1 and Quantity is 1
    
    When Click on "Proceed To Checkout" button
    Then Verify that "Address Details" is visible

    When Click on "Place Order" button
    And Fill details: "<Name>", <Card number>, <CVC>, <Expiration> and <Year>
    And Click on "Pay and Confirm Order" button
    Then Verify that "Congratulations! Your order has been confirmed!" is visible

   # When Click on "Download Invoice" button
    And Click on "Continue" button

    Examples:
      | Name       | Card number  | CVC     | Expiration   | Year    |
      | Mastizone  | 123456789    | 311     | 10           | 2030    |

    
