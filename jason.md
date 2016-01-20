##The basic logic of the application

1. The main menu part:
	1. map editor:
		* User can edit map by choosing map size of the game 
  		* We have to set the limit of the map size;
  		* We have to set the rules for map editing (e.g. the path can't be a circle and there is one entry point, one exit point, etc.);
  		* We have two buttons. One is to save the map; The other one is to cancel the editor without saving. 
  	2. Start game:
  		* After the user select the "game start", the user is allowed to choose a map from a map collection view to start the game.
  		* Everytime the user edit a map and choose "save", the map is saved to the map collection automatically.
  	3. End game:
  		* There is a "close" button to end the current game by user.(which will show up a alert like: Do you really want to exit?)
  		* The game will end when the exit point has reached to hit point limit (10 times). And it will show up an alert: Game Over and 
  		two buttons, one is for restart and the other is to back to main menu.
  		* After all the waves, the exit point "survived". It will show an alert saying: "Congratulation! You win!" and a button to back to the main menu.









