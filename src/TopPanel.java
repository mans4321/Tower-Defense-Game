import javax.swing.*;


import java.awt.*;

/**
 * Created by yongpinggao on 1/30/16.
 */
public class TopPanel extends JPanel {

    private TowerSelectionPanel towerSelectionPanel;

    private DataPanel dataPanel;

    public TopPanel(){
        this.setLayout(new GridLayout(1,2));
        towerSelectionPanel = new TowerSelectionPanel();



        dataPanel = new DataPanel();
        dataPanel.setBackground(Color.WHITE);

        this.add(towerSelectionPanel);
        this.add(dataPanel);
    }

    public DataPanel getDataPanel() {
        return dataPanel;
    }

    public TowerSelectionPanel getTowerSelectionPanel() {

        return towerSelectionPanel;
    }
}