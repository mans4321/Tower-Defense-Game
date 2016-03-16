#TowerDefenseGame_Group12

##Architectural

- MVC

### Packages 

- bankaccount
    1. defines the game’s whole money system;

- tower 
    1. defines all the tower model of the game
    2. all the towers inherit from a base class: Tower.java
    3. we use factory desgin pattern to "produce" Tower based on TowerID
    4. tower has to implemnt TowerShootingBehavior interface to define a tower's shooting behavior
    5. image collection save all the images of tower

- critter
    1.  defines all the critters in the game
    2.  all kinds of critter inherit from a base class: Critter.java
    3.  critter has to implement CritterBehavior interface to define how a critter moves

- gamemap
    1. defines all the issues related to game map
    2. handles all behavior of saving a game map to a JSON file
    3. handles all behavior of loading a game map pf a JSON file

- mapvalidation
    1. defines all the validate methods to validate a map
    2. we use a manager class to handle all the validation
    3. all the validator should implment MapValidator interface to define how to validate a map based on one specific problem

- wave
    1. defines how to generate all the waves for the whole game cycle
    
- utility
    1. defines some utilities to ease the development and make code more readable
    

- viewcontroller
    1. defines all the window and panel view
    2. We use observer design parttern to handle all the connections.
   
    
- controller
 1. defines all the game logic
   
    
