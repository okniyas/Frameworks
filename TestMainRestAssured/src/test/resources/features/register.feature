Feature: Validate register request


  Scenario Outline: Verify user cannot register with invalid credentials
    Given user wants to call the "/register" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "register.json" with username "<email>" and password "<password>"
    When user performs post call
    Then verify status code is 400

    Examples:
      | email              | password    |
      | test@yhl.com       | password    |
      | testdata@gmail.com | password123 |
      | user12@gmal.cm     | password323 |
      | test13s@yahoo.com  | Admin!23    |
