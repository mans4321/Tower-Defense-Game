package controller;

import view.mapchooseview.MapChooseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Store.GameMapCollection;


/**
 * Controller for the map select view
 * @author yongpinggao
 * @version 1.0 3/12/16.
 */
public class MapChooseController {

    MapChooseView mapChooseView;
    GameMapCollection mapCollection;
    DefaultListModel listModel;

    /**
     * Gets the list of saved maps for the user to select the one he wants to play or edit
     */
    public MapChooseController() {
        listModel = new DefaultListModel();
        mapCollection = GameMapCollection.loadMapsFromFile();
        
        for (int i = 0; i < mapCollection.getMaps().size(); i++) {
            listModel.addElement(mapCollection.getMaps().get(i).getImageName());
        }

        mapChooseView = new MapChooseView(listModel);
        
        /**
         * Sets listener to start game
         */
        mapChooseView.startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapChooseView.setVisible(false);
                new MainGameController(mapCollection.getMaps().get(mapChooseView.list.getSelectedIndex())).mainGameView.setVisible(true);
            }
        });

        /**
         * Sets listener to edit map
         */
        mapChooseView.editMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapChooseView.setVisible(false);
                new MapEditorController(mapCollection.getMaps().get(mapChooseView.list.getSelectedIndex())).mapEditorView.setVisible(true);
            }
        });
    }
}