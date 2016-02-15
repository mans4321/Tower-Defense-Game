package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.CellState;


/**
 * This class is to validate whether Entrance is the neighbour of Exit.
 * If they are neighbours of each other, it is illegal.
 * 
 * @author LiChong
 *
 */
public class SeperateEntranceAndExitValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private int indexOfEntrance;
	private int indexOfExit;
	private int seaeCols;
	
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
	
	public SeperateEntranceAndExitValidator(int Cols){
		this.seaeCols = Cols;
	}
	
}
