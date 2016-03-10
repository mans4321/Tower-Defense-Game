package View;
import javax.swing.*;

import gamemodel.tower.TowerId;
import gamemodel.tower.TowerImageCollection;

import java.awt.*;

/**
 * This class will hold the upgrades and sell info as well as specifications
 * @author yongpinggao
 * @since 1/30/16
 *
 */
public class EndPanel extends JPanel {

    private  TowerUpgradeSellPanel towerUpgradeSellPanel;
    private  TowerSpecificationPanel towerSpecificationPanel;

    private TowerId currentChosenTowerID;
    
    /**
     * Constructor starts the 'market' panel and the info panel
     */
    public EndPanel() {


        this.setLayout(new GridLayout(2,1));

        towerUpgradeSellPanel= new TowerUpgradeSellPanel();
        towerUpgradeSellPanel.setBackground(Color.BLACK);

        towerSpecificationPanel = new TowerSpecificationPanel();
        towerSpecificationPanel.setBackground(Color.WHITE);

        this.add(towerUpgradeSellPanel);
        this.add(towerSpecificationPanel);

    }
    
    /**
     * Getter for the info panel
     * @return
     */
    public TowerSpecificationPanel getTowerSpecificationPanel() {
        return towerSpecificationPanel;
    }
    
    /**
     * Getter for the market panel
     * @return
     */
    public TowerUpgradeSellPanel getTowerUpgradeSellPanel() {

        return towerUpgradeSellPanel;
    }
    
    /**
     * receives the tower object to be inspect, to show info and market
     * @param currentChosenTowerID
     */
    public void setCurrentChosenTowerID(TowerId currentChosenTowerID) {
        this.currentChosenTowerID = currentChosenTowerID;
        // Property Observer:
        String name = currentChosenTowerID.getName();
        String[] hName = name.split("_");
        if (hName.length > 0) {
            if (currentChosenTowerID == TowerId.TOWERNULL) {
                towerSpecificationPanel.clearPanel();
                towerUpgradeSellPanel.getTowerImage().setIcon(null);
            } else {
                towerUpgradeSellPanel.getTowerImage().setIcon(new TowerImageCollection().getImageIcon(hName[0] + "_high"));
            }
        }

    }

}