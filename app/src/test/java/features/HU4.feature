# new feature
# Tags: optional
    
Feature: Maximum lives
    
Scenario: Number of maximum Lives
    Given 3 lives at most
    When you lose the 3 lives
    Then the game ends