Feature: Automated EndToEndTest 
	Description : The purpose of this feature to test end 2 end integration .

Scenario Outline: : Customer place an order by purchasing an item from search 
	Given The user is in home page 
	When user search for "<productName>" 
	And  choose to buy two item 
	And  move to check out cart and enter personal details on checkout page and place the order 
	Then user can view the order and download invoice 
	
	Examples: 
		|productName|
		|Apple MacBook Pro 13-inch| 
		
