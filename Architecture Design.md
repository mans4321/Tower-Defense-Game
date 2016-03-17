#TowerDefenseGame_Group12

##Architectural

MVC

## Model
- Critter
    1. Defines all the critters in the game.
    2. All kinds of critter inherit from a base class: Critter.java.
    3. CritterCollection save all the critters for each wave
    4. Critter has a inner timer for keep counting times when it's attacted by tower with special effect.

- Tower
    1. Defines all the towers in the game.
    2. All kinds of towers are inherit from a base class: Tower.java
    3. Tower has to implement 2 interface: one os for shooting behavior, another is for shooting effect.
    4. TowerCollection is for save all the towers during the game
    5. Tower factory is applied to factory design pattern to produce tower as needed

- Map
    1. handels all gamemap in the game
    2. GameMapCollection saves all the maps that the user created



