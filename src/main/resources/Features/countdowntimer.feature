Feature: As a user i want to verify the count down timer
@smoketest
Scenario: verify the count down timer
		  	Given I open the URL "https://e.ggtimer.com/"
		   	When I enter timer as "25"
		   	And I click on start button
		   	Then i should see the timer count down from "25"     
  
  
   
