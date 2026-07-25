Feature: Dictionary replacer
  Create a method that takes a string and a dictionary,
  and replaces every key in the dictionary pre and suffixed with a dollar sign,
  with the corresponding value from the Dictionary.

  Scenario Outline: les clés d'une chaîne de caractères sont remplacées par leur valeur depuis le dictionnaire
    Given une chaine de caractère "<chaine>" avec des clés du dictionnaire "<dictionnaire>"
    When on remplace les clés par leur valeur depuis le dictionnaire
    Then on obtient la chaine de caractère suivante "<resultat>"

  Examples:
    | chaine                             | dictionnaire                 | resultat                               |
    |                                    |                              |                                        |
    | $temp$                             | temp:temporary               | temporary                              |
    | $temp$ here comes the name $name$  | temp:temporary,name:John Doe | temporary here comes the name John Doe |
    | $temp$ here comes the name $name$  | temp:temporary               | temporary here comes the name $name$   |
