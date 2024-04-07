Feature: Verifying contents and total price of the cart

  Background:
    Given I search and add the following Harry Potter books to the cart:
      | Book Title                                       | Price  |
      | Harry Potter and the Chamber of Secrets          | 235.00 |
      | Harry Potter and the Prisoner of Azkaban         | 213.00 |
      | Harry Potter and the Goblet of Fire              | 321.00 |
      | Harry Potter and the Order of the Phoenix        | 432.00 |
      | Harry Potter and the Half-Blood Prince           | 433.00 |


  Scenario: Adding Harry Potter books to the cart and verifying total price
    And each book has a quantity of 2 in the cart
    When I fetch the total cart price
    Then the total cart price should be accurately calculated considering the added books and quantities

  Scenario: Modifying item quantities and verifying updated total price
    When I modify the quantity of respective books
    Then the total cart price should be updated accordingly