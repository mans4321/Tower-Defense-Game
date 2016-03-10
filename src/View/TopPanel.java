package View;
import javax.swing.*;

import java.awt.*;

/**
 * Draws and manage the top panel for the game running
 * @author yongpinggao
 * @since 1/30/16
 */
public class TopPanel extends JPanel {

    private TowerSelectionPanel towerSelectionPanel;

    private DataPanel dataPanel;
    
    /**
     * Constructs the top panel where the tower can be bought from 
     */
    public TopPanel() {
        this.setLayout(new GridLayout(1,2));
        towerSelectionPanel = new TowerSelectionPanel();

        dataPanel = new DataPanel();
        dataPanel.setBackground(Color.WHITE);

        this.add(towerSelectionPanel);
        this.add(dataPanel);
    }
    
    /**
     * Getter for the data panel added
     * @return data panel
     */
    public DataPanel getDataPanel() {
        return dataPanel;
    }

    /**
     * Getter for the tower selectio panel
     * @return tower selection panel
     */
    public TowerSelectionPanel getTowerSelectionPanel() {

        return towerSelectionPanel;
    }
}