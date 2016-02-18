package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;

/**
 * This class is to validate whether Entrance or Exit is in the middle of the path
 *
 * @version 1.2
 * 
 * @author LiChong
 *
 */
public class EntranceExitInMiddlePathValidator implements MapValidator {

	
	private ArrayList<CellState> cellList;
	private HashMap<Integer, Integer> countMap;
	
	/**
	 * This method validate() overrides the method validate() of parent class MapValidator. 
	 * And it checks whether the entrance or the exit locate in the middle of path.
	 * 
	 * @return boolean A boolean values that represent whether the entrance or the exit locate in the middle of path.
	 * 
	 */	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < cellList.size(); i++){
			if(cellList.get(i) == CellState.ENTRANCE){
				if(countMap.get(i) == 2) return false;
				else continue;
			} else if (cellList.get(i) == CellState.EXIT){
				if(countMap.get(i) == 2) return false;
				else continue;
			}
		}
		return true;
	}
	
/**
 * Class constructor  validate whether Entrance or Exit is in the middle of the path	
 * 
 * @param cellList   cell states of each cell
 * @param countMap
 */
	public EntranceExitInMiddlePathValidator(ArrayList<CellState> cellList, HashMap<Integer, Integer> countMap){
		this.cellList = cellList;
		this.countMap = countMap;
	}
	
	

}
