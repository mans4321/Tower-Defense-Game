package viewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import View.MainMenuWindow;
import gamemodel.gamemap.FileProcessing;
import gamemodel.tower.TowerChosenListener;
import gamemodel.tower.TowerId;
import gamemodel.tower.TowerManipulationListener;
import gamemodel.tower.TowerSelectionListener;

public class Listener implements ActionListener {

	private TowerManipulationListener towerListener;
    private TowerSelectionListener slistener;
    private TowerChosenListener cListener;
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		// see & upgrade Towers //TowerUpgradeSellPanel
		
		if(command.equals("sellTower")){
			
			towerListener.sellTower();
			
		}else if(command.equals("upgradeTower")){
			
			towerListener.upgradeTower();
		
			// Button Towers TowerSelectionPanel
			
		}else if (command.equals("buttonTowerA")){
		
			slistener.placeTower(TowerId.TOWERA1);
            cListener.updateInfo(TowerId.TOWERA1);
		
	   }else if (command.equals("buttonTowerB")){
		
		    slistener.placeTower(TowerId.TOWERB1);
            cListener.updateInfo(TowerId.TOWERB1);
           
       }else if(command.equals("buttonTowerC")){
    	   
    	    slistener.placeTower(TowerId.TOWERC1);
            cListener.updateInfo(TowerId.TOWERC1);
       
       }
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
     * Associated a listener for the manipulation of the tower
     * @param listener
     */
    public void addTowerManipulationListener(TowerManipulationListener towerListener) {  /// 
        this.towerListener = towerListener;
    }

	
}
