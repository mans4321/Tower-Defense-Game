package mapvalidation;

import java.util.ArrayList;
import java.util.HashMap;

import gamemodel.CellState;

/**
 * This class is to validate whether the number of Entrance or Exit is legal.
 * NO Entrance or Exit is illegal.
 * More than one Entrance or one Exit is illegal.
 * 
 * @author LiChong
 *
 */
public class NoEntranceNoExitMoreEntranceMoreExitValidator implements MapValidator{

	private ArrayList<CellState> cellList;
	int numberOfEntranceOrExit;
	
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
			numberOfEntranceOrExit++;
		}
		
		if(numberOfEntranceOrExit > 0){//invalidate
			return true;
		}else{
			return false;
		}
		
		
	}
	
	public NoEntranceNoExitMoreEntranceMoreExitValidator(int numberOfEntranceOrExit) {
		// TODO Auto-generated constructor stub
		this.numberOfEntranceOrExit = numberOfEntranceOrExit;
		
	}
	
	 
}
