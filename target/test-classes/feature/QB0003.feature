Feature: we go the uc/login
  Scenario: we find verify code and enter the code
    Given 当我们的cidS是"c47igvr25cgwvd4kxt2nb0d"
    And 我们的apiS是"uc/login"
    And 我们的参数是scene
    When we go use the "post" method
    Then we assert the login result="000000"

  Scenario: we find verify code
    Given 当我们的cidS是"c47igvr25cgwvd4kxt2nb0d"
    And 我们的apiS是"uc/login"
    And 我们的参数是scene
    When we go use the "post" method
    Then we assert the login result="000001"