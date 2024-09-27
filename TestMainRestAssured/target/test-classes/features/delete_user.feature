Feature: Validate the delete request

  Scenario: Verify user can delete a user
    Given user wants to call the "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_user.json"
    When user performs post call
    Then verify status code is 201
    And check user id is not empty
    And store the user id into the "user.id"
    When user wants to call the "/users/@id" endpoint
    When user performs delete call
    Then verify status code is 204