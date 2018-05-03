# language: en
Feature: Test Login 


Scenario Outline: Login 
	Given I open the browser and go to the website login 
	When the user username "<user>" and password "<password>" 
	And the user press login button 
	Then the user should see the following text "<text>" 
	
	Examples: 
		|user|password|text|
		|111111Z|000000|Identifícate|
		|111111Z|123456|DashBoard:|