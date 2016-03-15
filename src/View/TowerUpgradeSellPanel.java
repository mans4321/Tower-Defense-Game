package View;
import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gamemodel.tower.TowerManipulationListener;
import viewcontroller.Listener;

/**
 * Class that implements the upgrade and sell panel
 * @author yongpinggao
 * @since 1/24/16
 */
public class TowerUpgradeSellPanel extends JPanel{

    private JButton bSell;
    private JButton bUpgrade;


    private JLabel towerImage;
    private ImageIcon icon;
    private Listener listener;
    
    /**
     * Constructor, creates buy and sell buttons and attach listeners 
     */
    public TowerUpgradeSellPanel() {
    	
    	listener = new Listener();
        bSell = new JButton("Sell");
        bSell.setActionCommand("sellTower");
        bSell.addActionListener(listener);
        
        bUpgrade = new JButton("Upgrade");
        bUpgrade.setActionCommand("upgradeTower");
        bUpgrade.addActionListener(listener);
        
       

        icon = null;
        towerImage = new JLabel(icon);

        placeComponents();
    }

    /**
     * Getter for the tower image
     */
    public JLabel getTowerImage() {
        return towerImage;
    }
    
    /**
     * Display panel components
     */
    public void placeComponents() {
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
   /**
    *getter for the sell and upgrade listener  
    * @return listener
    */
	public Listener getListener() {
		return listener;
	}
    
    
}
