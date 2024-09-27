Feature: Validate the get request

  Scenario: Verify user can get a user
    Given user wants to call the "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_user.json"
    When user performs post call
    Then verify status code is 201
    And check user id is not empty
    And store the user id into the "user.id"
    When user wants to call the "/users/@id" endpoint
    When user performs get call
    Then verify status code is 200
#    And verify response is same as post call

  Scenario: Verify user can get list of user
    Given user wants to call the "/users?page=2" endpoint
    When user performs get call
    Then verify status code is 200