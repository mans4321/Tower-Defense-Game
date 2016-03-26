package view.maingameview;

import protocol.DrawingDataPanelDelegate;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yongpinggao on 3/13/16.
 */
public class GameDataPanel extends JPanel implements DrawingDataPanelDelegate{



    public JLabel balanceLabel;
    public JLabel coinsLabel;
    public JLabel waveNumLabel;

    public JLabel infoLabel;
    public JButton waveStartButton;
    public JButton showLogButton;
    public JButton saveGame;


    public GameDataPanel() {

        setLayout(new GridLayout(3,3));

        balanceLabel = new JLabel("balanceLabel");
        coinsLabel = new JLabel("coinsLabel");
        waveNumLabel = new JLabel("Wave: ");

        infoLabel = new JLabel("infoLabel");
        waveStartButton = new JButton("Game Start");
        showLogButton = new JButton("showLogButton");
        saveGame = new JButton("Save Game");
        
        add(balanceLabel);
        add(coinsLabel);
        add(waveNumLabel);
        add(waveStartButton);
        add(saveGame);
        add(showLogButton);
        add(infoLabel);

    }

    @Override
    public void reloadWaveDataView(int waveNum) {
        waveNumLabel.setText("Wave: " + waveNum + " now");
    }

    @Override
    public void reloadBalanceDataView(double balance) {
        balanceLabel.setText("Gold: " + balance);
    }


    @Override
    public void reloadCoinDataView(int coin) {
        coinsLabel.setText("Coin left: " + coin);
    }

    @Override
    public void reloadInfoDataView(String info) {
        infoLabel.setText(info);
    }

}
