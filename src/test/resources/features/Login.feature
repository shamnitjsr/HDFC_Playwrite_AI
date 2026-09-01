Feature: Apllication Login Functionlality

  Scenario Outline: Successful login with Valid credentials
    Given User navigates to login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters valid "<username>" and "<password>"
    Then User should be redirected to the dashboard page

  Example:
    	|username|password|
    	|Admin|admin123|
