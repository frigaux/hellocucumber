Feature: Employee report

  You’re building an employee management system of a local grocery store.
  The shop-owner wants to open the shop on Sunday and due to legal restrictions employees younger
  than 18 years are not allowed to work Sundays. The employee asks for a reporting feature
  so she can schedule work shifts. All employees are already stored somewhere and have the following properties :
  - name: string (the name of the employee)
  - age: number (the age in years of the employee)

  Rule:

      Scenario Outline: As shop owner I want to view a list of all employees who are 18 years or older so that I know who is allowed to work on Sundays.
        Given une liste d'employés "<liste>"
        When on demande la liste des employés qui ont au moins 18 ans
        Then on récupère la liste "<liste18>"

      Examples:
        | liste                                              | liste18                       |
        | Antoine:15,Benois:17,Christian:18,Denis:19,Eric:25 | Christian:18,Denis:19,Eric:25 |

      Scenario Outline: As shop owner I want the list of employees to be sorted by their name, so I can find employees easier.
        Given une liste d'employés "<liste>"
        When on demande le tri alphabétique de la liste
        Then on récupère la liste "<listeTriee>"

      Examples:
        | liste                                              | listeTriee                                         |
        | Benois:17,Christian:18,Antoine:15,Eric:25,Denis:19 | Antoine:15,Benois:17,Christian:18,Denis:19,Eric:25 |

      Scenario Outline: As shop owner I want the list of employees to be capitalized, so I can read it better.
        Given une liste d'employés "<liste>"
        When on demande la mise en majuscule de la liste
        Then on récupère la liste "<listeMajuscule>"

      Examples:
        | liste                                              | listeMajuscule                                     |
        | Benois:17,Christian:18,Antoine:15,Eric:25,Denis:19 | BENOIS:17,CHRISTIAN:18,ANTOINE:15,ERIC:25,DENIS:19 |

      Scenario Outline: As shop owner I want the employees to be sorted by their names descending instead of ascending.
        Given une liste d'employés "<liste>"
        When on demande le tri anti-alphabétique de la liste
        Then on récupère la liste "<listeTriee>"

      Examples:
        | liste                                              | listeTriee                                         |
        | Benois:17,Christian:18,Antoine:15,Eric:25,Denis:19 | Eric:25,Denis:19,Christian:18,Benois:17,Antoine:15 |
