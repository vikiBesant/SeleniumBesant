Feature: Automate Bikewale website
Scenario: Comparison of ninja jawa and RE

Given Go to https://www.bikewale.com/
And Go to menu and click new bikes
And Click New Bikes then compare bikes
And Add first bike as Royal Enfield and model as Thunderbird 350
And Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI
And Add bike brand Kawasaki model as Ninja 300
And click compare
When Find and print the maximum overall rating of all the bikes and find the max