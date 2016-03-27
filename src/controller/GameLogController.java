package controller;

import model.gamelog.LogType;
import model.gamelog.LoggerCollection;
import view.gamelogview.GameLogView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yongpinggao on 3/26/16.
 */
public class GameLogController {

    public GameLogView gameLogView;
    private Timer refreshTimer;
    private String log;
    private LogType currentLogType = LogType.Game;


    public GameLogController() {
        gameLogView = new GameLogView();
        refreshTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (currentLogType) {
                    case Game:
                        log = LoggerCollection.getInstance().showAllLog();
                        break;
                    case Tower:
                        log = LoggerCollection.getInstance().showAllTowerLog();
                        break;
                    case Wave:
                        log = LoggerCollection.getInstance().showWaveLog();
                        break;
                }
                gameLogView.logArea.setText("");
                gameLogView.logArea.append(log);
            }
        });

        refreshTimer.start();

        gameLogView.gameLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log = LoggerCollection.getInstance().showAllLog();
                currentLogType = LogType.Game;
            }
        });

        gameLogView.towerLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log = LoggerCollection.getInstance().showAllTowerLog();
                currentLogType = LogType.Tower;
            }
        });

        gameLogView.waveLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log = LoggerCollection.getInstance().showWaveLog();
                currentLogType = LogType.Wave;
            }
        });

    }


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
