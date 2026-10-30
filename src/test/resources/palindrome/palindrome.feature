Feature: Palindrome
  Un palindrome est un mot, un groupe de mots, une phrase ou un nombre qui se lit de la même manière de gauche
  à droite et de droite à gauche.
  Les espaces, les accents et la ponctuation sont généralement ignorés lors de sa lecture.

  Scenario Outline:
    Given un mot "<mot>"
    When on génère un palindrome
    Then on récupère le palindrome "<palindrome>"

    Examples:
      | mot       | palindrome |
      | ressasser | ressasser  |
      | ressasse  | ressasser  |
      | ressass   | ressasser  |
      | ressas    | ressasser  |
      | ressa     | ressasser  |
