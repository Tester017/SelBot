Feature: Login For LeafTaps Application 
	
@test2	
Scenario Outline: TC001 Positive Login Flow 
	Given Enter the Username as <username> 
	And Enter the password as <password>
	When Click on the login button
	
	Examples: 
		|username|password|
		|DemoCSR|crmsfa| 
		|DemoSalesManager|crmsfa|
		

	
	
	
	
	
	
	
	
	
	
	
