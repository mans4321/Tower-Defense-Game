package viewcontroller;
import javax.swing.*;

import gamemodel.tower.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private TowerSelectionListener slistener;
    private TowerChosenListener cListener;
    private TowerImageCollection towerImageCollection;
    
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
        // Starts with the first level of the tower
        TowerButton buttonTowerA = new TowerButton(towerImageCollection.getImageIcon(TowerId.TOWERAH.getName()));
        buttonTowerA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slistener.placeTower(TowerId.TOWERA1);
                cListener.updateInfo(TowerId.TOWERA1);
            }
        });


        TowerButton buttonTowerB = new TowerButton((towerImageCollection.getImageIcon(TowerId.TOWERBH.getName())));
        buttonTowerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slistener.placeTower(TowerId.TOWERB1);
                cListener.updateInfo(TowerId.TOWERB1);
            }
        });

        TowerButton buttonTowerC = new TowerButton((towerImageCollection.getImageIcon(TowerId.TOWERCH.getName())));
        buttonTowerC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slistener.placeTower(TowerId.TOWERC1);
                cListener.updateInfo(TowerId.TOWERC1);
            }
        });

        add(buttonTowerA);
        add(buttonTowerB);
        add(buttonTowerC);

    }
    
    /**
     * Register a listener
     * @param listener
     */
    public void addTowerSelectionListener(TowerSelectionListener listener) {
        this.slistener = listener;
    }

    /**
     * Register a listener
     * @param listener
     */
    public void addTowerChosenListener(TowerChosenListener listener) {
        this.cListener = listener;
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
