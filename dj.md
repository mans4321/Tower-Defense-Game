
# Description

## Map
* Map has to be validated
* Valid means entry point and end point are connected by a path
* Map sized will be chosen by user
* Map has to be saved to be played afterwards
* Path cells may contain only critters, and scenery cells may contain only towers
* Each cell has only one element at same time

## Game

* Selects map first
* Receives initial currency points
* Player will start the wave whenever ready
* Certain number of critters go through the path at a certain speed
* Towers shoot critters when in range
* Critters have a limited number of hitpoints and can be killed
* If all critters are destroyed wave is finished and player can prepare for the next wave.
* Limited number of waves

## Towers

* Bought and installed at any time
* Different types of tower, with different features and different costs
* Parameters
  * Range
  * Power
  * Rate of fire
  * Shoot effect
    * delay
    * area
    * etc
* User can inspect tower whenever wanted
* User can only buy when having credit
* Can only be placed on scenery cells
* Has a limited range
* Towers can be upgraded
* Towers can be sold, and consequetly, destroyed

## Critters

* Limited hitpoints
* Limited amount per wave
* User has to be allowed to inspect critters attributes
* User has to be allowed to inspect critters comming in the next wave
* Critter power increases 

# Questions

## Map
* What are the limits for map size, can we define that or should we just switch zooming to accomodate it?
* Is the path allowed to touch the limits of the map or we need to have a empty space between limit and path?
* Is the map public or belongs ta an specific user? User has to identify before starting ?

## Game

* Player wins after how may waves ?
* What options when player looses ?
  
## Critters
* What should change from wave to wave (critter power)?
  * Number of critters ?
  * Number of hitpoints in critters ?
  * new types of critters ?
* What are the characteristics of the critters ?
  * Speed
  * Hitpoint
  * Amount of critters
  * Armor resistance 
