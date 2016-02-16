package viewcontroller;
import javax.swing.*;

import gamemodel.tower.TowerManipulationListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yongpinggao on 1/24/16.
 */
public class TowerUpgradeSellPanel extends JPanel{

    private JButton bSell;
    private JButton bUpgrade;


    private JLabel towerImage;
    private ImageIcon icon;

    private TowerManipulationListener listener;

    public TowerUpgradeSellPanel(){

        bSell = new JButton("Sell");
        bSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.sellTower();
            }
        });
        bUpgrade = new JButton("Upgrade");
        bUpgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.upgradeTower();
            }
        });

        icon = null;
        towerImage = new JLabel(icon);

        placeComponents();
    }



    public JLabel getTowerImage() {
        return towerImage;
    }

    public void placeComponents(){
        setLayout(null);
        add(bSell);
        add(towerImage);
        add(bUpgrade);

        // absolute layout:
        // width: 240; height: 289
        // button height: 58
        // image size: 240 * 174
        bSell.setBounds(0, 0, 240, 58);
        towerImage.setBounds(0, 58 , 240, 174);
        bUpgrade.setBounds(0, 231, 240, 58);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void addTowerManipulationListener(TowerManipulationListener listener){
        this.listener = listener;
    }
}
