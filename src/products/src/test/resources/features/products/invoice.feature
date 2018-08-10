@now
Feature: Products invoice price and sales tax 
  Test to list a set of products and view invoice products price and sales tax 
  I want to list the created products 
  So that I need to call products list facade with no filters and after check products price and sales tax 
 
  Scenario: List ALL invoice product objects after creation
   	Given existing 3 products in database
  	When run list products, after products creation process
    Then the facade should return "29.83" price And  "1.5" sales tax
 
  Scenario: List ALL invoice product objects after creation
   	Given existing 2 products in database
  	When run list products, after products creation process
    Then the facade should return "65.15" price And  "7.65" sales tax
  
  Scenario: List ALL invoice product objects after creation
   	Given existing 4 products in database
  	When run list products, after products creation process
    Then the facade should return "74.68" price And  "6.7" sales tax
    
  Scenario: List ALL invoice product objects after creation
   	Given existing 0 products in database
  	When run list products, after products creation process
    Then the facade should return "0.0" price And  "0.0" sales tax
            