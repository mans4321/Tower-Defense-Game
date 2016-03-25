package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import model.map.GameMapCollection;
import model.map.SaveGame;
import view.gameChooseView.GameChooseView;
import view.mapchooseview.MapChooseView;


public class GameChooseController {

	GameChooseView gameChooseView;
    SaveGame savedgames;
    DefaultListModel listModel;
    
	public GameChooseController() {
		
		listModel = new DefaultListModel();
		savedgames = SaveGame.loadGamesFromFile();
	
	 for (int i = 0; i < savedgames.getGames().size(); i++) {
         listModel.addElement(savedgames.getGames().get(i).getGameName());
     }

	 gameChooseView = new GameChooseView(listModel);
     
     /**
      * Sets listener to start game
      */
     gameChooseView.startGameButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
//        	 gameChooseView.setVisible(false);
//             new MainGameController(savedgames.getGames().get(gameChooseView.list.getSelectedIndex())).mainGameView.setVisible(true);
         }
     });

}
}
