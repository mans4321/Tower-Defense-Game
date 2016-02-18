package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.gamemap.CellState;

/**
 * This class is to validate whether the number of Entrance or Exit is legal.
 * NO Entrance or Exit is illegal.
 * More than one Entrance or one Exit is illegal.
 * 
 * @author LiChong
 * 
 * @version 1.1
 *
 */
public class NoEntranceNoExitMoreEntranceMoreExitValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	private int numberOfEntranceOrExit;
	
	/**
	 * This method validate() overrides the method validate() of parent class MapValidator. 
	 * And it checks whether the entrance and exit exists and whether the map just has one extrance and one exit.
	 * 
	 * @return boolean A boolean values that represent whether the entrance and exit exists and whether the map just has one extrance and one exit.
	 * 
	 */	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub

		int numberOfEntrance = 0;
		int numberOfExit = 0;

		for(int i=0;i<cellList.size();i++){
			if(cellList.get(i) == CellState.ENTRANCE) numberOfEntrance++;
			if(cellList.get(i) == CellState.EXIT) numberOfExit++;
		}
		
		if(numberOfEntrance == 0 || numberOfEntrance > 1 || numberOfExit == 0 || numberOfExit > 1){
			return false;
		} else {
			return true;
		}
		
	}
	
	public NoEntranceNoExitMoreEntranceMoreExitValidator(ArrayList<CellState> cellList) {
		// TODO Auto-generated constructor stub
		this.cellList = cellList;
	}
	
	 
}
