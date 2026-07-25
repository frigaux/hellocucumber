Feature: Codage du coeur du jeu "Attrape-moi si tu peux"
  Attrape-moi si tu peux est un jeu à deux joueurs.
  Les joueurs se déplacent sur une grille de taille 10 sur 10.
  Les deux joueurs font une action chacun à leur tour.
  À son tour, un joueur peut faire une des actions suivantes :
  - pivoter à gauche de 90° (tourner à gauche),
  - pivoter à droite de 90° (tourner à droite),
  - avancer d’une ou deux cases.

  Scenario Outline: Si un joueur avance en dehors du plateau, son déplacement est annulé.
    Given un joueur est en bordure : <x>, <y>, "<orientation>"
    When il avance en dehors du plateau "<nombreCases>"
    Then son déplacement est annulé : <x>, <y>, "<orientation>"

  Examples:
    | x | y | orientation | nombreCases |
    | 0 | 0 | NORD        | 1           |
    | 0 | 0 | OUEST       | 2           |
    | 9 | 9 | SUD         | 1           |
    | 9 | 9 | EST         | 2           |

  Scenario Outline: Si un joueur tourne, sa nouvelle orientation est correcte.
    Given un joueur dont l'orientation est "<orientation>"
    When il tourne en direction de "<direction>"
    Then sa nouvelle orientation est : "<nouvelleOrientation>"

  Examples:
    | orientation | direction | nouvelleOrientation |
    | NORD        | GAUCHE    | OUEST               |
    | OUEST       | GAUCHE    | SUD                 |
    | SUD         | GAUCHE    | EST                 |
    | EST         | GAUCHE    | NORD                |
    | NORD        | DROITE    | EST                 |
    | OUEST       | DROITE    | NORD                |
    | SUD         | DROITE    | OUEST               |
    | EST         | DROITE    | SUD                 |

  Scenario Outline: Si un joueur avance, sa nouvelle position est correcte.
    Given un joueur dont la position est <x1>, <y1> et l'orientation "<orientation>"
    When il avance de <nombreCases> cases
    Then son orientation est inchangée "<orientation>" et sa nouvelle position est : <x2> et <y2>

  Examples:
    | x1 | y1 | orientation | nombreCases | x2 | y2 |
    | 5  | 5  | OUEST       | 1           | 4  | 5  |
    | 5  | 5  | OUEST       | 2           | 3  | 5  |
    | 5  | 5  | SUD         | 1           | 5  | 6  |
    | 5  | 5  | SUD         | 2           | 5  | 7  |
    | 5  | 5  | EST         | 1           | 6  | 5  |
    | 5  | 5  | EST         | 2           | 7  | 5  |
    | 5  | 5  | NORD        | 1           | 5  | 4  |
    | 5  | 5  | NORD        | 2           | 5  | 3  |

  Scenario Outline: Le jeu indique si un joueur voit un autre joueur et à combien de cases il se situe. Un joueur ne voit que ce qui se trouve sur la ligne ou la colonne sur laquelle il est orienté.
    Given le premier joueur se situe : <x1>, <y1>, "<orientation1>"
    And le second joueur se situe : <x2>, <y2>, "<orientation2>"
    When le jeu examine si le premier joueur voit le second
    Then le jeu indique si le premier voit le second et à combien de cases : "<champDeVision>", <nombreCases>

  Examples:
    | x1 | y1 | orientation1 | x2 | y2 | orientation2 | champDeVision | nombreCases |
    | 4  | 4  | NORD         | 4  | 2  | NORD         | true          | 2           |
    | 4  | 4  | OUEST        | 2  | 4  | NORD         | true          | 2           |
    | 4  | 4  | SUD          | 4  | 6  | NORD         | true          | 2           |
    | 4  | 4  | EST          | 6  | 4  | NORD         | true          | 2           |

  Scenario Outline: Le jeu indique si un joueur a gagné.
    Given le premier joueur se situe : <x1> et <y1>
    And le second joueur se situe : <x2> et <y2>
    When le jeu examine si le premier joueur a gagné
    Then le jeu renvoie le résultat "<victoirePremierJoueur>"

  Examples:
    | x1 | y1 | x2 | y2 | victoirePremierJoueur |
    | 4  | 4  | 4  | 4  | true                  |
    | 4  | 4  | 2  | 4  | false                 |
