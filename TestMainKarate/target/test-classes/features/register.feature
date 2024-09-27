Feature: Validate register request


  Scenario Outline: Verify user cannot register with invalid credentials
    Given url host
    And path '/register'
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request { email: '<email>', password: '<password>' }
    When method post
    Then status 400
    And print response

    Examples:
      | email              | password    |
      | test@gmail.com     | password    |
      | testdata@yahoo.com | password123 |
      | user12@gml.cm      | password323 |
      | admin@gmail.com    | admin123    |
