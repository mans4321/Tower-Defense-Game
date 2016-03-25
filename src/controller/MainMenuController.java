package controller;

import model.map.GameMap;
import model.map.GameMapCollection;
import model.map.SaveGame;
import view.mainmenuview.MainMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for the first menu where player can select to play or create a map.
 * @author yongpinggao 
 * @version 0.1 1/24/16.
 */
public class MainMenuController {

    MainMenuView mainMenuView;
    
    /**
     * Creates listeners for options in the main menu of the game.
     */
    public MainMenuController() {
        mainMenuView = new MainMenuView();
        
        /**
         * Sets listener for opening the map editor.
         */
        mainMenuView.editorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuView.setVisible(false);
                new MapEditorController(new GameMap()).mapEditorView.setVisible(true);
            }
        });
        
        /**
         * Sets listener for starting the game view.
         */
        mainMenuView.startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuView.setVisible(false);
                if (GameMapCollection.loadMapsFromFile() == null) {
                    JOptionPane.showMessageDialog(mainMenuView, "No Saved Maps, please go to the Map editor", "Error", JOptionPane.YES_OPTION);
                    mainMenuView.setVisible(false);
                    new MapEditorController(new GameMap()).mapEditorView.setVisible(true);
                } else {
                    new MapChooseController().mapChooseView.setVisible(true);
                }
            }
        });
        
        mainMenuView.loadGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 mainMenuView.setVisible(false);
				 if (SaveGame.loadGamesFromFile() == null) {
					 JOptionPane.showMessageDialog(mainMenuView, "No Saved games, please  play a game and Save it", "Error", JOptionPane.YES_OPTION);
			} else {
				new GameChooseController().gameChooseView.setVisible(false);
			}
			}
        });
    }
}