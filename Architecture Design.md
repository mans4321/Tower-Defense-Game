#TowerDefenseGame_Group12

##Architectural

MVC

### Packages 

A- Boot

1- Launch the game.

B-  Bankaccount:

    1. Defines the game’s currency  system.

C- Tower:

    1. Defines all the tower model in the game.
    2. All the towers inherit from a base class: Tower.java.
    3. We used factory design pattern to "produce" Tower based on TowerID.
    4. Tower has to implement TowerShootingBehavior interface to define a tower's shooting behavior.
    5. We used a class called image collection to save all towers images. 

D- Critter:

    1.  Defines all the critters in the game.
    2.  All kinds of critter inherit from a base class: Critter.java.
    3.  Critter has to implement CritterBehavior interface to define how a critter moves.

E-  Gamemap:

    1. Defines all the issues related to game map.
    2. Handles all behavior of saving a game map to a JSON file.
    3. Handles all behavior of loading a game map pf a JSON file.

F- mapvalidation:

    1. Defines all the validation methods to validate a map.
    2. We use a manager class to handle all the validation.
    3. All the validator should implement MapValidator interface to define how to validate a map based on one specific problem.

G- Wave:

    1. Defines how to generate waves.
    2. Waves are built by using builder pattern.
    
H- Utility:

    1. Defines some utilities to ease the development and make code more readable.
    
I- View:

1.	Defines all the window and panel view.
2.	The panel are divided to three main panels, Main window, Game window, and Map Editor Window. 
3.	Game window is divided to four sections, Game Area, Tower Selection Area, Tower Specifications Area, and Data Area.
4.	Map Editor is dived to tow, map Editor Area, and Top Area to change map dimensions. 
  
J- Controller:

1.	Defines all the game logic including listeners for mouse press and button click.
2.	Control drawing  all the elements for all the panels  
3.	 Observer design pattern was used to notify the panels when change occurs.
    
K- UnitTesting: 

1.	Testing the game logic and functions 
