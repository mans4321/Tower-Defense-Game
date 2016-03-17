package view.maingameview;

import protocol.DrawingDataPanelDelegate;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the Game data panel
 * @author yongpinggao
 * @version 1.0 3/13/16.
 */
public class GameDataPanel extends JPanel implements DrawingDataPanelDelegate {

    public JButton targetBasedOnWeakestButton;
    public JButton targetBasedOnStrongestButton;
    public JButton targetBasedOnNearestButton;

    public JLabel balanceLabel;
    public JLabel coinsLabel;
    public JLabel waveNumLabel;

    public JLabel infoLabel;
    public JButton waveStartButton;
    public JButton exitButton;

    /**
     * Constructor method creates the top panel with actions and information.
     */
    public GameDataPanel() {

        setLayout(new GridLayout(3,3));
        targetBasedOnWeakestButton = new JButton("TargetBasedOnWeakest");
        targetBasedOnStrongestButton = new JButton("TargetBasedOnStrongest");
        targetBasedOnNearestButton = new JButton("TargetBasedOnNearest");

        balanceLabel = new JLabel("balanceLabel");
        coinsLabel = new JLabel("coinsLabel");
        waveNumLabel = new JLabel("Wave: ");

        infoLabel = new JLabel("infoLabel");
        waveStartButton = new JButton("Next Wave");
        exitButton = new JButton("exitButton");

        add(targetBasedOnWeakestButton);
        add(targetBasedOnStrongestButton);
        add(targetBasedOnNearestButton);
        add(balanceLabel);
        add(coinsLabel);
        add(waveNumLabel);
        add(infoLabel);
        add(waveStartButton);
        add(exitButton);
    }

    /**
     * Refresh the info regading the number of current wave.
     * @param waveNum sequential number of wave
     */
    @Override
    public void reloadWaveDataView(int waveNum) {
        waveNumLabel.setText("Wave: " + waveNum + " now");
    }

    /**
     * Refresh the amount of gold in players bank account.
     * @param balance value of currency player is allowed to use
     */
    @Override
    public void reloadBalanceDataView(double balance) {
        balanceLabel.setText("Gold: " + balance);
    }

    /**
     * Refresh the amount of lives user still has.
     * @param coin number of lives left 
     */
    @Override
    public void reloadCoinDataView(int coin) {
        coinsLabel.setText("Coin left: " + coin);
    }

    /**
     * Displays new info to the player.
     * @param info info to be displayed to the player
     */
    @Override
    public void reloadInfoDataView(String info) {
        infoLabel.setText(info);
    }
}
