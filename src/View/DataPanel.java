package View;
import javax.swing.*;
import java.awt.*;

/**
 * Class that implements the game panels
 * @author yongpinggao
 * @since 1/24/16
 * @see JLabel
 * @see JButton
 * 
 *
 */
public class DataPanel extends JPanel {

    private JLabel balanceLabel;
    private JLabel coinsLabel;
    private JLabel warningLabel;
    private JLabel waveStartLabel;
    private JLabel waveNumLabel;

    private String warningMsg;
    private double balance;
    private int coins;
    private int waveNum;
    private int totalWaveNum;

    private JButton exitButton;
    
    /**
     * getter for the exit button
     * @return
     */
    public JButton getExitButton() {
        return exitButton;
    }
    
    /**
     * Constructor sets the panels 
     */
    public DataPanel() {
        balance = 0;
        coins = 0;
        waveNum = 0;
        totalWaveNum = 0;
        warningMsg = "";

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        balanceLabel = new JLabel("");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,0,0);
        add(balanceLabel, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        coinsLabel = new JLabel("");
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10,10,0,0);
        add(coinsLabel, c);


        waveStartLabel = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,10,0,0);
        add(waveStartLabel, c);

        waveNumLabel = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10,10,0,0);
        add(waveNumLabel, c);

        warningLabel = new JLabel(warningMsg);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 0;
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        c.insets = new Insets(10,10,0,0);
        add(warningLabel, c);

        exitButton = new JButton("Quit");
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(0,0,0,10);  //top padding
        c.gridx = 1;
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 2;       //third row
        add(exitButton, c);
    }

    /**
     * Setter for the currency balance.
     * @param balance currency value
     */
    public void setBalance(double balance) {
        this.balance = balance;
        balanceLabel.setText("Balance: " + balance);
    }
    
    /**
     * Setter for the number of coins the player has.
     * @param coins number of life coins
     */
    public void setCoins(int coins) {
        this.coins = coins;
        coinsLabel.setText("Coin Left: " + coins);
    }

    /**
     * Setter for the number of the wave that is running.
     * @param waveNum number of the wave
     */
    public void setWaveNum(int waveNum) {
        this.waveNum = waveNum;
        waveStartLabel.setText("Wave " + waveNum + " starts!");
        waveNumLabel.setText("Wave: " + waveNum + "/" + totalWaveNum);
    }

    /**
     * Setter for the total number of waves for the game
     * @param totalWaveNum
     */
    public void setTotalWaveNum(int totalWaveNum) {
        this.totalWaveNum = totalWaveNum;
        waveNumLabel.setText("Wave: " + waveNum + "/" + totalWaveNum);
    }
    
    /**
     * Setter for warning messages
     * @param warningMsg
     */
    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg;
        this.warningLabel.setText(warningMsg);
    }
}
