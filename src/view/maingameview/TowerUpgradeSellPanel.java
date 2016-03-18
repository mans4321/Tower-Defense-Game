package view.maingameview;

import java.awt.*;
import javax.swing.*;
import model.imagecollection.TowerImageCollection;
import model.tower.Tower;
import protocol.DrawingPanelDelegate;

/**
 * Class for the side panel, upgrade and sell
 * @author yongpinggao 
 * @version 1.0 3/13/16
 */
public class TowerUpgradeSellPanel extends JPanel implements DrawingPanelDelegate {

    private Tower tower;
    public JButton sellButton;
    public JButton upgradeButton;
    public JLabel towerImageLabel;

    /**
     * Constructor for default panel.
     */
    public TowerUpgradeSellPanel() {
        setBackground(Color.black);
        tower = new Tower();
        sellButton = new JButton("Sell");
        upgradeButton = new JButton("Upgrade");
        towerImageLabel = new JLabel(new ImageIcon());

        setLayout(null);
        add(sellButton);
        add(towerImageLabel);
        add(upgradeButton);
        sellButton.setBounds(0, 0, 240, 58);
        towerImageLabel.setBounds(0, 58 , 240, 174);
        upgradeButton.setBounds(0, 231, 240, 58);
    }

    /**
     * Reloads the panel to use selected tower information.
     * @param tower selected tower from the towers on the map
     */
    @Override
    public void reloadPanelBasedOnTower(Tower tower) {
        if (tower != null) {
            this.tower = tower;
            towerImageLabel.setIcon(new ImageIcon(TowerImageCollection.towerImages.get(tower.getHighResolutionTowerImageName())));
        } else {
            towerImageLabel.setIcon(null);
        }
    }
}