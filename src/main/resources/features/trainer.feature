Feature: Training for Lingo
  as a user,
  I want to practice for Lingo by trying to guess 5-, 6- or 7 letter words,
  In order to get better at playing Lingo

Scenario: Start new game
  When I press the play button
  Then I should be able to play a new game

Scenario Outline: Start a new round
  Given I am playing a game
  And the round was won
  And the last word had "<previous length>" letters
  When I start a new round
  Then the word to guess has "<next length>" letters

  Examples:
  |previous length | next length|
  | 5 | 6 |
  | 6 | 7 |
  | 7 | 5 |

  # Failure path
  Given I am playing a game
  And the round was lost
  Then I cannot start a new round

Scenario Outline: Guessing a word
  Given I am playing a game
  And the round has started
  When I fill in a "<word>"
  Then the game checks if the letters in "<word>" correspond to the letters in "<answer>"
  Then the game tells me if it's "<response>"
  When the "<response>" is INVALID I have to fill in a new "<word>"
  When the "<response>" is ABSENT the next "<round>" starts
  When the "<response>" is PRESENT the game puts the correct letter on the correct "<position>"
  When the "<response>" is CORRECT the game ends

  Examples:
  | round | word | response | position | answer |
  |1      | TEST | ABSENT, CORRECT, CORRECT, CORRECT| .EST     | BEST |
  |2      | MEST | ABSENT, CORRECT, CORRECT, CORRECT   | .EST     | BEST |
  |3      | VEST | ABSENT, CORRECT, CORRECT, CORRECT   | .EST     | BEST |
  |4      | BEST | CORRECT, CORRECT, CORRECT, CORRECT   | BEST     | BEST |

  # Failure path
  Given I am playing a game
  And I haven't won in 6 rounds
  Then I lose the game

