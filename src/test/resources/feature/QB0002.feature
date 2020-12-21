Feature: we go the uc_login
  Scenario: we find verify code
    Given 当我们的cid是"c47igvr25cgwvd4kxt2nb0d"
    And 我们的api是"sc/captcha/captcha"
    And 我们的参数是scene"uc_login"
    When we go the "post" method
    Then we assert the result="000000"

 Scenario: we find verify code
   Given 当我们的cid是"c47igvr25cgwvd4kxt2nb0d"
   And 我们的api是"sc/captcha/captcha"
   And 我们的参数是scene"uc_login"
   When we go the "post" method
   Then we assert the result="000001"