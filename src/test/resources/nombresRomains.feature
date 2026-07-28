Feature: Roman Numerals
  The Romans were a clever bunch. They conquered most of Europe and ruled it for hundreds of years.
  They invented concrete and straight roads and even bikinis [1]. One thing they never discovered though was the number zero.
  This made writing and dating extensive histories of their exploits slightly more challenging,
  but the system of numbers they came up with is still in use today.
  For example the BBC uses Roman numerals to date their programmes.

  The Romans wrote numbers using letters : I(1), V(5), X(10), L(50), C(100), D(500), M(1000).
  (notice these letters have lots of straight lines and are hence easy to hack into stone tablets)

  Scenario Outline:
    Given un nombre latin <nombre>
    When on applique la numérotation Romaine
    Then on obtient le nombre Romain "<resultat>"

  Examples:
    | nombre | resultat         |
    | 1      | I                |
    | 5      | V                |
    | 10     | X                |
    | 14     | XIV              |
    | 15     | XV               |
    | 50     | L                |
    | 100    | C                |
    | 500    | D                |
    | 1000   | M                |
    | 2      | II               |
    | 4      | IV               |
    | 7      | VII              |
    | 9      | IX               |
    | 40     | XL               |
    | 150    | CL               |
    | 400    | CD               |
    | 900    | CM               |
    | 666    | DCLXVI           |
    | 2002   | MMII             |
    | 1515   | MDXV             |
    | 4888   | MMMMDCCCLXXXVIII |
