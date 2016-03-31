package controller;


import model.map.GameMap;
import model.map.GameMapCollection;
import model.savegame.GameInfo;
import model.savegame.GameInfoCollection;
import view.mapchooseview.MapChooseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Controller for the map select view
 * @author yongpinggao
 * @version 1.0 3/12/16.
 */
public class MapChooseController {

    MapChooseView mapChooseView;
    GameMapCollection mapCollection;
    DefaultListModel listModel;
    private boolean isOkToEdit;
    /**
     * Gets the list of saved maps for the user to select the one he wants to play or edit
     */
    public MapChooseController() {
        listModel = new DefaultListModel();
        mapCollection = GameMapCollection.loadMapsFromFile();

        
        for (int i = 0; i < mapCollection.getMaps().size(); i++) {
            listModel.addElement(mapCollection.getMaps().get(i).getMapName());
        }
        mapChooseView = new MapChooseView(listModel);


        /**
         * Sets listener to start game
         */
        mapChooseView.startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMap gameMap = mapCollection.getMaps().get(mapChooseView.list.getSelectedIndex());
                mapChooseView.setVisible(false);
                new MainGameController(gameMap).mainGameView.setVisible(true);
            }
        });

        /**
         * Sets listener to edit map
         */
        mapChooseView.editMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOkToEdit = true;
                GameMap gameMap = mapCollection.getMaps().get(mapChooseView.list.getSelectedIndex());
                //  If user has already saved a game, we should stop user editing this map again.
                GameInfoCollection gameInfoCollection = GameInfoCollection.loadGamesFromFile();
                if(gameInfoCollection != null) {
                    for(GameInfo gameInfo: gameInfoCollection.getSavedGames()) {
                        if(gameMap.getMapName().equals(gameInfo.getMapName())) {
                            JOptionPane.showMessageDialog(mapChooseView, "You cannot edit a game map which has been played and saved");
                            isOkToEdit = false;
                            break;
                        }
                    }

                }
                if(isOkToEdit) {
                    mapChooseView.setVisible(false);
                    gameMap.clearStateToPureMapState(); // Important! -> In case chosen state or to place tower state are saved to json File
                    new MapEditorController(gameMap).mapEditorView.setVisible(true);
                }
            }
        });
    }
}