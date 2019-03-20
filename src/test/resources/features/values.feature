Feature: Calculator page verification

Scenario: Verify the right count of values
Given Number of values should be "5"
Then Each value are greater than "0"
Then Total balance is correct
Then Values are formated