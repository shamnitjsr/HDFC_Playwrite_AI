Feature: Application Login Functionality

@sanity
Scenario Outline: Successful login with valid credentials

Given User navigates to login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

When User enters valid "<username>" and "<password>"

Then User should be redirected to the dashboard page

Examples:
  | username | password |
  | Admin    | admin123 |

