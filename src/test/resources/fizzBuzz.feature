Feature: Jeu FizzBuzz

  Imagine the scene. You are eleven years old, and in the five minutes before the end of the lesson,
  your Maths teacher decides he should make his class more “fun” by introducing a “game”.
  He explains that he is going to point at each pupil in turn and ask them to say the next number in sequence,
  starting from one. The “fun” part is that if the number is divisible by three, you instead say “Fizz”
  and if it is divisible by five you say “Buzz”. So now your maths teacher is pointing at all of your classmates in turn,
  and they happily shout “one!”, “two!”, “Fizz!”, “four!”, “Buzz!”… until he very deliberately points at you,
  fixing you with a steely gaze... time stands still, your mouth dries up, your palms become sweatier and sweatier
  until you finally manage to croak “Fizz!”. Doom is avoided, and the pointing finger moves on.

  Scenario Outline: pour un nombre, l'élève doit dire
    Given un nombre <nombre>
    When on applique les règles du jeu FizzBuzz
    Then l'élève doit dire "<resultat>"

  Examples:
    | nombre | resultat |
    | 1      | 1        |
    | 2      | 2        |
    | 3      | Fizz     |
    | 4      | 4        |
    | 5      | Buzz     |
    | 6      | Fizz     |
    | 7      | 7        |
    | 8      | 8        |
    | 9      | Fizz     |
    | 10     | Buzz     |
    | 11     | 11       |
    | 12     | Fizz     |
    | 13     | 13       |
    | 14     | 14       |
    | 15     | FizzBuzz |
    | 16     | 16       |
    | 17     | 17       |
    | 18     | Fizz     |
    | 19     | 19       |
    | 20     | Buzz     |
