@e2e
Feature: Job Search
User want to search jobs and navigate to different pages

@verifyJobPageRender
Scenario: To verify that jobs page renders correctly with the following components visible:
    1. navigation bar
    2. search fields
    3. sector lists
Given user navigates to homepage.
Then jobs page renders correctly

@verifySignInCreateAccount
Scenario: To verify Both 'Sign in' and 'Create account' links go to their respective pages
Given user navigates to homepage.
When user clicks Sign in.
Then user navigates to sign in page.
When user clicks Create account.
Then user navigates to create account page.

@verifyNavigationBar
Scenario: To verify each of the links in the navigation bar is functional and goes to the correct page
Given user navigates to homepage.
When user verify navigation bar .
Then navigation bar should have all the links functional.
And user goes to the correct page on clicking.


@verifySectorJob
Scenario: To verify sector on home page and clicking further on a job listing should show the job details, with an 'apply' button.
Given user navigates to homepage.
And user verify sector section is visible on home page.
When user click on one of the link.
Then user see job details, with an apply button.

@verifySearch
Scenario: To verify searching for a job correctly displays relevant search results.
Given user navigates to homepage.
And user can see the search bar
When user search for the job
|   keyword   | location              | radius |
|   Director  | United Kingdom (GB)   |   5    |
|   Professor | United States         |   10    |
Then user relevant details from the serach results


