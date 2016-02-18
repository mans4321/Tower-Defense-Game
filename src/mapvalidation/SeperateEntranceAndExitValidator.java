package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;


/**
 * This class is to validate whether Entrance is the neighbour of Exit.
 * If they are neighbours of each other, it is illegal.
 * 
 * @author LiChong
 * 
 * @version 1.1
 */
public class SeperateEntranceAndExitValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private int indexOfEntrance;
	private int indexOfExit;
	private int seaeCols;
	
	/**
	 * This method validate() overrides the method validate() of parent class MapValidator. 
	 * And it checks whether the entrance and exit are neighbour of each other.
	 * 
	 * @return boolean A boolean values that represent whether the entrance and exit are neighbour of each other.
	 * 
	 */	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < cellList.size(); i++){
			if(cellList.get(i) == CellState.ENTRANCE){
				indexOfEntrance = i;
			}else if(cellList.get(i) == CellState.EXIT){
				indexOfExit = i;
			}
		}
		
		if(indexOfEntrance - seaeCols == indexOfExit || indexOfEntrance + seaeCols == indexOfExit
				||indexOfEntrance - 1 == indexOfExit || indexOfEntrance + 1 == indexOfExit){
			return false;
		}else{
			return true;
		}
		
		
	}
	
	public SeperateEntranceAndExitValidator(int Cols, ArrayList<CellState> cellList){
		this.cellList = cellList;
		this.seaeCols = Cols;
	}
	
}
