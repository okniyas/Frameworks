Feature: Validate the update request

  Scenario: Verify user can update a user
    Given user wants to call the "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_user.json"
    When user performs post call
    Then verify status code is 201
    And check user id is not empty
    And store the user id into the "user.id"
    When user wants to call the "/users/@id" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "update_user.json" using pojo
    When user performs put call
    Then verify status code is 200