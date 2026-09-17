Feature: Bowling
  We can briefly summarize the scoring for this form of bowling:
  - each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
  - in each frame, the bowler gets up to two tries to knock down all the pins.
  - if in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
  - if in two tries he knocks them all down, this is called a “spare” and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
  - if on his first try in the frame he knocks down all the pins, this is called a “strike”. His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
  - if he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
  - the game score is the total of all frame scores.
  When scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss.

  Scenario Outline:
    Given les "<resultats>" d'une partie de bowling
    When on calcule le score
    Then on obtient le <score>

  Examples:
    | resultats                      | score |
    | X X X X X X X X X X X X        | 300   |
    | 9- 9- 9- 9- 9- 9- 9- 9- 9- 9-  | 90    |
    | 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 | 150   |
    | 9- 5/ X X X X X X X X X X      | 269   |
    | X 9- 9- 9- 9- 9- 9- 9- 9- 9-   | 109   |
    | 5/ 5/ 5/ X 5/ 5/ 5/ 5/ 5/ 5/5  | 160   |
