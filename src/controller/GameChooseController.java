package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.svaeGame.GameCollection;
import model.svaeGame.GameCollection2;
import view.mapchooseview.GameChooseView;


public class GameChooseController {

	GameChooseView gameChooseView;
    DefaultListModel listModel;
    
    GameCollection2 gameCollection;
    
	public GameChooseController() throws Exception {
		
		listModel = new DefaultListModel();
		gameCollection = new GameCollection2();
		gameCollection.readXMLFormate();
		
		int size = gameCollection.getGames().size();
		if(size > 0){
			for (int i = 0; i < size; i++) {
				listModel.addElement(gameCollection.getGames().get(i).getGameName());
			}

			gameChooseView = new GameChooseView(listModel);
			gameChooseView.setVisible(true);
			/**
			 * Sets listener to start game
			 */
			gameChooseView.startGameButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameChooseView.setVisible(false);
					new MainGameController(gameCollection.getGames().get(gameChooseView.list.getSelectedIndex())).mainGameView.setVisible(true);
				}
			});

		}
		else {
			JOptionPane.showMessageDialog(gameChooseView, "There is no Games please play and save");
			gameChooseView.setVisible(false);
			new MainMenuController().mainMenuView.setVisible(true);
		}
	}
}