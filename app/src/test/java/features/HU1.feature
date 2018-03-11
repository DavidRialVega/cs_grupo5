# new feature
# Tags: optional
    
Feature: Ball out
    
Scenario: Ball against the wall
    Given ball crashes
    When touch the edges
    Then the ball must bounce in another direction

