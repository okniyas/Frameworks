Feature: Validate the delete request

  Background:
    * def createUser = call read("classpath://features//create_user.feature")


  Scenario: Verify user can delete a user
    Given url host
    And path '/users'+createUser.response.id
    When method delete
    Then status 204
    And print response