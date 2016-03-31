package controller;

import model.gamelog.Log;
import model.gamelog.LogType;
import model.gamelog.LoggerCollection;
import model.map.GameMapCollection;
import model.savegame.GameInfo;
import model.savegame.GameInfoCollection;
import view.gamechooseview.GameChooseView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by yongpinggao on 3/30/16.
 */
public class GameChooseController {
    GameChooseView gameChooseView;
    GameInfoCollection gameInfoCollection;
    GameMapCollection gameMapCollection;
    DefaultListModel listModel;

    /**
     * Gets the list of saved maps for the user to select the one he wants to play or edit
     */
    public GameChooseController() {
        listModel = new DefaultListModel();
        gameInfoCollection = GameInfoCollection.loadGamesFromFile();
        gameMapCollection = GameMapCollection.loadMapsFromFile();

        for (GameInfo gameInfo: gameInfoCollection.getSavedGames()) {
            for(String date: gameInfo.getSavedTimeList()) {
                listModel.addElement(gameInfo.getMapName() + "\t\t" + date);
            }
        }
        gameChooseView = new GameChooseView(listModel);

        /**
         * Sets listener to start game
         */
        gameChooseView.startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameChooseView.setVisible(false);

                //load -> edit -> save back
                GameInfo gameInfo = gameInfoCollection.getSavedGames().get(gameChooseView.list.getSelectedIndex());
                Date date = new Date();
                gameInfo.addPlayedTime(date);
                new MainGameController(gameMapCollection.getMaps().get(gameMapCollection.findGameMapInCollection(gameInfo.getMapName())), gameInfo).mainGameView.setVisible(true);
            }
        });
    }
}
