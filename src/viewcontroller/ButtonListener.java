//package viewcontroller;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import gamemodel.tower.TowerManipulationListener;
//
//public class ButtonListener implements ActionListener {
//
//	private TowerManipulationListener listener;
//	
//	public void actionPerformed(ActionEvent e) {
//		
//		String command = e.getActionCommand();
//		
//		if(command.equals("sellTower")){
//			
//			 listener.sellTower();
//		}else if (command.equals("upgradeTower")){
//			
//			listener.upgradeTower();
//		}
//	}
//	
//	 /**
//     * Associated a listener for the manipulation of the tower
//     * @param listener
//     */
//	public void addTowerManipulationListener(TowerManipulationListener listener) {  /// 
//        this.listener = listener;
//
//}
//	}