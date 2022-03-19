Feature: Text box
  Scenario Outline: Add simple information

    Given I have written my name "<name>"
    Given I have written my email "<email>"
    Given I have written my current address "<current>"
    Given I have written my perment addrrss "<perment>"
    When  I click the Submit button
    Then my contact information is displayed
    Examples:
    |name|email|current|perment|
    |Amina|Amina@gmail.com|vaxjo|host|
    |osman|osman@gmail.com|Tensta|jarva|



