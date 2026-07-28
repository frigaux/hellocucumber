Feature: Word wrap

  You write a class called Wrapper, that has a single static function named wrap that takes two arguments,
  a string, and a column number. The function returns the string,
  but with line breaks inserted at just the right places to make sure that no line is longer than the column number.
  You try to break lines at word boundaries.
  Like a word processor, break the line by replacing the last space in a line with a newline.

  Scenario Outline: Retour à la ligne automatique
    Given une chaine de caractère "<chaine>" ainsi qu'un nombre maximum de caractères par ligne <nbCaracteresMax>
    When on applique le retour à la ligne automatique
    Then on obtient la chaine "<chaineAvecRetourLigne>"

  Examples:
    | chaine                        | nbCaracteresMax | chaineAvecRetourLigne           |
    |                               | 4               |                                 |
    | Once                          | 4               | Once                            |
    | Once                          | 2               | On\nce                          |
    | Once                          | 1               | O\nn\nc\ne                      |
    | Once upon a time              | 9               | Once upon\na time               |
    | Once upon a time in Hollywood | 13              | Once upon a\ntime in\nHollywood |
