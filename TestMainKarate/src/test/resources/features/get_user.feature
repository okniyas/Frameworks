Feature: Validate the get request


  Scenario: Verify user can get a user

    * def createUser = call read("classpath://features//create_user.feature")
    Given url host
    And path '/users/'+createUser.response.id
    When method get
    Then status 200
    And print response

  Scenario: Verify user can get list of user
    Given url host
    And path '/users'
    When method get
    Then status 200
    And print response