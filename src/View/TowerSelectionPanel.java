package View;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import gamemodel.tower.TowerChosenListener;
import gamemodel.tower.TowerId;
import gamemodel.tower.TowerImageCollection;
import gamemodel.tower.TowerSelectionListener;
import viewcontroller.Listener;

/**
 * Class that describes the tower selection panel
 * @author yongpinggao
 * @since 1/24/16
 *
 */
public class TowerSelectionPanel extends JPanel {

    private GridLayout layout;
    private int tRows;
    private int tCols;
    private TowerImageCollection towerImageCollection;
    private Listener listener; 
    
    /**
     * Constructor creates basic 3 tower selection
     */
    public TowerSelectionPanel() {
        tRows = 1;
        tCols = 3;
        layout = new GridLayout(tRows, tCols);
        setBackground(Color.BLUE);
        setLayout(layout);
        towerImageCollection = new TowerImageCollection();
        initComponents();

    }
    
    /**
     * Creates a button for each tower displaying it's image
     */
    void initComponents() {
    	
    	listener = new Listener();
    	
        // Starts with the first level of the tower
        TowerButton buttonTowerA = new TowerButton(towerImageCollection.getImageIcon(TowerId.TOWERAH.getName()));
        buttonTowerA.setActionCommand("buttonTowerA");
        buttonTowerA.addActionListener(listener);


        TowerButton buttonTowerB = new TowerButton((towerImageCollection.getImageIcon(TowerId.TOWERBH.getName())));
        buttonTowerB.setActionCommand("buttonTowerB");
        buttonTowerB.addActionListener(listener);
           

        TowerButton buttonTowerC = new TowerButton((towerImageCollection.getImageIcon(TowerId.TOWERCH.getName())));
        buttonTowerC.setActionCommand("buttonTowerC");
        buttonTowerC.addActionListener(listener);

        add(buttonTowerA);
        add(buttonTowerB);
        add(buttonTowerC);

    }

    /**
     * getter for sell and upgrade listener
     * @return listener 
     */
    public Listener getListener() {
		return listener;
	}


	/**
     * Displays the associated image to the tower button
     * @author yongpinggao
     *
     */
    private class TowerButton extends JButton {
        private ImageIcon towerImageIcon;

        public TowerButton(ImageIcon towerImageIcon) {
            super("", towerImageIcon);
            this.towerImageIcon = towerImageIcon;
        }
    }


}
