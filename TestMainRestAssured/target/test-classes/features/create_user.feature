Feature: Validate the post request

  Scenario: Verify user can create a user
    Given user wants to call the "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_user.json"
    When user performs post call
    Then verify status code is 201