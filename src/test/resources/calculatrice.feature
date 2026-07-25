Feature: Calculatrice
  Codage d'une calculatrice qui prend en paramètre une chaine de caractères
  et procède à la somme des nombres qui la compose.

  Scenario Outline: une simple chaine de caractères contenant des nombres séparés par une virgule
    Given une chaine de caractères avec zéro ou plusieurs nombres "<chaine>" avec la virgule pour séparateur
    When on fait la somme des nombres à l'intérieure
    Then le résultat est <resultat>

  Examples:
    | chaine | resultat |
    |        | 0        |
    | 1      | 1        |
    | 1,2    | 3        |
    | 1,2,3  | 6        |

  Scenario Outline: autoriser les retours à la ligne comme séparateur
    Given une chaine de caractères avec zéro ou plusieurs nombres "<chaine>" avec la virgule et le retour à la ligne comme séparateur
    When on fait la somme des nombres à l'intérieure
    Then le résultat est <resultat>

  Examples:
    | chaine | resultat |
    | 1\n2,3 | 6        |

  Scenario Outline: interdir deux séparateurs à la suite
    Given une chaine de caractères "<chaine>" avec deux séparateurs à la suite
    When on fait la somme des nombres à l'intérieure
    Then une exception "<exception>" est levée

  Examples:
    | chaine | exception               |
    | 1,\n2  | ChaineInvalideException |

  Scenario Outline: autoriser un séparateur spécifique
    Given une chaine de caractères "<chaine>" avec un séparateur spécifique défini en début de chaine
    When on fait la somme des nombres à l'intérieure
    Then le résultat est <resultat>

  Examples:
    | chaine     | resultat |
    | //;\n1;2   | 3        |
    | //:\n1:2:3 | 6        |
    | //,\n3,4   | 7        |

  Scenario Outline: les nombres supérieurs à 1000 sont ignorés
    Given une chaine de caractères "<chaine>" avec un ou plusieurs nombres supérieurs à mille
    When on fait la somme des nombres à l'intérieure
    Then le résultat est <resultat>

  Examples:
    | chaine        | resultat |
    | 2,1001        | 2        |
    | 1001,10002,5  | 5        |

  Scenario Outline: un nombre négatif lève une exception
    Given une chaine de caractères "<chaine>" avec un ou plusieurs nombres négatifs
    When on fait la somme des nombres à l'intérieure
    Then une exception "<exception>" est levée avec le message "<message>"

  Examples:
    | chaine        | exception               | message                                    |
    | -2            | ChaineInvalideException | les nombres négatifs ne sont pas autorisés |
    | 2,-1001       | ChaineInvalideException | les nombres négatifs ne sont pas autorisés |

  Scenario Outline: le séparateur spécifique peut avoir n'importe quelle longueur
    Given une chaine de caractères "<chaine>" avec un séparateur spécifique de n'importe quelle longueur
    When on fait la somme des nombres à l'intérieure
    Then le résultat est <resultat>

  Examples:
    | chaine           | resultat |
    | //;;\n1;;2       | 3        |
    | //:::\n1:::2:::3 | 6        |
    | //,,,,\n3,,,,4   | 7        |
