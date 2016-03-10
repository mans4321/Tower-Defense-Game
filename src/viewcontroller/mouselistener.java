//package viewcontroller;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import View.GameWindow;
//import gamemodel.gamemap.CellState;
//import gamemodel.tower.Tower;
//import gamemodel.tower.TowerFactory;
//import gamemodel.tower.TowerId;
//
//public class mouselistener implements MouseListener {
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		GameWindow gamewindo ;
//		
//		gamewindo.getGamePanel().getmap;
//		 int x = e.getX();
//         int y = e.getY();
//
//         int index = DrawMap.coordinateConverter(x, y, cols);
//         if (e.getButton() == MouseEvent.BUTTON1) { // User left click map cells
//
//             // 1. if it is "toPlaceTower" state:  toPlaceTower -> Tower state
//             if (cellList.get(index) == CellState.TOPLACETOWER) {
//
//                 cellList.set(index, CellState.TOWER);
//                 // current Tower ID is set by topPanel
//
//                 Tower tower = TowerFactory.getInstance().getTower(currentTowerID);
//                 int[] posArr = DrawMap.indexConverter(index, cols);
//
//                 if(tower == null)
//                 System.out.println("wtf" );
//                 
//                 // center of the cell
//                 tower.setPosX(posArr[0] + DrawMap.CELL_SIZE / 2);
//                 tower.setPosY(posArr[1] + DrawMap.CELL_SIZE / 2);
//                 towerMap.put(index,tower);
//
//                 placeTowerFinishedListener.accountShouldChange(currentTowerID);
//                 placeTowerFinishedListener.placeTowerFinished(index);
//
//                 // Change back to Grass state
//                 for(int i = 0; i < cellList.size(); i++) {
//                     if (cellList.get(i) == CellState.TOPLACETOWER) {
//                         cellList.set(i, CellState.GRASS);
//                     }
//                 }
//                 repaint();
//                 System.out.println("1");
//             }
//             // 2. if it is "Tower" state:  Tower state -> Chosen state
//             else if (cellList.get(index) == CellState.TOWER) {
//                 for(int i = 0; i < cellList.size(); i++) {
//                     if (cellList.get(i) == CellState.TOPLACETOWER) {
//                         cellList.set(i, CellState.GRASS);
//                     }
//                 }
//                 if (isChosen) {
//                     for(int i = 0; i < cellList.size(); i++) {
//                         if (cellList.get(i) == CellState.CHOSEN) {
//                             cellList.set(i, CellState.TOWER);
//                         }
//                     }
//                     isChosen = false;
//                 }
//                 isChosen = true;
//                 cellList.set(index, CellState.CHOSEN);
//
//                 currentChosenID = towerMap.get(index).getTid();
//                 listener.updateInfo(currentChosenID);
//                 repaint();
//                 System.out.println("2");
//             }
//             // 3. if it is "Chosen" state: Chosen state -> Tower State
//             else if (cellList.get(index) == CellState.CHOSEN) {
//                 cellList.set(index, CellState.TOWER);
//                 currentChosenID = TowerId.TOWERNULL;
//                 System.out.println("3");
//             }
//
//             // 4. Other Cells: Chosen state -> Tower state.
//             // ToPlaceTower state -> Grass state
//             else {
//                 // if the user press the wrong cells, aka path, etc.
//                 // set state back to grass
//                 for(int i = 0; i < cellList.size(); i++) {
//                     if (cellList.get(i) == CellState.CHOSEN) {
//                         cellList.set(i, CellState.TOWER);
//
//                     } else if (cellList.get(i) == CellState.TOPLACETOWER) {
//                         cellList.set(i, CellState.GRASS);
//                     }
//                 }
//                 currentChosenID = TowerId.TOWERNULL;
//                 listener.updateInfo(currentChosenID);
//                 System.out.println("4");
//                 repaint();
//             }
//             currentTowerID = TowerId.TOWERNULL;
//         }
//
//     }
//	
//	
//
//	@Override
//	public void mouseEntered(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
