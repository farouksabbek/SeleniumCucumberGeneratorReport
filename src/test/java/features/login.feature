Feature: test login

  @CoinHouse
  Scenario: test simple
    Given I go to the app
    When I add "tier_2.buyer@test.com" and "Thinkbigger12!"
    And click on login

  @TestProrp
  Scenario: test simple
    Given I go to the app
    When I connect to the app

  @Google
  Scenario Outline:
      Given I open the site
      When I add text  "<testa>" and "<testb>"
      And I click on search


      Examples:
        | testa | testb  |
        | aaaa  | _bbbbb |
        | ccccc | _ddddd |



