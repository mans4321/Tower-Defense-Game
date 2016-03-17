package view.maingameview;

import java.awt.*;
import javax.swing.*;
import model.imagecollection.TowerImageCollection;
import model.tower.TowerName;

/**
 * Class to represent the panel view of a tower selection.
 * @author yongpinggao
 * @version 1.0 3/13/16
 */
public class TowerSelectionPanel extends JPanel {

    public JButton towerAButton;
    public JButton towerBButton;
    public JButton towerCButton;

    /**
     * Constructor for default panel. Starts buttons and set basic view properties
     */
    public TowerSelectionPanel() {
        towerAButton = new JButton(new ImageIcon(TowerImageCollection.towerImages.get(TowerName.TowerAH)));
        towerBButton = new JButton(new ImageIcon(TowerImageCollection.towerImages.get(TowerName.TowerBH)));
        towerCButton = new JButton(new ImageIcon(TowerImageCollection.towerImages.get(TowerName.TowerCH)));
        setLayout(new GridLayout(1,3));
        setBackground(Color.blue);
        add(towerAButton);
        add(towerBButton);
        add(towerCButton);
    }
}
