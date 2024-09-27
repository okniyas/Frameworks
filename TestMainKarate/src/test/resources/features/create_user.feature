Feature: Validate the post request

  Background: 
    * def body = read("classpath://json//create_user.json")
    
  Scenario: Verify user can create a user
    Given url host
    And path '/users'
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request body
    When method post
    Then status 201
    And print response