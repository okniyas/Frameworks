Feature: Validate the update request

  Background:
    * def createUser = call read("classpath://features//create_user.feature")
    * def updateBody = read("classpath://json//update_user.json")


  Scenario: Verify user can update a user
    Given url host
    And path '/users/'+createUser.response.id
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request updateBody
    When method put
    Then status 200
    And print response