Feature: User Registeration
Scenario: User can register in eCommerce
Given User in homePage
When User opens registeration Page
And User enter "Islam" , "Saber" , "Eslam@yahho.com" , "123456789"
Then Registeration Succesfuly displayed
